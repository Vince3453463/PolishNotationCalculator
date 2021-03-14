package meinprojekt;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;


public class Calculator {
	private Stack<Operand> stack;
	
	
	public Calculator() {
		this.stack = new Stack<Operand>();
	}
	public void lex(String input) {
		StringTokenizer tokenizer = new StringTokenizer(input, " "); //trennen bei jedem Leerzeichen
		while(tokenizer.hasMoreTokens() ) { // "a + b" -> "a" "+" "b"
			String token = tokenizer.nextToken();
			this.parse(token);
		}
		
	}
	public void print() {
		try {
			System.out.println(this.stack.peek().value ) ;
		}
		catch(NoSuchElementException e ) {
			System.out.println("NEEEE" );
		}
	}
	public void parse(String token) { //converts Strings to Doubles 
		
		if(token.equals("+") ) {
			this.performBinary((a,b) -> new Operand(a.value + b.value ));	
			return; // um abzubrechen; + soll nicht als Zahl aufgefasst werden;
		}
		else if (token.equals("-")) {
			this.performBinary((a,b) -> new Operand (a.value - b.value ));
			return;
			
		}
		else if (token.equals("*")) {
			this.performBinary((a,b) -> new Operand (a.value * b.value ));
			return;
		}
		else if (token.equals("/")) {
			this.performBinary((a,b) -> new Operand (a.value / b.value ));
			return;
		}
		else if (token.equals("sin")) {
			this.performUnary((a) -> new Operand (Math.sin(a.value)));
			return;
		}
		
		try {
			double value = Double.parseDouble(token);
			Operand insert = new Operand(value);
			this.stack.push(insert); // Folge von Zahlen ist auf dem Stack
		}
		catch (NumberFormatException e) {
			System.out.println("Input can not be interpreted as a number.");
		}
	}
	
	public void performBinary(BinaryOperation<Operand> g) {
		try {
			Operand a = stack.pop();
			Operand b = stack.pop();
			Operand c = g.apply(a, b);
			this.stack.push(c);;
		}
		catch (NoSuchElementException e ) {
			System.out.println("Not enough Elements");
		}
		
		
	}
	public void performUnary(UnaryOperation<Operand> f) {
		try {
			Operand a = stack.pop();
		
			Operand c = f.apply(a);
			this.stack.push(c);;
		}
		catch (NoSuchElementException e ) {
			System.out.println("Not enough Elements");
		}
	}
}

package meinprojekt;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calc = new Calculator();
		// ggf mit Filesystem
	
			Scanner scanner = new Scanner (System.in);
			System.out.println("Willkommen");
			System.out.println("> ");
			while (scanner.hasNext() ) {
				String input = scanner.nextLine();
				calc.lex(input);
				calc.print();
				System.out.println(" >");
			}
		scanner.close();
		
		
	}

}

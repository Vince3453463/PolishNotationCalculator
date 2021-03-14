package meinprojekt;

import java.util.NoSuchElementException;

public class Stack<T> {
	
	private Element first;
	public Stack() {}
	
	public void push(T obj) {
		
		Element insert = new Element(obj);
		insert.setNext(first);
		this.first = insert;
	}
	
	public T pop() throws NoSuchElementException {
		if (!isEmpty() ) {
			Element result = first;
			this.first = first.getNext();
			return result.getValue(); //getter Methode eigentlich unwichtig; wir können auf private Klasse Elements eh zugreifen hier
		}
		else throw new NoSuchElementException();
		
	}
	public T peek() throws NoSuchElementException {
		if (this.first == null) {
			throw new NoSuchElementException();
		}
		else {
			Element result = this.first;
			return result.getValue();
		}
	}
	public void clear() {
		this.first = null;
	}
	public boolean isEmpty() {
		return this.first == null;
	}
	public class Element {
		T value;
		Element next;
		
		public Element (T obj) {
			value = obj;
			next = null;
		}
		public T getValue() {
			return value;
		}
		public Element getNext() {
			return this.next;
		}
		public void setNext(Element next) {
			this.next = next; // immer this benutzen, guter Stil damit jeder sieht, dass es sich um ein Attirbut handelt
		}
	}

}

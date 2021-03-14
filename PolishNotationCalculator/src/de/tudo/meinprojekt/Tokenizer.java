package meinprojekt;

public class Tokenizer {
	// nicht implementiert, einfach mit StringTokenizer Standard BIB
	String textRest;
	
	public boolean hasMore() {
		return textRest != "";
	}
	public String getNext() {
		return " ";
	}
	private int skip(int n) {
		// skips leerziehcen, tabs, etc
		
		return n;
	}
	private int scan(int n) {
		// erkennt alle normalen symbole bis ertes leerzeichen
		return n;
	}
	public Tokenizer(String text) {
		textRest = text;
	}
}

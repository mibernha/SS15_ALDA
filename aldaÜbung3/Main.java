package aldaÜbung3;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		File datei = new File("C:\\Users\\Michael Bernhardt\\Desktop\\HTWG\\2. Semester\\Algorithmen und Datenstrukturen\\Übungen\\testKommentar.txt");
		Reader reader = null;
		Stack stack = new Stack();
		boolean setWrong = false;
		//Anlegen von Variablen, anlegen des Readers und des Dateipfades
		try
		{
			reader = new FileReader(datei);
			for(int c; ( c = reader.read() ) != -1; ) {
				char chr = (char) c;
				//Datei wird durchlaufen und jeder Char wird zurückgegeben
				if(chr == '/') {
					if(stack.getTopChar() == '*') {
						stack.pop();
						if(stack.getTopChar() == 'µ') {
							stack.pop();
						} else {
							setWrong = true;
						}
					} 
					else if(stack.getTopChar() == '/') {
						stack.pop();
					} else {
						stack.push(chr);
					}
					
				}
				else if(chr == '*') {
					if(stack.getTopChar() == '/') {
						stack.pop();
						stack.push('µ');
					} else {
						if(stack.getTopChar() == '*') {
							stack.pop();
						} else {
							stack.push(chr);
						}
					}
				}
/*
				if(chr == '(' || chr == '[' || chr == '{'){
					if(!stack.isFull()){
						stack.push(chr);
					} else {
						System.out.println("Stack ist voll!");
					}
				}
				//Sollte das Element eine Klammer-auf sein, wird diese auf den Stack gepushed, wenn der Stack nicht voll ist
				else if(chr == ')'){
					if(stack.getTopChar() == '(') {
						if(!stack.isEmpty()){
							stack.pop();
						} else {
							setWrong = true;
						}
					} else {
						System.out.println("Klammern falsch gesetzt!");
						setWrong = true;
					}
				}
				else if(chr == '}'){
					if(stack.getTopChar() == '{') {
						if(!stack.isEmpty()){
							stack.pop();
						} else {
							setWrong = true;
						}
					} else {
						System.out.println("Klammern falsch gesetzt!");
						setWrong = true;
					}
				}
				else if(chr == ']'){
					if(	stack.getTopChar() == '[') {
						if(!stack.isEmpty()){
							stack.pop();
						} else {
							setWrong = true;
						}
					} else {
						System.out.println("Klammern falsch gesetzt!");
						setWrong = true;
					}
				}
*/
				//Sollte er aktuelle char eine Klammer-zu sein, dann wird überprüft ob die passende Klammer-auf auf dem Stack oben liegt,
				// dann wird diese entfernt, sofern der Stack nicht leer ist, ansonsten passt etwas nicht
			}
		} 
		catch (IOException e )
		{
			System.err.println("Fehler beim lesen der Datei!" );
		}
		if(!stack.isEmpty()){
			setWrong = true;
		}
		//Überprüfung ob der Stack nicht leer ist.
		if(setWrong) {
			System.out.println("Das Programm hat syntaktische Fehler");
		} else {
			System.out.println("Programm ist syntaktisch in Ordnung!");
		}
	}

}

package aldaÜbung3;

public class Stack {
	private int arrayLength = 50;
	private char[] stackArray = new char[arrayLength];
	private int top;
	public char nullChar = '\u0000';
	//Anlegen der Variablen (StackArray, top und nullChar, wobei letzterer nicht verwendet wird in diesem Beispiel)
	
	
	public Stack() {
		top = -1;
	}
	//Anlegen des Konstruktors, beim Aufruf wird top auf "-1" gesetzt
	public int getTop(){
		return top;
	}
	//Methode um den aktuellen Wert von top zurückzugeben;
	public char getTopChar(){
		if(!isEmpty()){
			return stackArray[top];
		} else { 
			return nullChar;
		}
	}
	//Methode um das Element das oben auf dem Stack liegt aufzurufen;
	public void push(char ch) {
		top++;
		stackArray[top] = ch;
	}
	//Methode um ein Element auf den Stack zu pushen, dabei wird top erst um 1 erhöht und dann an die Stelle der char übergeben
	public char pop() {
		char ch = stackArray[top];
		//stackArray[top] = nullChar;
		top--;
		//hier könnten wir auch immer den aktuellen Wert auf den Default-Null-Char-Wert setzen
		return ch;
	}
	//Methode um das oberste Element im Stack zu "entfernen", dabei wird aber nur der Zähler von top um eins heruntergesetzt
	
	public boolean isEmpty() {
		/*for(int i = 0; i < stackArray.length; i++) {
			if(stackArray[i] != nullChar) {
				return false;
			}
		}
		return true; */
		if(top == -1){
			return true;
		} else {
			return false;
		}
		//Überprüfung ob top == -1 ist, wenn dies der Fall ist, ist der Stack "leer"
	}
	public boolean isFull() {
		/*for(int i = 0; i < stackArray.length; i++) {
			if(stackArray[i] == nullChar) {
				return false;
			}
		}
		return true;*/
		if(top == stackArray.length-1 ) {
			return true;
		} else {
			return false;
		}
		//Überprüfung ob top == stackArray.length (in diesem Fall 50) ist, wenn ja, dann ist der Stack voll
	}
	
}

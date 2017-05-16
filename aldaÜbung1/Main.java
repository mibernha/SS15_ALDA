package aldaÜbung1;

public class Main {
	
	public static void main(String[] args) {
		//Anlegen eines Arrays der Länge 4 vom Datentyp Student, dann erzeugen eines Objektes Student, dann Eingabe der Daten per read(),
		//dann Überprüfung ob Geburtsdatum korrekt eingegeben wurde
		System.out.println("Bitte geben Sie 2 Studenten ein");
		
		//ToDO Hier eine For-Schleife für beliebig viele Studenten
		
		Student[] studVz = new Student[2];
		for(int i=0; i<studVz.length; i++) {
			studVz[i] = new Student();
			studVz[i].read();
			studVz[i].dateTest();
		}
		//Anlage eines Scanners zum einlesen einer gewünschten Matrikelnummer
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.println("Bitte geben Sie die Matr.Nr. des gesuchten Studenten ein: ");
		String matFinder = scanner.next();
		//For-Each-Schleife zum Durchlaufen des Arrays, dabei Überprüfung ob eingegebene Matrikelnummer bereits vorhanden ist im Array studVz[]
		//Ausgabe mit toString() im Falle einer Übereinstimmung, andernfalls Ausgabe dass es keine Übereinstimmung gibt
		for(Student studi : studVz){
			if(matFinder.equals(studi.matrikelnummer)){
				studi.toString();
				return;
			} 
		}
		System.out.println("Keine Übereinstimmung!");
	}

}

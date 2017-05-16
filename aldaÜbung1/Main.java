package alda�bung1;

public class Main {
	
	public static void main(String[] args) {
		//Anlegen eines Arrays der L�nge 4 vom Datentyp Student, dann erzeugen eines Objektes Student, dann Eingabe der Daten per read(),
		//dann �berpr�fung ob Geburtsdatum korrekt eingegeben wurde
		System.out.println("Bitte geben Sie 2 Studenten ein");
		
		//ToDO Hier eine For-Schleife f�r beliebig viele Studenten
		
		Student[] studVz = new Student[2];
		for(int i=0; i<studVz.length; i++) {
			studVz[i] = new Student();
			studVz[i].read();
			studVz[i].dateTest();
		}
		//Anlage eines Scanners zum einlesen einer gew�nschten Matrikelnummer
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.println("Bitte geben Sie die Matr.Nr. des gesuchten Studenten ein: ");
		String matFinder = scanner.next();
		//For-Each-Schleife zum Durchlaufen des Arrays, dabei �berpr�fung ob eingegebene Matrikelnummer bereits vorhanden ist im Array studVz[]
		//Ausgabe mit toString() im Falle einer �bereinstimmung, andernfalls Ausgabe dass es keine �bereinstimmung gibt
		for(Student studi : studVz){
			if(matFinder.equals(studi.matrikelnummer)){
				studi.toString();
				return;
			} 
		}
		System.out.println("Keine �bereinstimmung!");
	}

}

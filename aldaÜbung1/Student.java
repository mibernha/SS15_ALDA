package aldaÜbung1;
//Erweitern der Klasse Student ist eine Person mit Matrikelnummer
public class Student extends Person {
	String matrikelnummer;
	//getter und setter
	public String getMatrikelnummer() {
		return matrikelnummer;
	}

	public void setMatrikelnummer(String matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}
	//Override der Methode read() zur Eingabe aller Daten + Matrikelnummer und speichern in entsprechenden lokalen Variablen 
	@Override
	public void read(){
		super.read();
		System.out.println("Bitte geben Sie die Matr.Nr. ein: ");
		matrikelnummer = scanner.next();
	}
	//Override der Methode toString() zur Ausgabe der Daten die früher im Programm eingegeben wurden
	public String toString(){
		super.toString();
		System.out.println("Matr.Nr.:		" + matrikelnummer);
		return " ";
	}
}

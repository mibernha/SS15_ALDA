package aldaÜbung1;

public class Person {
	
	java.util.Scanner scanner = new java.util.Scanner(System.in);
	//Initialisieren eines Scanners und Anlage von Variablen für die Klasse Person
	public String name;
	public String telefonnummer;
	public String geburtsdatum;
	//Getter und Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelefonnummer() {
		return telefonnummer;
	}
	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}
	public String getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	//Anlegen der Methode read() zum einlesen von Daten von der Tastatur 
	public void read(){
		System.out.println("Bitte geben Sie den Namen der Person ein: ");
		name = scanner.nextLine();
		System.out.println("Bitte geben Sie die Telefonnummer ein: ");
		telefonnummer = scanner.next();
		System.out.println("Bitte geben Sie das Geburtstag datum im Format TT/MM/JJJJ ein: ");
		geburtsdatum = scanner.next(); 
	}
	//Anlage einer Methode dateTest() zur Überprüfung ob das eingegebene Geburtsdatum im richtigen Format vorhanden ist
	//per String-Split. Überprüfung ob mit "/" getrennt wird, dann Aufteilung des Strings in 3 Parts
	public void dateTest(){
		if(geburtsdatum.contains("/")) {
			String[] gebTest = geburtsdatum.split("/");
			String part1 = gebTest[0];
			String part2 = gebTest[1];
			String part3 = gebTest[2];
			System.out.println("Geburtsdatum: "+part1+"/"+part2+"/"+part3);
			//Ausgabe des Strings noch einmal, dann casten der Strings auf int-Variablen 
			int p1 = Integer.parseInt(part1);
			int p2 = Integer.parseInt(part2);
			int p3 = Integer.parseInt(part3);
			//Hier Überprüfung ob die Eingabe des Datums im logischen Rahmen ist, z.b. Tage des Monats (April hat keinen 31. Tag)
			//Im Fehlerfall Abbruch des ganzen Programmes mit Info dass Eingabe ungültig war!
			if(p1<1||p2<1||p3<1||p2>12||p3>9999||p1>28&&p2==2||p1>30&&p2==4||p1>30&&p2==6||p1>30&&p2==9||p1>30&&p2==11||p1>31&&p2==1||p1>31&&p2==3||
					p1>31&&p2==5||p1>31&&p2==7||p1>31&&p2==8||p1>31&&p2==10||p1>31&&p2==12) {
				System.out.println("ist eine ungültige Eingabe!");
				System.exit(0);
			} else {
			}
		//Falls Datum falsches Format hat, wird Fehlermitteilung auf Konsole ausgegeben und Programm komplett beendet.	
		} else {
			System.out.println("Falsches Datumsformat!");
			System.exit(0);
		}
	}
	//Anlage der Methoe toString(), gibt eingegeben Daten von weiter oben aus
	public String toString(){
		System.out.println("Name:			" + name);
		System.out.println("Telefonnummer:		" + telefonnummer);
		System.out.println("Geburtsdatum:		" + geburtsdatum);
		return " ";
	}

}

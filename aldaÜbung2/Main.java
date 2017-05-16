package alda‹bung2;

public class Main {

	public static void main(String[] args) {
		int indexMax = 0;
		int indexMin = 0;
		double relMax = 0;
		final java.util.Scanner SCANNER = new java.util.Scanner(System.in);
		
		System.out.println("Bitte geben Sie die Anzahl der Tage an: ");
		int arrayLength = SCANNER.nextInt();
		SCANNER.close();
		StockTick[] boersenKurs = new StockTick[arrayLength];
		
		for(int i = 0; i < boersenKurs.length; i++)
		{
			boersenKurs[i]= new StockTick();
			if(i < 1)
			{
				boersenKurs[i].setKurs(0, boersenKurs[i].setStartKurs());
			} else {	
				boersenKurs[i].setKurs(boersenKurs[i - 1].getKurs(), boersenKurs[i].setKursDiff());
			}
		}
		double klWert = boersenKurs[0].getKurs();
		double grWert = 0.0;
		double highPerc = 0.0;
		int vorlMin = 0;
		
		for(int i = 0; i < boersenKurs.length; i++)
		{
			if(klWert > boersenKurs[i].getKurs()) {
				klWert = boersenKurs[i].getKurs();
				grWert = 0.0;
				vorlMin = i; 
			}
			if(highPerc < boersenKurs[i].getKurs()/klWert) {
				highPerc = boersenKurs[i].getKurs()/klWert;
				indexMax = i;
				indexMin = vorlMin;
			}
		}
	
		relMax = highPerc;
		relMax-=1;
		relMax*=10000;
		relMax=(int) relMax;
		relMax/=100;
		for(int i = 0; i<boersenKurs.length; i++)
		{
			if(i < 1) {
			System.out.println(i + " " + (int) boersenKurs[i].getKurs() + " ");
			} else {
			System.out.println(i + " " + (int) boersenKurs[i].getKurs());
			}
		}
		System.out.println("");
		System.out.println("Der Beste Tag zum Kauf w‰re der "+ (indexMin) + ". Tag");
		System.out.println("Der Beste Tag zum Verkauf w‰re der "+ (indexMax) + ". Tag");
		System.out.println("Der erzielte Gewinn betr‰gt damit: "+ (relMax +"%"));

	}

}

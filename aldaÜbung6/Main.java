package aldaÜbung6;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		boolean running = true;
		Random rndStream = new Random();
		java.util.Scanner scanner = new Scanner(System.in);
		while(running){
			System.out.println("Bitte wählen Sie aus: ");
			System.out.println("[1] für Aufgabe 1");
			System.out.println("[2] für Aufgabe 2");
			System.out.println("[0] um das Programm zu beenden");
			int choose = scanner.nextInt();
			switch(choose){
			case 1:
				System.out.println("Bitte die Länge des Arrays eingeben: ");
				int lengthArray = scanner.nextInt();
				int intArray[] = new int[lengthArray];
				
				for(int i = 0; i < intArray.length; i++){
					intArray[i] = rndStream.nextInt(201)-100;
					System.out.println((i+1) + " " + intArray[i]);
				}
				MergeSort mS = new MergeSort();
				int rmeth = mS.rmeth(intArray, 0, intArray.length-1);
				System.out.println("Anzahl negativer Zahlen: " + rmeth + "\n");
				break;
			case 2:
				IntList list1 = new IntList();
				IntList list2 = new IntList();
				System.out.println("Bitte die Länge der Liste eingeben: ");
				int lengthList = scanner.nextInt();
				for(int i = 0; i < lengthList; i++){
					list1.addAtEnd(rndStream.nextInt(41)+40);
				}	
				System.out.println("Printing List1: ");
				list1.printList();
				System.out.println("Printing List2: ");
				list1.ListInsert(list1, list2).printList();
				break;
			case 0: 
				System.out.println("Programm wird beendet...");
				running = false;
			}
		}
		scanner.close();
		System.out.println("*waves Goodbye*");
	}
}

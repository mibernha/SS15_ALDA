package alda‹bung4;

public class Main {

	public static void main(String[] args) {
		
		int select;
		boolean exit = true;
		StockTickArray sTArray = new StockTickArray();
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		while(exit){
			System.out.println("[1] to create an Array with chooseable length");
//			System.out.println("[2] for sequence sort");
//			System.out.println("[3] for binary sort");
			System.out.println("[4] for quick sort");
//			System.out.println("[5] to print the Array");
//			System.out.println("[6] to search for a company");
			System.out.println("[7] to run Quicksort with move-Counters in different ways");
			System.out.println("[0] to exit the program");
			select = scanner.nextInt();
			if(select == 1) {
				System.out.println("Please insert the length of the Array: ");
				int x = scanner.nextInt();
				sTArray.createStockTickArray(x);
			}
			else if(select == 2) {
				sTArray.sortStockTickArray(1);
			} 
			else if(select == 3) {
	 			sTArray.sortStockTickArray(2);
			}
			else if(select == 4) {
				sTArray.sortStockTickArray(3);
			}
			else if(select == 5) {
				if(sTArray.firmenArray != null){
					for(int z = 1; z < sTArray.firmenArray.length+1; z++) {
						System.out.println(z + "	Firma: " + sTArray.firmenArray[z-1].getSymbol() + "	Kurs: " + sTArray.firmenArray[z-1].getKurs());
					}
					System.out.println("\n");
				} else {
					System.out.println("No Array initalized yet. \n");
				}
			}
			else if(select == 6) {
				System.out.println("Please insert the name of the Company you want to search for: ");
				String comp = scanner.next();
				if(sTArray.sorted()){
					sTArray.binarySort(3, comp);
				} else {
					System.out.println("Array not sorted...");
				}
			}
			else if(select == 7) {
				int counterNorm = 0;
				int counterRnd = 0;
				int counterRndFive = 0;
				for(int i = 0; i < 100; i++){
					sTArray.createStockTickArray(100);
					sTArray.quickSortKurs(0, sTArray.firmenArray.length-1, 1);
					counterNorm += sTArray.counter;
					sTArray.counter = 0;
				}
				for(int i = 0; i < 100; i++){
					sTArray.createStockTickArray(100);
					sTArray.quickSortKurs(0, sTArray.firmenArray.length-1, 2);
					counterRnd += sTArray.counter;
					sTArray.counter = 0;
				}
				for(int i = 0; i < 100; i++){
					sTArray.createStockTickArray(100);
					sTArray.quickSortKurs(0, sTArray.firmenArray.length-1, 3);
					counterRndFive += sTArray.counter;
					sTArray.counter = 0;
				}
				counterNorm = counterNorm/100;
				counterRnd = counterRnd/100;
				counterRndFive = counterRndFive/100;
				System.out.println("Quicksort + Normales Pivot:		" + counterNorm);
				System.out.println("Quicksort + Random Pivot:		" + counterRnd);
				System.out.println("Quicksort + Insertion Sort + RndPivot:	" + counterRndFive + "\n");
			}
			else if(select == 0) {
				System.out.println("exiting soon");
				exit = false;
			} else {
				System.out.println("Wrong input, programm is exiting now.");
				System.exit(0);
			}
		}
		System.out.println("Compare-Counter: " + sTArray.compCounter);	
		scanner.close();
		System.out.println("End of program...");
	}

}

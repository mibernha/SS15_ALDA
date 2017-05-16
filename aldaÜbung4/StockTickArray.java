package alda‹bung4;

import java.util.Random;

public class StockTickArray {
	
	int counter = 0;
	public StockTick[] firmenArray;
	java.util.Scanner scanner = new java.util.Scanner(System.in);
	int i,j,x,y,l,r,m;
	int compCounter = 0;
	public Random rndStream = new Random();
	
	public StockTick[] createStockTickArray(int n){
		firmenArray = new StockTick[n];
		for(int i = 0; i < firmenArray.length; i++) {
			StockTick sTick = new StockTick();
			firmenArray[i] = sTick.generateStockTick();
		}
		return firmenArray;
	}
	public void sortStockTickArray(int choose) {
		if(choose == 1){
			System.out.println("Sequencesort: [1] sorting by price");
			System.out.println("Sequencesort: [2] sorting by name");
			int sort = scanner.nextInt();
			if(sort == 1){
				sequenceSort(1);
				System.out.println("Array sorted by sequence and price");
			}
			else if(sort == 2){
				sequenceSort(2);
				System.out.println("Array sorted by sequence and name");
			}
			
		} 
		else if(choose == 2) {
			System.out.println("Binarysort: [1] sorting by price");
			System.out.println("Binarysort: [2] sorting by name");
			int sort = scanner.nextInt();
			if(sort == 1){
				binarySort(1);
				System.out.println("Array sorted by binary and price");
			}
			else if(sort == 2){
				binarySort(2);
				System.out.println("Array sorted by binary and name");
			}
		}
		else if(choose == 3) {
			System.out.println("Quicksort: [1] sorting by price");
			System.out.println("Quicksort: [2] sorting by name");
			int sort = scanner.nextInt();
			if(sort == 1){
				quickSortKurs(0, firmenArray.length-1, 1);
				System.out.println("Array sorted by quicksort and price");
			}
			else if(sort == 2){
				quickSortName(0, firmenArray.length-1);
				System.out.println("Array sorted by quicksort and name");
			}
			System.out.println("Counter of Moves: " + counter);
			counter = 0;
		}
	}
	public void sequenceSort(int n){
		for(i = 1; i < firmenArray.length; i++) {
			StockTick x = firmenArray[i];
			j = i;
			if(n == 1){
				while(j > 0 && (x.getKurs() < firmenArray[j-1].getKurs())){
					firmenArray[j] = firmenArray[j-1];
					j--;
					compCounter++;
				}
			} 
			else if(n == 2){
				while(j > 0 && (x.getSymbol().compareTo(firmenArray[j - 1].getSymbol()) < 0)){
					firmenArray[j] = firmenArray[j-1];
					j--;
					compCounter++;
				}
			}
			firmenArray[j] = x;	
		}
	}
	public void sequenceSort(int left, int right, int n){
		for(i = left+1; i < right+1; i++) {
			StockTick x = firmenArray[i];
			j = i;
			counter++;
			if(n == 1){
				while(j > 0 && (x.getKurs() < firmenArray[j-1].getKurs())){
					firmenArray[j] = firmenArray[j-1];
					j--;
					counter++;
				}
				if(j > 0) counter++;
			} 
			else if(n == 2){
				while(j > 0 && (x.getSymbol().compareTo(firmenArray[j - 1].getSymbol()) < 0)){
					firmenArray[j] = firmenArray[j-1];
					j--;
					counter++;
				}
				if(j > 0) counter++;
			}
			firmenArray[j] = x;
			counter++;
		}
	}
	public void binarySort(int n){
		for(i = 1; i < firmenArray.length; i++){
			StockTick x = firmenArray[i];
			l = 0;
			r = i-1;
			l = binarySearch(firmenArray, x, l, r, n);
			counter += 3;
			for(j = i-1; j >= l; j--){
				firmenArray[j+1] = firmenArray[j];
				firmenArray[l] = x;
				counter += 2;
			}
		}
	}
	public void binarySort(int n, String s){
		for(i = 1; i < firmenArray.length; i++){
			StockTick x = new StockTick();
			x.setSymbol(s);
			l = 0;
			r = i-1;
			l = binarySearch(firmenArray, x, l, r, n, s);
			if(x.getSymbol().equals(firmenArray[l].getSymbol())){
				System.out.println("Company: " + firmenArray[m].getSymbol() + " Kurs: " + firmenArray[m].getKurs());
				break;
			}
		}
	}
	public void binarySort(int left, int right, int n){
		for(i = left+1; i < right+1; i++){
			StockTick x = firmenArray[i];
			l = left;
			r = i-1;
			while(l <= r) {
				m = (l + r) / 2;
				if(x.getKurs() < firmenArray[m].getKurs()){
					r = m - 1;
				} else {
					l = m + 1;
				}
			}
			for(j = i-1; j >= l; j--){
				firmenArray[j+1] = firmenArray[j];
				counter++;
			}
			firmenArray[l] = x;
			counter++;
		}
	}
	public int binarySearch(StockTick firmenArray[], StockTick x, int l, int r, int n){
		while(l <= r) {
			m = (l+r)/2;
			if(n == 1){
				if(x.getKurs() < firmenArray[m].getKurs()){
					r = m-1;
				} else {
					l = m+1;
				}
			}
			else if(n == 2){
				if(x.getSymbol().compareTo(firmenArray[m].getSymbol()) < 0){
					r = m-1;
				} else {
					l = m+1;
				}
			}
			compCounter++;
		}
		return l;
	}
	void quickSortKurs(int left, int right, int n){
		int pivot;
		if(n == 3){
			if((right-left) <= 5){
				//binarySort(left, right, 1);
				sequenceSort(left, right, 1);
				return;
			}
		}
		this.rndStream = new Random();
		if(n == 1){
			pivot = firmenArray[(left + right) / 2].getKurs();
		} else {
			pivot = firmenArray[rndStream.nextInt(right - left)+left].getKurs();
		}
		int i = left;
		int j = right;
		
		while(i <= j){
			while(firmenArray[i].getKurs() < pivot)	i++;
			while(pivot < firmenArray[j].getKurs()) j--;
			if(i <= j){
				StockTick temp = firmenArray[i];
				firmenArray[i] = firmenArray[j];
				firmenArray[j] = temp;
				i++;
				j--;
				counter += 3;
			}
		}
		if(left < j){
			switch(n){
			case 1:
				quickSortKurs(left, j, 1);
				break;
			case 2:
				quickSortKurs(left, j, 2);
				break;
			case 3:
				quickSortKurs(left, j, 3);
				break;
			}
		}
		if(i < right){
			switch(n){
			case 1:
				quickSortKurs(i, right, 1);
				break;
			case 2:
				quickSortKurs(i, right, 2);
				break;
			case 3:
				quickSortKurs(i, right, 3);
				break;
			}
		}
	}
	void quickSortName(int left, int right){
		if((right-left) < 5){
			binarySort(left, right, 2);
		}
		this.rndStream = new Random();
		StockTick pivot = firmenArray[rndStream.nextInt(right - left)+left];
		int i = left;
		int j = right;
		
		while(i <= j){
			while(firmenArray[i].getSymbol().compareTo(pivot.getSymbol()) < 0){
				i++;
			}
			while(pivot.getSymbol().compareTo(firmenArray[j].getSymbol()) < 0){
				j--;
			}
			if(i <= j){
				StockTick temp = firmenArray[i];
				firmenArray[i] = firmenArray[j];
				firmenArray[j] = temp;
				i++;
				j--;
				counter += 3;
			}
		}
		if(left < j){
			quickSortName(left, j);
		}
		if(i < right){
			quickSortName(i, right);
		}
	}
	public boolean sorted(){
		boolean sort = false;
		for(int z = 0; z < firmenArray.length-1; z++) {
			if(firmenArray[z].getKurs() < firmenArray[z+1].getKurs() || firmenArray[z].getSymbol().compareTo(firmenArray[z+1].getSymbol()) <= 0) {
				sort = true;
			}
		}
		return sort;
	}
	public int binarySearch(StockTick firmenArray[], StockTick x, int l, int r, int n, String s){
		while(l <= r) {
			m = (l+r)/2;
			if(n == 3){
				if(s.compareTo(firmenArray[m].getSymbol()) < 0){
					r = m-1;
				} 
				else if(s.compareTo(firmenArray[m].getSymbol()) == 0){
					return m;
				} else {
					l = m+1;
				}
			}
		}
		return l;
	}
}


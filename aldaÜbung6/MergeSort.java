package aldaÜbung6;

public class MergeSort {
	public int rmeth(int[] arr, int left, int right){
		int counter = 0;
		if(left < right){
			int m = (left + right) / 2;
			counter += rmeth(arr, left, m);
			counter += rmeth(arr, m+1, right);
		} else {
			if(arr[left] < 0){
				arr[left] = 0;
				counter++;
			}
			if(arr[right] < 0){
				arr[right] = 0;
				counter++;
			}
		}
		return counter;
	}
}

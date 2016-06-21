package src.com.datastruct;

public class InsertionSort{

	public static void main(String[] args){
		InsertionSort s =new InsertionSort();
		int[] a={7,8,1,5,6};
		s.insertSort(a);
		for(int k=0;k<a.length;k++){
			System.out.println(a[k]);
		}
	}

	public void insertSort(int[] a){
		for(int j=1; j<a.length; j++){
			int key=a[j];
			int i=j-1;
			while(i>=0 && a[i] > key){
				a[i+1]=a[i];
				i--;
			}
			a[i+1]=key;
		}
	}
}

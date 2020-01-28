import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int [] a = {10,9,8,7,6,5,4,3,2,1,0};
		int minIndex = 0;
		int tmp;
		  for (int i=0;i<a.length;i++) {
			   minIndex = i;//
			   for (int j=i+1;j<a.length;j++) {
				   if(a[j]<a[minIndex])minIndex = j;
			   }
			   tmp =  a[i];
			   a[i] = a[minIndex] ;
			   a[minIndex] = tmp;
		  }
		  System.out.println(Arrays.toString(a));
	}

}

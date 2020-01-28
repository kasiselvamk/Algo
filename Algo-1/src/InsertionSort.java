import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int [] a = {10,9,8,7,6,5,4,3,2,1,0};
		int tmp;
		  for (int i=0;i<a.length;i++) {
			   for (int j=i;j>0;j--) {//
				   if(a[j]<a[j-1]) {//
					   tmp =  a[j];//
					   a[j] = a[j-1];//
					   a[j-1] = tmp;//
				   }
			   }
		  }
		  System.out.println(Arrays.toString(a));
	}
}

import java.util.Arrays;

public class shellsortOrhSort {

	public static void main(String[] args) {
		int [] a = {10,9,8,7,6,5,4,3,2,1,0}; 
		int tmp;
		 int N = a.length;
		 int h = 1;
		 while (h < N/3) h = 3*h + 1;  //H = 3x+1
		 while (h >= 1) {
			 System.out.println(h +" Slots");
			 for (int i=h;i<a.length;i++) {
				   for (int j=i;j>=h;j-=h) {//
					   if(a[j]<a[j-h]) {//
						   tmp =  a[j];//
						   a[j] = a[j-h];//
						   a[j-h] = tmp;//
					   }
				   }
			  } 
			 h = h/3;
		}
		  System.out.println(Arrays.toString(a));
	}
}

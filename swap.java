package development;
import java.util.*;
public class swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int []arr = new int[a];
		int []arr1 = new int[a];
		for(int i=0;i<a;i++) {
			arr[i] = scan.nextInt();
			arr1[i] = arr[i];
		}
		Arrays.sort(arr1);
		HashMap<Integer, Integer> h
        = new HashMap<Integer, Integer>();
		for(int i=0;i<a;i++) {
			h.put(arr[i], i);
		}
		for(int i=0;i<a;i++) {
			if(arr[i]!=arr1[i]) {
				count++;
				int t = h.get(arr1[i]);
				int z = arr1[i];
				int temp = arr[i];
				arr[i] = arr[t];
				arr[t] = temp;
				h.put(z,i);
				h.put(temp,t);
			}
		}
		System.out.println(count);
	}

}

package development;
import java.util.*;
public class oneaway {
	public static void replace(String a, String b) {
		int count =0;
		for(int i=0;i<a.length();i++)
		{
			if(a.charAt(i)!=b.charAt(i)) {
				count++;
			}
		}
		if(count>1) {
			System.out.println("False");
		}
		else {
			System.out.println("True");
		}
		
	}
	public static void insert(String b, String a) {
		int j=0;
		int i=0;
		int c=0;
		while(i<b.length() && j<a.length())
		{
			if(a.charAt(j)!=b.charAt(i))
			{
				j++;
				c++;
			}
			else {
			i++;
			j++;
			}
		}
		if(c>1) {
			System.out.println("False");
		}
		else {
			System.out.println("True");
		}
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
			String a = scan.next();
			String b = scan.next();
			System.out.println(a);
			System.out.println(b);
			if(a.length()==b.length())
			{
				replace(a,b);
			}
			else if (a.length()-1 == b.length())
			{
				insert(b,a);
			}
			else if(a.length() == (b.length()-1))
			{
				insert(a,b);
			}
			else {
				System.out.println("False");
			}
			scan.close();
	}

}

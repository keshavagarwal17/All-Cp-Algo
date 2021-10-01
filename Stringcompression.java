package development;
import java.util.*;
public class Stringcompression {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s;
		String z ="";
		s = scan.next();
		int count=0;
		char t = s.charAt(0);
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)!=t) {
				z = z+t+count;
				count =0;
				t = s.charAt(i);
			}
			count++;
		}
		if(count>0)
		{
			z = z+s.charAt(s.length()-1)+count;
		}
		System.out.println(z.length()>s.length()?s:z);
		scan.close();

	}

}

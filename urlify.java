package development;
import java.util.*;
public class urlify {

	public static void main(String[] args) {
		String s = "Mr JohnSmith   ";
	String g="";
	String[] k = s.split(" ");
		for(int i=0;i<k.length;i++)
		{
			
				g =g+k[i];
			if(i != (k.length-1))
			{
				g= g+"%20";
			}
		}
		System.out.println(g);
	}

}

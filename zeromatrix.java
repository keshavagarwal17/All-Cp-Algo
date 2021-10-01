package development;
import java.util.*;
public class zeromatrix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int []row = new int[a];
		int []col = new int[b];
		int[][]arr = new int[a][b];
		for(int i=0;i<a;i++)
		{
			for(int j=0;j<b;j++)
			{
				arr[i][j]= scan.nextInt();
				if(arr[i][j]==0)
				{
					row[i]++;
					col[j]++;
				}
			}
		}
		for(int i=0;i<a;i++)
		{
			if(row[i]>0)
			{
				for(int j=0;j<b;j++) {
					arr[i][j]=0;
				}
			}
		}
		for(int i=0;i<b;i++)
		{
			if(col[i]>0)
			{
				for(int j=0;j<a;j++) {
					arr[j][i]=0;
				}
			}
		}
		for(int i=0;i<a;i++)
		{
			for(int j=0;j<b;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}

}

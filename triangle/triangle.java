//DP.11 Triangle, fixed starting point and variable ending point. From every point, you can either go to the below ele in the next row
//or to the right diagonal ele in the next row...

package triangle;
import java.util.*;

//Recursion  TC: O(2 pow n)  SC: stack space for recursive calls
public class triangle
{
	public static int func(int i,int j,List<List<Integer>> triangle,int n)
	{
		if(i==n-1)
			return triangle.get(n-1).get(j);
		int down = triangle.get(i).get(j) + func(i+1,j,triangle,n);
		int diagonal =triangle.get(i).get(j) + func(i+1,j+1,triangle,n);
		return Math.min(down, diagonal);
	}
	public static void main(String[] args) 
	{
		int n=1;
		List<List<Integer>> triangle=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		for(int i=1;i<=n;i++)
		{
			List<Integer> row=new ArrayList<>();
			for(int j=1;j<=i;j++)
			{
				System.out.println("Enter element");
				row.add(sc.nextInt());
			}
			triangle.add(row);
		}
		System.out.println("Minimum path sum: " + func(0,0,triangle,n));
	}
}


//Memoization		TC: O(n*m), because we have n*m states like we visit 1*2, 2*3 and if that value is already present in dp, we pick
//					from there  		 SC: recursion stack space length + O(n*m) for DP array
public class triangle
{
	public static int func(int i,int j,List<List<Integer>> triangle,int n,int dp[][])
	{
		if(i==n-1)
			return triangle.get(n-1).get(j);
		if(dp[i][j]!=-1)
			return dp[i][j];
		int down = triangle.get(i).get(j) + func(i+1,j,triangle,n,dp);
		int diagonal =triangle.get(i).get(j) + func(i+1,j+1,triangle,n,dp);
		return dp[i][j]=Math.min(down, diagonal);
	}
	public static void main(String[] args) 
	{
		int n=4;
		List<List<Integer>> triangle=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		for(int i=1;i<=n;i++)
		{
			List<Integer> row=new ArrayList<>();
			for(int j=1;j<=i;j++)
			{
				System.out.println("Enter element");
				row.add(sc.nextInt());
			}
			triangle.add(row);
		}
		int row=triangle.size();
		int col=triangle.get(row-1).size();
		int dp[][]=new int[row][col];
		for(int[] ele:dp)
			Arrays.fill(ele,-1);
		System.out.println("Minimum path sum: " + func(0,0,triangle,n,dp));
	}
}


//Tabulation		TC: O(n*m)    SC: O(n*m) for DP array, no recursion stack space
public class triangle
{
	public static void main(String[] args) 
	{
		int n=4;
		List<List<Integer>> triangle=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		for(int i=1;i<=n;i++)
		{
			List<Integer> row=new ArrayList<>();
			for(int j=1;j<=i;j++)
			{
				System.out.println("Enter element");
				row.add(sc.nextInt());
			}
			triangle.add(row);
		}
		int row=triangle.size();
		int col=triangle.get(row-1).size();
		int dp[][]=new int[row][col];
		for(int[] ele:dp)
			Arrays.fill(ele,-1);
		//setting the base case, we started from bottom coz it should be opp to recursion
		for(int j=0;j<col;j++)
			dp[n-1][j]=triangle.get(n-1).get(j);
		for(int i=n-2;i>=0;i--)
		{
			for(int j=i;j>=0;j--)
			{
				int down = triangle.get(i).get(j) + dp[i+1][j];
				int diagonal =triangle.get(i).get(j) + dp[i+1][j+1];
				dp[i][j]=Math.min(down, diagonal);

			}
		}
		System.out.println("Minimum path sum: " + dp[0][0]);
	}
}

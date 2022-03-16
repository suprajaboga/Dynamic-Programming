//To convert String A to String B, we can perform 3 operations i.e., insert, delete, replace. Find the min no.of operations
//required to convert String A to String B

package editdistance;

import java.util.Arrays;

//Recursion 	TC : Exponential	SC : Auxiliary stack space
public class editdistance
{
	public static int print(int i,int j,String s1,String s2)
	{
		if(i==0)		//if string s1 is empty, j insertions need to be done to convert String s1 to String s2
			return j;
		if(j==0)		//if string s2 is empty, i deletions need to be done to convert String s1 to String s2
			return i;
		if(s1.charAt(i-1) == s2.charAt(j-1))
			return 0 + print(i-1,j-1,s1,s2);
		else
		{
			int insert = 1 + print(i,j-1,s1,s2);
			int delete = 1 + print(i-1,j,s1,s2);
			int replace = 1 + print(i-1,j-1,s1,s2);
			return Math.min(replace, Math.min(insert, delete));
		}
	}
	public static void main(String[] args) 
	{
		String s1 = "horse";
		String s2 = "ros";
		int m = s1.length();
		int n = s2.length();
		System.out.println("Min no.of operations required are: " + print(m,n,s1,s2));
	}
}


//Memoization 	 TC : O(m*n)		SC : O(m*n) + Auxiliary stack space
public class editdistance
{
	public static int print(int i,int j,String s1,String s2,int dp[][])
	{
		if(i==0)		
			return j;
		if(j==0)		
			return i;
		if(dp[i][j] != -1)
			return dp[i][j];
		if(s1.charAt(i-1) == s2.charAt(j-1))
			return 0 + print(i-1,j-1,s1,s2,dp);
		else
		{
			int insert = 1 + print(i,j-1,s1,s2,dp);
			int delete = 1 + print(i-1,j,s1,s2,dp);
			int replace = 1 + print(i-1,j-1,s1,s2,dp);
			return dp[i][j] = Math.min(replace, Math.min(insert, delete));
		}
	}
	public static void main(String[] args) 
	{
		String s1 = "horse";
		String s2 = "ros";
		int m = s1.length();
		int n = s2.length();
		int dp[][] = new int[m+1][n+1];
		for(int[] ele : dp)
			Arrays.fill(ele, -1);
		System.out.println("Min no.of operations required are: " + print(m,n,s1,s2,dp));
	}
}


//Tabulation 	 TC : O(m*n)		SC : O(m*n)
public class editdistance
{
	public static void main(String[] args) 
	{
		String s1 = "horse";
		String s2 = "ros";
		int m = s1.length();
		int n = s2.length();
		int dp[][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++)
			dp[i][0] = i;
		for(int j=0;j<=n;j++)
			dp[0][j] = j;
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				else
				{
					int insert = 1 + dp[i][j-1];
					int delete = 1 + dp[i-1][j];
					int replace = 1 + dp[i-1][j-1];
					dp[i][j] = Math.min(replace, Math.min(insert, delete));
				}
			}
		}
		System.out.println("Min no.of operations required are: " + dp[m][n]);
	}
}


//Space optimisation 	 TC : O(m*n)		SC : O(n)
public class editdistance
{
	public static void main(String[] args) 
	{
		String s1 = "horse";
		String s2 = "ros";
		int m = s1.length();
		int n = s2.length();
		int prev[] = new int[n+1];
		int curr[] = new int[n+1];
		for(int j=0;j<=n;j++)
			prev[j] = j;
		for(int i=1;i<=m;i++)
		{
			curr[0] = i;
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1) == s2.charAt(j-1))
					curr[j] = prev[j-1];
				else
				{
					int insert = 1 + curr[j-1];
					int delete = 1 + prev[j];
					int replace = 1 + prev[j-1];
					curr[j] = Math.min(replace, Math.min(insert, delete));
				}
			}
		}
		System.out.println("Min no.of operations required are: " + prev[n]);
	}
}

package distinctsubsequences;

import java.util.Arrays;

//Recursion		TC : exponential	SC : Recursion stack space
//public class distinctsubsequences
//{
//	public static int print(int i,int j,String s1,String s2)
//	{
//		if(j==0)
//			return 1;
//		if(i==0)
//			return 0;
//		if(s1.charAt(i-1) == s2.charAt(j-1))
//			return print(i-1,j-1,s1,s2) + print(i-1,j,s1,s2);
//		return print(i-1,j,s1,s2);
//	}
//	public static void main(String[] args)
//	{
//		String s1 = "babgbag";
//		String s2 = "bag";
//		int m = s1.length();
//		int n = s2.length();
//		System.out.print("No.of distinct subsequences: " + print(m,n,s1,s2));
//	}
//}


//Memoization	 TC : O(m*n)	SC : O(m*n) + recursion stack space
//public class distinctsubsequences
//{
//	public static int print(int i,int j,String s1,String s2,int dp[][])
//	{
//		if(j==0)
//			return 1;
//		if(i==0)
//			return 0;
//		if(dp[i][j] != -1)
//			return dp[i][j];
//		if(s1.charAt(i-1) == s2.charAt(j-1))
//			return dp[i][j] = print(i-1,j-1,s1,s2,dp) + print(i-1,j,s1,s2,dp);
//		return dp[i][j] = print(i-1,j,s1,s2,dp);
//	}
//	public static void main(String[] args)
//	{
//		String s1 = "babgbag";
//		String s2 = "bag";
//		int m = s1.length();
//		int n = s2.length();
//		int dp[][]=new int[m+1][n+1];
//		for(int[] ele:dp)
//			Arrays.fill(ele, -1);
//		System.out.print("No.of distinct subsequences: " + print(m,n,s1,s2,dp));
//	}
//}


//Tabulation	 TC : O(m*n)	SC : O(m*n)
//public class distinctsubsequences
//{
//	public static void main(String[] args)
//	{
//		String s1 = "babgbag";
//		String s2 = "bag";
//		int m = s1.length();
//		int n = s2.length();
//		int dp[][]=new int[m+1][n+1];
//		for(int i=0;i<=m;i++)
//			dp[i][0] = 1;
//		for(int i=1;i<=m;i++)
//		{
//			for(int j=1;j<=n;j++)
//			{
//				if(s1.charAt(i-1) == s2.charAt(j-1))
//					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
//				else
//					dp[i][j] = dp[i-1][j];
//			}
//		}
//		System.out.print("No.of distinct subsequences: " + dp[m][n]);
//	}
//}


//space optimisation	 TC : O(m*n)	SC : O(n)
public class distinctsubsequences
{
	public static void main(String[] args)
	{
		String s1 = "babgbag";
		String s2 = "bag";
		int m = s1.length();
		int n = s2.length();
		int prev[]=new int[n+1];
		int curr[]=new int[n+1];
		prev[0] = 1;
		curr[0] = 1;
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1) == s2.charAt(j-1))
					curr[j] = prev[j-1] + prev[j];
				else
					curr[j] = prev[j];
			}
			prev = curr;
			for(int z=0;z<=n;z++)
				System.out.print(prev[z]+" ");
				System.out.println();
		}
		System.out.print("No.of distinct subsequences: " + prev[n]);
	}
}
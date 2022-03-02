package longestcommonsubsequence;

import java.util.Arrays;

//Recursion			TC : (2 pow m * 2 pow n)
//public class longestcommonsubsequence 
//{
//	public static int print(int m,int n,String s1,String s2)
//	{
//		if(m==0||n==0)
//			return 0;
//		else if(s1.charAt(m-1)==s2.charAt(n-1))
//			return 1 + print(m-1,n-1,s1,s2);
//		else
//			return Math.max(print(m,n-1,s1,s2),print(m-1,n,s1,s2));
//	}
//	public static void main(String[] args)
//	{
//		String s1="abc";
//		String s2="ac";
//		int m=s1.length();
//		int n=s2.length();
//		System.out.println("Longest common subsequence: "+print(m,n,s1,s2));
//	}
//}

// Memoization		TC : O(m * n)		SC : O(m * n) + O(m + n)


//Tabulation		TC : O(m * n)		SC : O(m * n)
//public class longestcommonsubsequence 
//{
//	public static void main(String[] args)
//	{
//		String s1="abcba";
//		String s2="abcbcba";
//		int m=s1.length();
//		int n=s2.length();
//		int dp[][]=new int[m+1][n+1];
//		for(int[] ele:dp)
//			Arrays.fill(ele,-1);
//		for(int i=0;i<=m;i++)
//			dp[i][0]=0;
//		for(int i=0;i<=n;i++)
//			dp[0][i]=0;
//		for(int i=1;i<=m;i++)
//		{
//			for(int j=1;j<=n;j++)
//			{
//				if(s1.charAt(i-1)==s2.charAt(j-1))
//					dp[i][j] = 1 + dp[i-1][j-1];
//				else
//					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
//			}
//		}
//		System.out.println("Longest common subsequence: "+dp[m][n]);
//	}
//}


//space optimistaion	TC : O(m * n)		SC : O(n)
public class longestcommonsubsequence 
{
	public static void main(String[] args)
	{
		String s1="abcba";
		String s2="abcbcba";
		int m=s1.length();
		int n=s2.length();
		int prev[]=new int[n+1];
		int curr[]=new int[n+1];
		for(int i=0;i<=n;i++)
			prev[i]=0;
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
					curr[j] = 1 + prev[j-1];
				else
					curr[j] = Math.max(curr[j-1], prev[j]);
			}
			prev=curr;
		}
		System.out.println("Longest common subsequence: "+prev[n]);
	}
}

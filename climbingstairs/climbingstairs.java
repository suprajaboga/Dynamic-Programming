//count no.of ways to reach nth stair, at any time we can climb either 1 or 2 steps

package climbingstairs;

import java.util.Arrays;

//public class climbingstairs  
//{
//	public static int func(int n)
//	{
//		if(n<=1)
//			return 1;
//		int step1=func(n-1);
//		int step2=func(n-2);
//		return step1+step2;
//	}
//
//	public static void main(String[] args)
//	{
//		int n=3;
//		System.out.println(func(n));
//	}
//}

//Memoization
public class climbingstairs 
{
	public static int func(int n,int dp[])
	{
		if(n<=1)
			return 1;
		if(dp[n]!=-1)
			return dp[n];
		return dp[n]=func(n-1,dp)+func(n-2,dp);
	}

	public static void main(String[] args)
	{
		int n=3;
		int dp[]=new int[n+1];
		Arrays.fill(dp,-1);
		System.out.println(func(n,dp));
	}
}

//Tabulation
//public class climbingstairs
//{
//	public static void main(String args[])
//	{
//		int n=3;
//		int dp[]=new int[n+1];
//		Arrays.fill(dp,-1);
//		dp[0]=dp[1]=1;
//		for(int i=2;i<=n;i++)
//			dp[i]=dp[i-1]+dp[i-2];
//		System.out.println(dp[n]);
//	}
//}
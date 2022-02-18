//DP on grids problem

package uniquepaths;
import java.util.*;

//Recursion TC: 2 power m*n, SC: stack space
//public class uniquepaths 
//{
//	public static int func(int i,int j)
//	{
//		if(i==0&&j==0)
//			return 1;
//		if(i<0||j<0)
//			return 0;
//		int up=func(i-1,j);
//		int left=func(i,j-1);
//		return up+left;
//	}
//
//	public static void main(String[] args) 
//	{
//		int m=3,n=7;
//		System.out.println("No.of unique paths: "+func(m-1,n-1));
//	}
//}



//memoization    TC: O(m*n), SC: O(m-1+n-1)+O(n*m) for dp[] array
//public class uniquepaths 
//{
//	public static int func(int i,int j,int dp[][])
//	{
//		if(i==0&&j==0)
//			return 1;
//		if(i<0||j<0)
//			return 0;
//		if(dp[i][j]!=-1)
//			return dp[i][j];
//		int up=func(i-1,j,dp);
//		int left=func(i,j-1,dp);
//		return dp[i][j]=up+left;
//	}
//
//	public static void main(String[] args) 
//	{
//		int m=3,n=7;
//		int dp[][]=new int[m][n];
//		for(int i=0;i<m;i++)
//		{
//			for(int j=0;j<n;j++)
//				dp[i][j]=-1;
//		}
//		System.out.println("No.of unique paths: "+func(m-1,n-1,dp));
//	}
//
//}



//Tabulation	TC: O(m*n), SC: O(n*m) here there is no recursion stack space
//public class uniquepaths 
//{
//	public static void main(String[] args) 
//	{
//		int m=3,n=7;
//		int dp[][]=new int[m][n];
//		for(int i=0;i<m;i++)
//		{
//			for(int j=0;j<n;j++)
//				dp[i][j]=-1;
//		}
//		for(int i=0;i<m;i++)
//		{
//			for(int j=0;j<n;j++)
//			{
//				if(i==0&&j==0)
//					dp[i][j]=1;
//				else
//				{
//					int up=0;
//					int left=0;
//					if(i>0)
//						up=dp[i-1][j];
//					if(j>0)
//						left=dp[i][j-1];
//					dp[i][j]=up+left;
//				}
//			}
//		}
//		System.out.println("No.of unique paths: "+dp[m-1][n-1]);
//	}
//
//}


//space optimisation
public class uniquepaths 
{
	public static void main(String[] args) 
	{
		int m=3,n=7;
		int dp[][]=new int[m][n];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
				dp[i][j]=-1;
		}
		int prev[]=new int[n];
		Arrays.fill(prev, -1);
		for(int i=0;i<m;i++)
		{
			int curr[]=new int[n];
			Arrays.fill(curr, -1);
			for(int j=0;j<n;j++)
			{
				if(i==0&&j==0)
					curr[j]=1;
				else
				{
					int up=0;
					int left=0;
					if(i>0)
						up=prev[j];
					if(j>0)
						left=curr[j-1];
					curr[j]=up+left;
				}
			}
			prev=curr;
		}
		System.out.println("No.of unique paths: "+prev[n-1]);
	}

}



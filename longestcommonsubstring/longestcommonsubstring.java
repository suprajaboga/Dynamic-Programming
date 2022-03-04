//same as longest common subsequence but minor change in step 32

package longestcommonsubstring;

import java.util.Arrays;

//Tabulation
//public class longestcommonsubstring 
//{
//	public static void main(String[] args)
//	{
//		String s1="abdgek";
//		String s2="abde";
//		int m=s1.length();
//		int n=s2.length();
//		int dp[][]=new int[m+1][n+1];
//		int ans=0;
//		for(int i=0;i<=m;i++)
//			dp[i][0]=0;
//		for(int i=0;i<=n;i++)
//			dp[0][i]=0;
//		for(int i=1;i<=m;i++)
//		{
//			for(int j=1;j<=n;j++)
//			{
//				if(s1.charAt(i-1)==s2.charAt(j-1))
//				{
//					dp[i][j] = 1 + dp[i-1][j-1];
//					ans=Math.max(ans, dp[i][j]);
//				}
//				else
//					dp[i][j] = 0;
//			}
//		}
//		System.out.println("Length of longest common substring: "+ans);
//	}
//}


//Space optimisation
public class longestcommonsubstring 
{
	public static void main(String[] args)
	{
		String s1="abcd";
		String s2="abde";
		int m=s1.length();
		int n=s2.length();
		int prev[]=new int[n+1];
		int[] curr=new int[n+1];
		Arrays.fill(prev, 0);
		Arrays.fill(curr, 0);
		int ans=0;
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					curr[j] = 1 + prev[j-1];
					ans=Math.max(ans, curr[j]);
				}
				else
					curr[j] = 0;
			}
			prev=curr;
		}
		System.out.println("Length of longest common substring: "+ans);
	}
}
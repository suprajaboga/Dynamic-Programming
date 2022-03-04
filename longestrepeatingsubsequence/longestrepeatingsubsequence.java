//same as longest common subsequence but minor change in step 32

package longestrepeatingsubsequence;

import java.util.Arrays;

public class longestrepeatingsubsequence 
{
	public static void main(String[] args)
	{
		String s1="aabebcdd";
		int n=s1.length();
		int dp[][]=new int[n+1][n+1];
		for(int[] ele:dp)
			Arrays.fill(ele,-1);
		for(int i=0;i<=n;i++)
			dp[i][0]=0;
		for(int i=0;i<=n;i++)
			dp[0][i]=0;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s1.charAt(j-1)&&i!=j)
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		System.out.println("Longest Repeating subsequence: "+dp[n][n]);
	}
}

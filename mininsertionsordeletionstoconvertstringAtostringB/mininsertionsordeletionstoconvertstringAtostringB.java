package mininsertionsordeletionstoconvertstringAtostringB;

public class mininsertionsordeletionstoconvertstringAtostringB 
{
	public static void main(String[] args)
	{
		String s1="geeksforgeeks";
		String s2="geeks";
		int m=s1.length();
		int n=s2.length();
		int dp[][]=new int[m+1][n+1];
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		System.out.println("Min.no of insertions or deletions: " + (m+n-(2*dp[m][n])));
	}
}

//refer to DP.30 for more info in take u forward channel

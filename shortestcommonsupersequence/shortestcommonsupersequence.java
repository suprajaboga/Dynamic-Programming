package shortestcommonsupersequence;

public class shortestcommonsupersequence
{
	public static void main(String[] args) 
	{
		String s1="abac";
		String s2="cab";
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
		String ans = "";
		int i=m,j=n;
		while(i>0&&j>0)
		{
		    if(s1.charAt(i-1)==s2.charAt(j-1))
		    {
		        ans = ans + s1.charAt(i-1);
		        i--;
		        j--;
		    }
		    else if(dp[i-1][j] > dp[i][j-1])
		    {
		    	ans = ans + s1.charAt(i-1);
		        i--;
		    }
		    else
		    {
		    	ans = ans + s2.charAt(j-1);
		    	j--;
		    }
		}
		    while(i>0)
		    {
		    	ans = ans + s1.charAt(i-1);
		        i--;
		    }
		    while(j>0)
		    {
		    	ans = ans + s1.charAt(j-1);
		        j--;
		    }
		System.out.println("Length of shortest common supersequence: " + (m+n-dp[m][n]));
		System.out.print("Shortest common supersequence: ");
		int k=ans.length();
		for(int p=k-1;p>=0;p--)
		{
			System.out.print(ans.charAt(p));
		}
	}
}

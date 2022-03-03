package printlongestcommonsubsequencestring;

public class printlongestcommonsubsequencestring
{
	public static void main(String[] args)
	{
		String s1="abdgek";
		String s2="abde";
		int m=s1.length();
		int n=s2.length();
		int dp[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++)
			dp[i][0]=0;
		for(int i=0;i<=n;i++)
			dp[0][i]=0;
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
		int len = dp[m][n];
		String ans = "";
		for(int i=0;i<len;i++)
		    ans = ans + '$';
		char[] ch = ans.toCharArray();
		int index = len-1;
		int i=m,j=n;
		while(i>0&&j>0)
		{
		    if(s1.charAt(i-1)==s2.charAt(j-1))
		    {
		        ch[index] = s1.charAt(i-1);
		        index--;
		        i--;
		        j--;
		    }
		    else if(dp[i-1][j] > dp[i][j-1])
		        i--;
		    else
		        j--;
		}
		for(int t=0;t<len;t++)
		    System.out.print(ch[t]);
	}
}


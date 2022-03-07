//same as LCS but s2 should be reverse of s1

package longestpalindromicsubsequence;

public class longestpalindromicsubsequence
{
	public static void main(String[] args)
	{
		String s1="bbabcbcab";
		StringBuilder s2=new StringBuilder(s1);
		s2.reverse();
		int n=s1.length();
		int dp[][]=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
			}
		}
		int len=dp[n][n];
		String ans="";
		for(int i=0;i<len;i++)
			ans = ans + '$';
		int index=len-1;
		char[] ch=ans.toCharArray();
		int i=n,j=n;
		while(i>0&&j>0)
		{
			if(s1.charAt(i-1)==s2.charAt(j-1))
			{
				ch[index--] = s1.charAt(i-1);
				i--;
				j--;
			}
			else if(dp[i-1][j] > dp[i][j-1])
				i--;
			else
				j--;
		}
		System.out.println("Length of longest palindromic subsequence: "+len);
		System.out.print("Longest palindromic subsequence: ");
		for(int t=0;t<len;t++)
			System.out.print(ch[t]);
	}
}

//same as longest palindromic subsequence but 1 change in line 24
//Here in codingninjas, ingni is already a palindrome, so we use longest palindromic subsequence code to find the longest length
//and then subtract that from the total length of the code to find min.no of insertions

package mininsertionstoformpalindrome;

public class mininsertionstoformpalindrome
{
	public static void main(String[] args)
	{
		String s1="codingninjas";
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
		System.out.println("Min no.of insertions to make a string palindrome is " + (n - dp[n][n]));
	}
}

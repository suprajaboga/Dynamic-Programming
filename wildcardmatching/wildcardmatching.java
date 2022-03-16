// A * can match with either sequence of characters or an empty string and a ? can match with only 1 character

package wildcardmatching;

import java.util.Arrays;

//Recursion 	TC : Exponential	SC : O(m+n) i.e.,Auxiliary stack space
//public class wildcardmatching 
//{
//	public static boolean print(int i,int j,String pattern,String text)
//	{
//		if(i==0 && j==0)
//			return true;
//		if(i==0 && j>0)
//			return false;
//		if(i>0 && j==0)
//		{
//			for(int k=1;k<=i;k++)
//			{
//				if(pattern.charAt(k-1) != '*')
//					return false;
//			}
//			return true;
//		}
//		if((pattern.charAt(i-1) == text.charAt(j-1)) || (pattern.charAt(i-1) == '?'))
//			return print(i-1,j-1,pattern,text);
//		if(pattern.charAt(i-1) == '*')
//			return print(i-1,j,pattern,text) || print(i,j-1,pattern,text);
//		return false;
//	}
//	public static void main(String[] args) 
//	{
//		String pattern = "a*s*ab";
//		String text = "acbsbab";
//		int m = pattern.length();
//		int n = text.length();
//		System.out.println("If the text can be formed from pattern? " + print(m,n,pattern,text));
//	}
//}


//Tabulation 	TC : O(m*n)		SC : O(m*n)
//public class wildcardmatching 
//{
//	public static void main(String[] args) 
//	{
//		String pattern = "?a";
//		String text = "ak";
//		int m = pattern.length();
//		int n = text.length();
//		boolean dp[][] = new boolean[m+1][n+1];
//		dp[0][0] = true;
//		for(int j=1;j<=n;j++)
//			dp[0][j] = false;
//		for(int i=1;i<=m;i++)
//		{
//			boolean flag = true;
//			for(int k=1;k<=i;k++)
//			{
//				if(pattern.charAt(k-1) != '*')
//				{
//					flag=false;
//					break;
//				}
//			}
//			dp[i][0] = flag;
//		}
//		for(int i=1;i<=m;i++)
//		{
//			for(int j=1;j<=n;j++)
//			{
//				if((pattern.charAt(i-1) == text.charAt(j-1)) || (pattern.charAt(i-1) == '?'))
//					dp[i][j] = dp[i-1][j-1];
//				else if(pattern.charAt(i-1) == '*')
//					dp[i][j] = dp[i-1][j] || dp[i][j-1];
//				else
//					dp[i][j] = false;
//			}
//		}
//		System.out.println("If the text can be formed from pattern? " + dp[m][n]);
//	}
//}


//Space optimisation    	TC : O(m*n)		SC : O(n)
public class wildcardmatching 
{
	public static void main(String[] args) 
	{
		String pattern = "a*s*ab";
		String text = "acbsbab";
		int m = pattern.length();
		int n = text.length();
		boolean prev[] = new boolean[n+1];
		boolean curr[] = new boolean[n+1];
		prev[0] = true;
		for(int j=1;j<=n;j++)
			prev[j] = false;
		for(int i=1;i<=m;i++)
		{
			boolean flag = true;
			for(int k=1;k<=i;k++)
			{
				if(pattern.charAt(k-1) != '*')
				{
					flag=false;
					break;
				}
			}
			curr[0] = flag;
			for(int j=1;j<=n;j++)
			{
				if((pattern.charAt(i-1) == text.charAt(j-1)) || (pattern.charAt(i-1) == '?'))
					curr[j] = prev[j-1];
				else if(pattern.charAt(i-1) == '*')
					curr[j] = prev[j] || curr[j-1];
				else
					curr[j] = false;
			}
			prev = curr;
		}
		System.out.println("If the text can be formed from pattern? " + prev[n]);
	}
}

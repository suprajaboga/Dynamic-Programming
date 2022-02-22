//The two common dynamic programming approaches are:
//Memoization: Known as the “top-down” dynamic programming, usually the problem is solved in the direction of the main problem to the base cases.
//Tabulation: Known as the “bottom-up ” dynamic programming, usually the problem is solved in the direction of solving the base cases to the main problem

package fibonacci;
import java.util.*;

//Memoization
//Time Complexity: O(N), The overlapping subproblems will return the answer in constant time O(1). Therefore the total number of new subproblems we solve is ‘n’. Hence total time complexity is O(N).
//Space Complexity: O(N), We are using a recursion stack space(O(N)) and an array (again O(N)). Therefore total space complexity will be O(N) + O(N) ≈ O(N)
public class fibonacci
{
	static int func(int n,int dp[])
	{
		if(n<=1)
			return n;
		if(dp[n]!=-1)
			return dp[n];
		dp[n]=func(n-1,dp)+func(n-2,dp);
		return dp[n];
	}
	public static void main(String[] args) 
	{
		int n=5;
		int dp[]=new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println(func(n,dp));
	}
}


//Tabulation
//Time Complexity: O(N), We are running a simple iterative loop
//Space Complexity: O(N), We are using an external array of size ‘n+1’.
public class fibonacci
{
	public static void main(String[] args)
	{
		int n=5;
		int dp[]=new int[n+1];
		Arrays.fill(dp,-1);
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=n;i++)
			dp[i]=dp[i-1]+dp[i-2];
		System.out.println(dp[n]);
	}
}


//space optimisation
//Time Complexity: O(N), We are running a simple iterative loop
//Space Complexity: O(1), We are not using any extra space
public class fibonacci
{
	public static void main(String[] args)
	{
		int n=5;
		int prev2=0;
		int prev1=1;
		for(int i=2;i<=n;i++)
		{
			int curr=prev1+prev2;
			prev2=prev1;
			prev1=curr;
		}
		System.out.println(prev1);
	}
}

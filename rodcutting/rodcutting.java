//Rod cutting problem , similar to unbounded knapsack prblem

package rodcutting;

//Recursion 	TC : exponential		SC : O(recursion stack space)
public class rodcutting
{
	public static int print(int index,int n,int price[])
	{
		if(index==0)
			return n*price[0];
		int nottake,take=Integer.MIN_VALUE;
		nottake = 0 + print(index-1,n,price);
		int rodlength = index + 1;
		if(rodlength <= n)
			take = price[index] + print(index,n-rodlength,price);
		return Math.max(take, nottake);
	}

	public static void main(String[] args) 
	{
		int n=8;
		int price[]= {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println("Maximum value: "+print(n-1,n,price));
	}
}


//Tabulation 	TC : O(n*n)			SC : O(n*n)
public class rodcutting
{
	public static void main(String[] args) 
	{
		int n=8;
		int price[]= {1, 5, 8, 9, 10, 17, 17, 20};
		int dp[][]=new int[n][n+1];
		for(int p=0;p<=n;p++)
			dp[0][p] = p * price[0];
		for(int index=1;index<n;index++)
		{
			for(int target=0;target<=n;target++)
			{
				int nottake,take=Integer.MIN_VALUE;
				nottake = 0 + dp[index-1][target];
				int rodlength = index + 1;
				if(rodlength <= target)
					take = price[index] + dp[index][target-rodlength];
				dp[index][target] = Math.max(take, nottake);
			}
		}
		System.out.println("Maximum value: "+dp[n-1][n]);
	}
}


//space optimisation	TC : O(n*n)		SC : O(n)
public class rodcutting
{
	public static void main(String[] args) 
	{
		int n=8;
		int price[]= {1, 5, 8, 9, 10, 17, 17, 20};
		int prev[]=new int[n+1];
		int curr[]=new int[n+1];
		for(int p=0;p<=n;p++)
			prev[p] = p * price[0];
		for(int index=1;index<n;index++)
		{
			for(int target=0;target<=n;target++)
			{
				int nottake,take=Integer.MIN_VALUE;
				nottake = 0 + prev[target];
				int rodlength = index + 1;
				if(rodlength <= target)
					take = price[index] + curr[target-rodlength];
				curr[target] = Math.max(take, nottake);
			}
			prev=curr;
		}
		System.out.println("Maximum value: "+prev[n]);
	}
}


//Further Space optimisation into single array, we don't use curr[], we use only prev[]	TC : O(n*tot_weight)		SC : O(tot_weight)
public class rodcutting
{
	public static void main(String[] args) 
	{
		int n=8;
		int price[]= {1, 5, 8, 9, 10, 17, 17, 20};
		int prev[]=new int[n+1];
		for(int p=0;p<=n;p++)
			prev[p] = p * price[0];
		for(int index=1;index<n;index++)
		{
			for(int target=0;target<=n;target++)
			{
				int nottake,take=Integer.MIN_VALUE;
				nottake = 0 + prev[target];
				int rodlength = index + 1;
				if(rodlength <= target)
					take = price[index] + prev[target-rodlength];
				prev[target] = Math.max(take, nottake);
			}
		}
		System.out.println("Maximum value: "+prev[n]);
	}
}

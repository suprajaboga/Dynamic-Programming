//count no.of ways to make coin change. A coin can be picked any no.of times.

package coinchange2;

//Recursion		TC : O(greater than 2 pow n), coz we're staying at the same index if we pick an element		SC : O(recursion stack space)
public class coinchange2
{
	public static int print(int index,int amount,int coins[])
	{
		if(index==0)
		{
			if(amount%coins[0]==0)
				return 1;
			else
				return 0;
		}
		int nottake,take=0;
		nottake = print(index-1,amount,coins);
		if(coins[index]<=amount)
			take = print(index,amount-coins[index],coins);
		return nottake + take;
	}

	public static void main(String[] args)
	{
		int coins[]= {1,2,3};
		int amount=4;
		int n=coins.length;
		System.out.println("Total no.of ways are: "+print(n-1,amount,coins));
	}
}


//Tabulation		TC : O(n*target)		SC : O(n*target)
public class coinchange2
{
	public static void main(String[] args)
	{
		int coins[]= {1,2,3};
		int target=4;
		int n=coins.length;
		int dp[][]=new int[n][target+1];
		for(int i=0;i<=target;i++)
		{
			if(i%coins[0]==0)
				dp[0][i]=1;
			else
				dp[0][i]=0;
		}
		for(int index=1;index<n;index++)
		{
			for(int sum=0;sum<=target;sum++)
			{
				int nottake,take=0;
				nottake = dp[index-1][sum];
				if(coins[index]<=sum)
					take = dp[index][sum-coins[index]];
				dp[index][sum]= nottake + take;
			}
		}
		System.out.println("Total no.of ways are: "+dp[n-1][target]);
	}
}


//Space optimisation		TC : O(n*target)		SC : O(target)
public class coinchange2
{
	public static void main(String[] args)
	{
		int coins[]= {1,2,5};
		int target=5;
		int n=coins.length;
		int prev[]=new int[target+1];
		int curr[]=new int[target+1];
		for(int i=0;i<=target;i++)
		{
			if(i%coins[0]==0)
				prev[i]=1;
			else
				prev[i]=0;
		}
		for(int index=1;index<n;index++)
		{
			for(int sum=0;sum<=target;sum++)
			{
				int nottake,take=0;
				nottake = prev[sum];
				if(coins[index]<=sum)
					take = curr[sum-coins[index]];
				curr[sum]= nottake + take;
			}
			prev=curr;
		}
		System.out.println("Total no.of ways are: "+prev[target]);
	}
}

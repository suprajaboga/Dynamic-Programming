//DP.20	Find the min no.of coins required to form the given target. Each coin can be chosen infite no.of times

package minimumcoins;

//Recursion		TC : O(greater than 2 pow n), coz we're staying at the same index if we pick an element		SC : O(recursion stack space)
public class minimumcoins
{
	public static int print(int index,int amount,int coins[])
	{
		if(index==0)
		{
			if(amount%coins[0]==0)
				return amount/coins[0];
			else
				return Integer.MAX_VALUE;
		}
		int nottake,take=Integer.MAX_VALUE;
		nottake = 0 + print(index-1,amount,coins);
		if(coins[index]<=amount)
			take = 1 + print(index,amount-coins[index],coins);
		return Math.min(nottake, take);
	}
	public static void main(String[] args)
	{
		int coins[]= {25,10,5};
		int amount=30;
		int n=coins.length;
		System.out.println("Min no.of coins required are: "+print(n-1,amount,coins));
	}
}


//Tabulation		TC : O(n*target)		SC : O(n*target)
public class minimumcoins
{
	public static void main(String[] args)
	{
		int coins[]= {1,2,5};
		int target=11;
		int n=coins.length;
		int dp[][]=new int[n][target+1];
		for(int i=0;i<=target;i++)
		{
			if(i%coins[0]==0)
				dp[0][i]=i/coins[0];
			else
				dp[0][i]=(int)1e9;
		}
		for(int index=1;index<n;index++)
		{
			for(int sum=0;sum<=target;sum++)
			{
				int nottake,take=Integer.MAX_VALUE;
				nottake = 0 + dp[index-1][sum];
				if(coins[index]<=sum)
					take = 1 + dp[index][sum-coins[index]];
				dp[index][sum]= Math.min(nottake, take);
			}
		}
		System.out.println("Min no.of coins required are: "+dp[n-1][target]);
	}
}


//Space optimisation		TC : O(n*target)		SC : O(target)
public class minimumcoins
{
	public static void main(String[] args)
	{
		int coins[]= {1,2,5};
		int target=11;
		int n=coins.length;
		int prev[]=new int[target+1];
		int curr[]=new int[target+1];
		for(int i=0;i<=target;i++)
		{
			if(i%coins[0]==0)
				prev[i]=i/coins[0];
			else
				prev[i]=(int)1e9;
		}
		for(int index=1;index<n;index++)
		{
			for(int sum=0;sum<=target;sum++)
			{
				int nottake,take=Integer.MAX_VALUE;
				nottake = 0 + prev[sum];
				if(coins[index]<=sum)
					take = 1 + prev[sum-coins[index]];
				curr[sum]= Math.min(nottake, take);
			}
			prev=curr;
		}
		System.out.println("Min no.of coins required are: "+prev[target]);
	}
}


//0/1 knapsack problem. Return the maximum value of the weights. Each weight can  be chosen only once. Finally, the weights we've should be equal to the given knapsack weight

package knapsack;

import java.util.Arrays;

////Recursion		TC : O(2 pow n)		SC : O(recursion stack space)
//public class knapsack 
//{
//	public static int print(int index,int tot_weight,int weights[],int values[])
//	{
//		if(index==0)
//		{
//			if(weights[0]<=tot_weight)
//				return values[0];
//			else
//				return 0;
//		}
//		int nottake,take=Integer.MIN_VALUE;
//		nottake=0+print(index-1,tot_weight,weights,values);
//		if(weights[index]<=tot_weight)
//			take=values[index]+print(index-1,tot_weight-weights[index],weights,values);
//		return Math.max(nottake, take);
//	}
//	public static void main(String[] args) 
//	{
//		int n=3;
//		int weights[]= {3,4,5};
//		int values[]= {30,50,60};
//		int tot_weight=8;
//		System.out.println("Maximum value: "+print(n-1,tot_weight,weights,values));
//	}
//}


//Memoization		TC : O(n*tot_weight)		SC : O(n*tot_weight) + O(recursion stack space)
//public class knapsack 
//{
//	public static int print(int index,int tot_weight,int weights[],int values[],int dp[][])
//	{
//		if(index==0)
//		{
//			if(weights[0]<=tot_weight)
//				return values[0];
//			else
//				return 0;
//		}
//		if(dp[index][tot_weight]!=-1)
//			return dp[index][tot_weight];
//		int nottake,take=Integer.MIN_VALUE;
//		nottake=0+print(index-1,tot_weight,weights,values,dp);
//		if(weights[index]<=tot_weight)
//			take=values[index]+print(index-1,tot_weight-weights[index],weights,values,dp);
//		return dp[index][tot_weight]=Math.max(nottake, take);
//	}
//	public static void main(String[] args) 
//	{
//		int n=3;
//		int weights[]= {4,5,1};
//		int values[]= {1,2,3};
//		int tot_weight=3;
//		int dp[][]=new int[n][tot_weight+1];
//		for(int[] ele:dp)
//			Arrays.fill(ele, -1);
//		System.out.println("Maximum value: "+print(n-1,tot_weight,weights,values,dp));
//	}
//}


//Tabulation		TC : O(n*tot_weight)		SC : O(n*tot_weight)
//public class knapsack 
//{
//public static void main(String[] args) 
//{
//	int n=4;
//	int weights[]= {1,3,4,5};
//	int values[]= {1,4,5,7};
//	int tot_weight=7;
//	int dp[][]=new int[n][tot_weight+1];
//	//base condition if index=0
//	for(int wt=weights[0];wt<=tot_weight;wt++)
//		dp[0][wt]=values[0];
//	for(int index=1;index<n;index++)
//	{
//		for(int w=0;w<=tot_weight;w++)
//		{
//			int nottake,take=Integer.MIN_VALUE;
//			nottake=dp[index-1][w];
//			if(weights[index]<=w)
//				take=values[index] + dp[index-1][w-weights[index]];
//			dp[index][w]=Math.max(nottake, take);
//		}
//	}
//	System.out.println("Maximum value: "+dp[n-1][tot_weight]);
//}
//}


//Space optimisation		TC : O(n*tot_weight)		SC : O(tot_weight)
public class knapsack 
{
public static void main(String[] args) 
{
	int n=4;
	int weights[]= {1,3,4,5};
	int values[]= {1,4,5,7};
	int tot_weight=7;
	int prev[]=new int[tot_weight+1];
	int curr[]=new int[tot_weight+1];
	//base condition if index=0
	for(int wt=weights[0];wt<=tot_weight;wt++)
		prev[wt]=values[0];
	for(int index=1;index<n;index++)
	{
		for(int w=0;w<=tot_weight;w++)
		{
			int nottake,take=Integer.MIN_VALUE;
			nottake=prev[w];
			if(weights[index]<=w)
				take=values[index] + prev[w-weights[index]];
			curr[w]=Math.max(nottake, take);
		}
		prev=curr;
	}
	System.out.println("Maximum value: "+prev[tot_weight]);
}
}

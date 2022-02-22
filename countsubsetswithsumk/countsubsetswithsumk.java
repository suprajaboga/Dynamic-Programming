package countsubsetswithsumk;

import java.util.Arrays;

//Recursion 	TC: O(2 pow n)		SC: O(recursion stack space)
public class countsubsetswithsumk 
{
	public static int print(int index,int sum,int arr[])
	{
		if(sum==0)
			return 1;
		if(index==0)
		{
			if(arr[0]==sum)
				return 1;
			else
				return 0;
		}
		int nottake=print(index-1,sum,arr);
		int take=0;
		if(arr[0]<=sum)
			take=print(index-1,sum-arr[index],arr);
		return take+nottake;
		
	}
	public static void main(String[] args) 
	{
		int arr[]= {1,2,3,3};
		int n=arr.length;
		int sum=6;
		System.out.println("No of subsets: "+print(n-1,sum,arr));
	}
}


//Memoization		TC: O(n*sum)	SC: O(n*sum) + recursion stack space
public class countsubsetswithsumk 
{
	public static int print(int index,int sum,int arr[],int dp[][])
	{
		if(sum==0)
			return 1;
		if(index==0)
		{
			if(arr[0]==sum)
				return 1;
			else
				return 0;
		}
		if(dp[index][sum]!=-1)
			return dp[index][sum];
		int nottake=print(index-1,sum,arr,dp);
		int take=0;
		if(arr[0]<=sum)
			take=print(index-1,sum-arr[index],arr,dp);
		return dp[index][sum]=take+nottake;
		
	}
	public static void main(String[] args) 
	{
		int arr[]= {1,2,3};
		int n=arr.length;
		int sum=3;
		int dp[][]=new int[n][sum+1];
		for(int[] ele:dp)
			Arrays.fill(ele, 0);
		System.out.println("No of subsets: "+print(n-1,sum,arr,dp));
	}
}


//Tabulation 	TC: O(n*sum)	SC: O(n*sum), here no recursion stack space required
public class countsubsetswithsumk 
{
	public static void main(String[] args)
	{
		int arr[]= {2,2,3};
		int sum=5;
		int n=arr.length;
		int dp[][]=new int[n][sum+1];
		for(int ind=0;ind<n;ind++)
			dp[ind][0]=1;
		dp[0][arr[0]]=1;
		for(int index=1;index<n;index++)
		{
			for(int target=1;target<=sum;target++)
			{
				int take=0,nottake=0;  
				if(target>=arr[index])
					take=dp[index-1][target-arr[index]];
				nottake=dp[index-1][target];
				dp[index][target]=take+nottake;
			}
		}
		System.out.println("No.of subsets: "+dp[n-1][sum]);
	}
}

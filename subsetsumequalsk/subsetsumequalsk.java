//DP on subsequences, a subsequence also called as subset and it can be contiguous or non-continguous sub array
//Find any one subset that sums up to a given target and return true..if no subset then return false


package subsetsumequalsk;

import java.util.Arrays;

//Recursion			TC: O(2 pow n)		SC: O(n) i.e., recursion stack space
//public class subsetsumequalsk 
//{
//	public static boolean func(int index,int target,int arr[])
//	{
//		boolean take=false,nottake=false;
//		if(target==0)
//			return true;
//		if(index==0)
//			return (arr[0]==target);
//		if(target>=arr[index])
//			take=func(index-1,target-arr[index],arr);
//		nottake=func(index-1,target,arr);
//		return (take||nottake);
//	}
//	public static void main(String[] args)
//	{
//		int arr[]= {2,3,1,1};
//		int target=19;
//		int n=arr.length;
//		boolean result=func(n-1,target,arr);
//		System.out.println((result==true)?"Subsequence found":"Subsequence not found");
//	}
//}


//memoization		TC : O(n*target)		SC : O(n*m) + O(recursion stack space)
//public class subsetsumequalsk 
//{
//	public static boolean func(int index,int target,int arr[],boolean dp[][])
//	{
//		boolean take=false,nottake=false;
//		if(target==0)
//			return true;
//		if(index==0)
//			return (arr[0]==target);
//		if(dp[index][target]!=false)
//			return dp[index][target];
//		if(target>=arr[index])
//			take=func(index-1,target-arr[index],arr,dp);
//		nottake=func(index-1,target,arr,dp);
//		return dp[index][target]=(take||nottake);
//	}
//	public static void main(String[] args)
//	{
//		int arr[]= {2,3,1,1};
//		int target=14;
//		int n=arr.length;
//		boolean dp[][]=new boolean[n][target+1];
//		for(boolean[] ele:dp)
//			Arrays.fill(ele,false);
//		boolean result=func(n-1,target,arr,dp);
//		System.out.println((result==true)?"Subsequence found":"Subsequence not found");
//	}
//}


//Tabulation
public class subsetsumequalsk 
{
	public static void main(String[] args)
	{
		int arr[]= {2,2,3};
		int sum=7;
		int n=arr.length;
		boolean dp[][]=new boolean[n][sum+1];
		for(boolean[] ele:dp)
			Arrays.fill(ele,false);
		for(int ind=0;ind<n;ind++)
			dp[ind][0]=true;
		dp[0][arr[0]]=true;
		for(int index=1;index<n;index++)
		{
			for(int target=1;target<=sum;target++)
			{
				boolean take=false,nottake=false;  
				if(target>=arr[index])
					take=dp[index-1][target-arr[index]];
				nottake=dp[index-1][target];
				dp[index][target]=(take||nottake);
			}
		}
		System.out.println((dp[n-1][sum]==true)?"Subsequence found":"Subsequence not found");
	}
}

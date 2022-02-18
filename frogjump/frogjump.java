//A frog can either jump 1 step or 2 steps at any time to reach the nth stair.so, the energy required to move from ith stair to jth stair is
//a[i]-a[j]. Now, find the min energy required to move to nth stair

package frogjump;

import java.util.Arrays;

//Recursion
//public class frogjump 
//{
//	public static int func(int index,int arr[])
//	{
//		if(index==0)		//if frog is at 0th index, then min energy required is 0		
//			return 0;
//		int left=func(index-1,arr)+Math.abs(arr[index]-arr[index-1]);
//		int right=Integer.MAX_VALUE;
//		if(index>1)			//if we are at index 1, then we can't step down 2 stairs coz index will be -1(a[1]->a[0]->a[-1])
//			right=func(index-2,arr)+Math.abs(arr[index]-arr[index-2]);
//		return Math.min(left,right);
//	}
//
//	public static void main(String[] args)
//	{
//		int n=6;
//		int arr[]= {30,10,60,10,60,50};
//		System.out.println("Minimum energy required is: "+func(n-1,arr));
//	}
//}


//Memoization(DP Solution)       converting recursive sol to memoization concept gives DP solution
//public class frogjump 
//{
//	public static int func(int index,int arr[],int dp[])
//	{
//		if(index==0)		//if frog is at 0th index, then min energy required is 0		
//			return 0;
//		if(dp[index]!=-1)
//			return dp[index];
//		int left=func(index-1,arr,dp)+Math.abs(arr[index]-arr[index-1]);
//		int right=Integer.MAX_VALUE;
//		if(index>1)			//if we are at index 1, then we can't step down 2 stairs coz index will be -1(a[1]->a[0]->a[-1])
//			right=func(index-2,arr,dp)+Math.abs(arr[index]-arr[index-2]);
//		return dp[index]=Math.min(left,right);
//	}
//
//	public static void main(String[] args)
//	{
//		int n=6;
//		int arr[]= {30,10,60,10,60,50};
//		int dp[]=new int[n+1];
//		Arrays.fill(dp, -1);
//		System.out.println("Minimum energy required is: "+func(n-1,arr,dp));
//	}
//}


//tabulation(bottom-up approach) space complexity is O(n), when compared with recursion coz there is no stack space as we're using dp[] array
//public class frogjump 
//{
//	public static void main(String[] args)
//	{
//		int n=6;
//		int arr[]= {30,10,60,10,60,50};
//		int dp[]=new int[n+1];
//		Arrays.fill(dp, -1);
//		dp[0]=0;			//ex of bottom-up approach, first setting the 0th index, and then looping from 1st index
//		for(int index=1;index<arr.length;index++)
//		{
//			int firststep=dp[index-1]+Math.abs(arr[index]-arr[index-1]);
//			int secondstep=Integer.MAX_VALUE;
//			if(index>1)			
//				secondstep=dp[index-2]+Math.abs(arr[index]-arr[index-2]);
//			dp[index]=Math.min(firststep,secondstep);
//		}
//		System.out.println("Minimum energy required is: "+dp[n-1]);
//	}
//}


//space optimisation, dp[] array is also removed to reduce the space 
public class frogjump 
{
	public static void main(String[] args)
	{
		int n=6;
		int arr[]= {30,10,60,10,60,50};
		int prev1=0;
		int prev2=0;
		for(int index=1;index<arr.length;index++)
		{
			int firststep=prev1+Math.abs(arr[index]-arr[index-1]);
			int secondstep=Integer.MAX_VALUE;
			if(index>1)			
				secondstep=prev2+Math.abs(arr[index]-arr[index-2]);
			int curr=Math.min(firststep,secondstep);
			prev2=prev1;
			prev1=curr;
		}
		System.out.println("Minimum energy required is: "+prev1);
	}
}


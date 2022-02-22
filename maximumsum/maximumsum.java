//Maximum sum of non-adjacent elements(House Robber problem), we can do this prblm using the technique of pick&non-pick method.

package maximumsum;

import java.util.Arrays;

//Recursion
public class maximumsum
{
	public static int func(int index,int arr[])
	{
		if(index==0)		//if ind=0 means, we didn't pick index=1 ele, and consider this ind[0] ele as we want to maximise the sum
			return arr[index];
		if(index<0)
			return 0;
		int pick=arr[index]+func(index-2,arr);
		int notpick=0+func(index-1,arr);
		return Math.max(pick,notpick);
	}
	public static void main(String[] args) 
	{
		int arr[]= {2,1,4,9};
		int n=arr.length;
		System.out.println("Maximum sum is: "+func(n-1,arr));
	}
}


//Memoization
public class maximumsum
{
	public static int func(int index,int arr[],int dp[])
	{
		if(index==0)
			return arr[index];
		if(index<0)
			return 0;
		if(dp[index]!=-1)
			return dp[index];
		int pick=arr[index]+func(index-2,arr,dp);
	    int notpick=0+func(index-1,arr,dp);
		return dp[index]=Math.max(pick,notpick);
	}
	public static void main(String[] args) 
	{
		int arr[]= {2,1,4,9};
		int n=arr.length;
		int dp[]=new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println("Maximum sum is: "+func(n-1,arr,dp));
	}
}


//Tabulation
public class maximumsum
{
	public static void main(String[] args) 
	{
		int arr[]= {2,1,4,9};
		int n=arr.length;
		int dp[]=new int[n];
		int neg=0;
		Arrays.fill(dp, -1);
		dp[0]=arr[0];
		for(int index=1;index<n;index++)
		{
			int pick=arr[index];
			if(index>1)
				pick+=dp[index-2];
			int notpick=0+dp[index-1];
			dp[index]=Math.max(pick,notpick);
		}
		System.out.println("Maximum sum is: "+dp[n-1]);
	}
}


//space optimisation
public class maximumsum
{
	public static void main(String[] args) 
	{
		int arr[]= {2,1,4,9};
		int n=arr.length;
		int prev1=arr[0];
		int prev2=0;
		for(int index=1;index<n;index++)
		{
			int pick=arr[index];
			if(index>1)
				pick+=prev2;
			int notpick=0+prev1;
			int curr=Math.max(pick,notpick);
			prev2=prev1;
			prev1=curr;
		}
		System.out.println("Maximum sum is: "+prev1);
	}
}

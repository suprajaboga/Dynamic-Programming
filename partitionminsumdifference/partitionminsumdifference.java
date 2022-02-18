//Dp 16. Partition A Set Into Two Subsets With Minimum Absolute Sum Difference | DP on Subsequences

package partitionminsumdifference;

import java.util.Arrays;

public class partitionminsumdifference 
{
	public static void main(String[] args)
	{
		int arr[]= {2,3,7};
		int n=arr.length;
		int tot_sum=0;
		for(int i=0;i<n;i++)
			tot_sum+=arr[i];
		boolean dp[][]=new boolean[n+1][tot_sum+1];
		for(boolean[] ele:dp)
			Arrays.fill(ele,false);
		for(int ind=0;ind<=n;ind++)
			dp[ind][0]=true;
		for(int index=1;index<=n;index++)
		{
			for(int target=1;target<=tot_sum;target++)
			{
				boolean take=false,nottake=false;  
				if(target>=arr[index-1])
					take=dp[index-1][target-arr[index-1]];
				nottake=dp[index-1][target];
				dp[index][target]=(take||nottake);
			}
		}
		int mini=Integer.MAX_VALUE;
		int s1,s2=0;
		for(int i=0;i<=tot_sum;i++)
		{
			if(dp[n][i]==true)
			{
				s1=i;
				s2=tot_sum-i;
				mini=Math.min(mini,Math.abs(s1-s2));
			}
				
		}
		System.out.println(mini);
	}
}

//DP.18 Divide an array into 2 subsets such that difference of 2 subsets should be equal to the difference given in the qstn

//arr= {5,2,6,4}		D=3
//s1= {6, 4}	s2= {5, 2}
//{6 + 4} - {5 + 2} = 10 - 7 = 3
//we can partition the array in only 1 way. So, no.of partitions = 1
//we know, totalsum = s1 + s2  ==> s1 = totalsum - s2
//in qstn, s1 - s2 = D  ==> s2 = (totalsum - d)/2, so we have to count total no.of subsets having sum = (totalsum-d)

package countpartitionswithgivendifference;
import java.util.*;

public class countpartitonswithgivendifference
{
	public static int countPartitions(int ind, int target,int k,int[] arr, int[][] dp)
	{
		if(ind == 0)
		{
	        if(target==0 && arr[0]==0)
	            return 2;
	        if(target==0 || target == arr[0])
	            return 1;
	        return 0;
	    }
		 //Checking for edge cases
	    if(k<0) 
	    	return 0;
	    if(k%2==1) 
	    	return 0;
	    if(dp[ind][target]!=-1)
	        return dp[ind][target];
	        
	    int notTaken = countPartitions(ind-1,target,k,arr,dp);
	    
	    int taken = 0;
	    if(arr[ind]<=target)
	        taken = countPartitions(ind-1,target-arr[ind],k,arr,dp);
	        
	    return dp[ind][target]= (notTaken + taken);
	}
	public static void main(String args[]) 
	{
	  int arr[] = {5,2,6,4};
	  int d=3;
	  int n = arr.length;
	    int totSum = 0;
	    for(int i=0; i<arr.length;i++)
	        totSum += arr[i];
	    int k=totSum-d;
	    int s2 = k/2;
	    int dp[][] = new int[n][s2+1];
	    for(int row[]: dp)
	    	Arrays.fill(row,-1);
	  System.out.println("The number of subsets found are "+countPartitions(n-1,s2,k,arr,dp));
	}
}


//https://takeuforward.org/data-structure/count-partitions-with-given-difference-dp-18/ --> refer to this article
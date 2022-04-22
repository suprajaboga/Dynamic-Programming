package longestincreasingsubsequence;

//Recursion
public class longestincreasingsubsequence
{
	public static int print(int index, int prev_index, int arr[])
	{
		int take = 0, not_take = 0;
		if(index == arr.length)
			return 0;
		not_take = 0 + print(index+1, prev_index, arr);
		if(prev_index == -1 || arr[index] > arr[prev_index])
			take = 1 + print(index+1, index, arr);
		int result = Math.max(take, not_take);
		return result;
	}
	public static void main(String args[])
	{
		int arr[] = new int[] {50, 3, 10, 7, 40, 80};
		System.out.println("Length of longest increasing subsequence: " + print(0, -1, arr));
	}
}


//Tabulation
public class longestincreasingsubsequence
{
	public static void main(String args[])
	{
		int arr[] = new int[] {50, 3, 10, 7, 40, 80};
		int n = arr.length;
		int maxi = 1;
		int dp[] = new int[n];
	        Arrays.fill(dp, 1);			//when single ele is considered,that's only the LIS, so initialise array with 1
		for(int ind=0;ind<n;ind++)
		{
			for(int prev=0;prev<ind;prev++)
			{
				if(arr[prev]<arr[ind])
					dp[ind] = Math.max(dp[ind], 1+dp[prev]);
			}
			maxi = Math.max(maxi, dp[ind]);
		}
		System.out.println("Length of longest increasing subsequence: " + maxi);
	}
}

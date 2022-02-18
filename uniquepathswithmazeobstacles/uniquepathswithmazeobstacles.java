//An obstacle is marked with -1, if -1 is encountered it can't move further

package uniquepathswithmazeobstacles;

public class uniquepathswithmazeobstacles
{
	public static int func(int i,int j,int arr[][],int dp[][])
	{
		if(i==0&&j==0)
			return 1;
		if(i<0||j<0)
			return 0;
		if(i>0&&j>0&&arr[i][j]==-1)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];
		int up = func(i-1,j,arr,dp);
		int left = func(i,j-1,arr,dp);
		return dp[i][j] = up + left;
	}
	public static void main(String[] args)
	{
		int m=3,n=3;
		int arr[][];
		arr= new int[][]{{1,1,1},{1,-1,1},{1,1,1}};
		int dp[][]=new int[m][n];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
				dp[i][j]=-1;
		}
		System.out.println("Unique paths: "+func(m-1,n-1,arr,dp));
	}

}

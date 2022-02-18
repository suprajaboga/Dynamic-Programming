//minimum path sum in grid problem

package minimumpathsum;

//Tabulation
public class minimumpathsum
{
	public static void main(String[] args)
	{
		int m=3,n=3;
		int grid[][];
		grid= new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
				dp[i][j]=-1;
		}
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0&&j==0)
                    dp[i][j]=grid[i][j];
                else
                {
                	 int up = grid[i][j] ;
                     if(i>0)
                         up+= dp[i-1][j];
                     else
                         up = Integer.MAX_VALUE;
     		        int left = grid[i][j];
                     if(j>0)
                         left+= dp[i][j-1];
                     else
                         left=Integer.MAX_VALUE;
     		        dp[i][j] = Math.min(up,left);
                }
            }
        }
        System.out.println("Minimun path sum: "+dp[m-1][n-1]);
    }
}
		
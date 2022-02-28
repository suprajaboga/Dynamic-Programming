//DP on grids, Similar to max or min path sum triangle, variable starting and variable ending point

package goldmine;

import java.util.Arrays;

//Recursion
//public class goldmine 
//{
//	public static int func(int i,int j,int arr[][])
//	{
//		if(i<0||i>=arr.length)
//			return Integer.MIN_VALUE;
//		if(j==0&&i<arr.length)
//			return arr[i][j];
//		int up = arr[i][j] + func(i,j-1,arr);
//		int leftdiagonal = arr[i][j] + func(i-1,j-1,arr);
//		int rightdiagonal = arr[i][j] + func(i+1,j-1,arr);
//		return Math.max(up, Math.max(leftdiagonal, rightdiagonal));
//	}
//
//	public static void main(String[] args) 
//	{
//		int row=4,col=4;
//		int arr[][];
//		arr= new int[][]{{1,3,1,5},{2,2,4,1},{5,0,2,3},{0,6,1,2}};
//		int maxi=Integer.MIN_VALUE;
//		for(int j=row-1;j>=0;j--)
//			maxi=Math.max(maxi, func(j,col-1,arr));
//		System.out.println("Maximum sum: "+ maxi);
//	}
//}


//Tabulation
public class goldmine 
{
	public static void main(String[] args) 
	{
		int row=4,col=4;
		int arr[][];
		arr= new int[][]{{1,3,1,5},{2,2,4,1},{5,0,2,3},{0,6,1,2}};
		int dp[][]=new int[row][col];
		for(int[] ele:dp)
			Arrays.fill(ele,-1);
		for(int i=0;i<row;i++)
            dp[i][0] = arr[i][0];
        for(int j=1;j<col;j++)
        {
           for(int i=0;i<row;i++)
           {
                int left = arr[i][j] + dp[i][j-1];
                int upleft = arr[i][j];
                if(i>0)
                     upleft+= dp[i-1][j-1];
                else
                    upleft = Integer.MIN_VALUE;
                int downleft = arr[i][j];
                if(i<arr.length-1)
                     downleft+= dp[i+1][j-1];
                else
                     downleft = Integer.MIN_VALUE;
                dp[i][j] = Math.max(left,Math.max(upleft,downleft));
           }
        }
        int maxi=Integer.MIN_VALUE;
		for(int j=col-1;j>=0;j--)
			maxi=Math.max(maxi, dp[j][col-1]);
		System.out.println("Maximum sum: "+ maxi);
	}
}

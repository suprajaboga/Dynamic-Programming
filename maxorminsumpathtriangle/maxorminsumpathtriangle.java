//DP.12 Minimum or maximum falling path sum, Variable starting and variable ending points i.e., from any point in the last row, we can
//go to any point in the 1st row such that path sum should be maximum. From the ith row and jth column, you can go
//(i-1,j) , (i-1,j-1) , (i-1,j+1)

package maxorminsumpathtriangle;
import java.util.*;

//Recursion
public class maxorminsumpathtriangle 
{
	public static int func(int i,int j,int arr[][])
	{
		if(j<0||j>=arr[0].length)
			return Integer.MIN_VALUE;
		if(i==0&&j<arr[0].length)
			return arr[i][j];
		int up = arr[i][j] + func(i-1,j,arr);
		int leftdiagonal = arr[i][j] + func(i-1,j-1,arr);
		int rightdiagonal = arr[i][j] + func(i-1,j+1,arr);
		return Math.max(up, Math.max(leftdiagonal, rightdiagonal));
	}
	public static void main(String[] args) 
	{
		int row=3,col=3;
		int arr[][];
		arr= new int[][]{{2,1,3},{6,5,4},{7,8,9}};
		int maxi=Integer.MIN_VALUE;
		for(int j=0;j<col;j++)
			maxi=Math.max(maxi, func(row-1,j,arr));
		System.out.println("Maximum sum: "+ maxi);
	}
}


//Memoization
public class maxorminsumpathtriangle 
{
	public static int func(int i,int j,int arr[][],int dp[][])
	{
		if(j<0||j>=arr[0].length)
			return Integer.MIN_VALUE;
		if(i==0&&j<arr[0].length)
			return arr[i][j];
		if(dp[i][j]!=-1)
			return dp[i][j];
		int up = arr[i][j] + func(i-1,j,arr,dp);
		int leftdiagonal = arr[i][j] + func(i-1,j-1,arr,dp);
		int rightdiagonal = arr[i][j] + func(i-1,j+1,arr,dp);
		return dp[i][j]=Math.max(up, Math.max(leftdiagonal, rightdiagonal));
	}
	public static void main(String[] args) 
	{
		int row=3,col=3;
		int arr[][];
		arr= new int[][]{{2,1,3},{6,5,4},{7,8,9}};
		int dp[][]=new int[row][col];
		for(int[] ele:dp)
			Arrays.fill(ele,-1);
		int maxi=Integer.MIN_VALUE;
		for(int j=0;j<col;j++)
			maxi=Math.max(maxi, func(row-1,j,arr,dp));
		System.out.println("Maximum sum: "+ maxi);
	}
}


//Tabulation
public class maxorminsumpathtriangle 
{
	public static void main(String[] args) 
	{
		int row=3,col=3;
		int arr[][];
		arr= new int[][]{{2,1,3},{6,5,4},{7,8,9}};
		int dp[][]=new int[row][col];
		for(int[] ele:dp)
			Arrays.fill(ele,-1);
		for(int j=0;j<col;j++)
			dp[0][j]=arr[0][j];
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				int up = arr[i][j] + dp[i-1][j];
				int leftdiagonal = arr[i][j];
				if(j-1>=0)
					leftdiagonal+= dp[i-1][j-1];
				else
					leftdiagonal=Integer.MIN_VALUE;
				int rightdiagonal = arr[i][j];
				if(j+1<col)
					rightdiagonal+= dp[i-1][j+1];
				else
					rightdiagonal=Integer.MIN_VALUE;
				dp[i][j]=Math.max(up, Math.max(leftdiagonal, rightdiagonal));
			}
		}
		int maxi=Integer.MIN_VALUE;
		for(int j=0;j<col;j++)
			maxi=Math.max(maxi, dp[row-1][j]);
		System.out.println("Maximum sum: "+ maxi);
	}
}

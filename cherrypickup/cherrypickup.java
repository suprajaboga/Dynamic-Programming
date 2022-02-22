//3D DP on grids, fixed starting and variable ending points

package cherrypickup;

import java.util.Arrays;

//Recursion
public class cherrypickup 
{
	public static int func(int i,int j1,int j2,int r,int c,int arr[][])
	{
		if(j1<0 || j2<0 || j1>=c || j2>=c)
			return Integer.MIN_VALUE;
		if(i==r-1)
		{
			if(j1 == j2)
				return arr[i][j1];
			else
				return arr[i][j1]+arr[i][j2];
		}
		//explore all paths of robot1 and robot2 simultaneously
		int maxi=Integer.MIN_VALUE;
		//for each robot1 step, robot2 can take 3 steps -1,0,+1
		for(int r1=-1;r1<=1;r1++)
		{
			for(int r2=-1;r2<=1;r2++)
			{
				int value=0;
				if(j1 == j2)
					value = arr[i][j1];
				else
					value = arr[i][j1]+arr[i][j2];
				value += func(i+1,j1+r1,j2+r2,r,c,arr);
				maxi=Math.max(maxi,value);
			}
		}
		return maxi;
	}

	public static void main(String[] args) 
	{
		int row=4,col=3;
		int arr[][];
		arr= new int[][]{{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
		//robot1 starts from [0,0] and robot2 starts from [0,col-1]
		System.out.println("Maximum sum: "+func(0,0,col-1,row,col,arr));
	}
}


//Memoization          TC: O(row*col*col) * 9 states     SC:  O(row*col*col) + O(recursion stack space)
public class cherrypickup 
{
	public static int func(int i,int j1,int j2,int r,int c,int arr[][],int dp[][][])
	{
		if(j1<0 || j2<0 || j1>=c || j2>=c)
			return Integer.MIN_VALUE;
		if(i==r-1)
		{
			if(j1 == j2)
				return arr[i][j1];
			else
				return arr[i][j1]+arr[i][j2];
		}
		if(dp[i][j1][j2]!=-1)
			return dp[i][j1][j2];
		//explore all paths of robot1 and robot2 simultaneously
		int maxi=Integer.MIN_VALUE;
		//for each robot1 step, robot2 can take 3 steps -1,0,+1
		for(int r1=-1;r1<=1;r1++)
		{
			for(int r2=-1;r2<=1;r2++)
			{
				int value=0;
				if(j1 == j2)
					value = arr[i][j1];
				else
					value = arr[i][j1]+arr[i][j2];
				value += func(i+1,j1+r1,j2+r2,r,c,arr,dp);
				maxi=Math.max(maxi,value);
			}
		}
		return dp[i][j1][j2]=maxi;
	}
	public static void main(String[] args) 
	{
		int row=4,col=3;
		int arr[][];
		arr= new int[][]{{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
		int dp[][][]=new int[row][col][col];
		for(int[][] ele:dp)
		{
			for(int[] ele1:ele)
				Arrays.fill(ele1,-1);
		}

		//robot1 starts from [0,0] and robot2 starts from [0,col-1]
		System.out.println("Maximum sum: "+func(0,0,col-1,row,col,arr,dp));
	}
}


//Tabulation
public class cherrypickup 
{
	public static void main(String[] args) 
	{
		int row=4,col=3;
		int arr[][];
		arr= new int[][]{{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
		int dp[][][]=new int[row][col][col];
		for(int[][] ele:dp)
		{
			for(int[] ele1:ele)
				Arrays.fill(ele1,-1);
		}
		int n=arr.length;
		//setting the base case if it's a last row
		for(int j1=0;j1<col;j1++)
		{
			for(int j2=0;j2<col;j2++)
			{
				if(j1 == j2)
					dp[n-1][j1][j2] = arr[n-1][j1];
				else
					dp[n-1][j1][j2] = arr[n-1][j1] + arr[n-1][j2];
			}
		}
		for(int i=n-2;i>=0;i--)
		{
			for(int j1=0;j1<col;j1++)
			{
				for(int j2=0;j2<col;j2++)
				{
					int maxi=Integer.MIN_VALUE;
					//for each robot1 step, robot2 can take 3 steps -1,0,+1
					for(int r1=-1;r1<=1;r1++)
					{
						for(int r2=-1;r2<=1;r2++)
						{
							int value=0;
							if(j1 == j2)
								value = arr[i][j1];
							else
								value = arr[i][j1]+arr[i][j2];
							if(j1+r1 >= 0 && j1+r1 < col && j2+r2 >= 0 && j2+r2 < col)
								value += dp[i+1][j1+r1][j2+r2];
							else
								value=Integer.MIN_VALUE;
							maxi=Math.max(maxi,value);
						}
					}
					dp[i][j1][j2]=maxi;
				}
			}
		}
		System.out.println("Maximum sum: "+dp[0][0][col-1]);
	}
}



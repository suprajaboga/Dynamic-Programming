//Each weight can be picked any no.of times to sum upto the given knapsack weight.Find the maximum that can be found 

package unboundedknapsack;

//Recursion		TC : O(greater than 2 pow n)		SC : O(target)
public class unboundedknapsack 
{
	public static int print(int index,int tot_weight,int weights[],int values[])
	{
		if(index==0)
		{
			return (tot_weight/weights[0])*values[0];
		}
		int nottake,take=Integer.MIN_VALUE;
		nottake=0+print(index-1,tot_weight,weights,values);
		if(weights[index]<=tot_weight)
			take=values[index]+print(index,tot_weight-weights[index],weights,values);
		return Math.max(nottake, take);
	}
	public static void main(String[] args) 
	{
		int n=3;
		int weights[]= {3,4,5};
		int values[]= {30,50,60};
		int tot_weight=8;
		System.out.println("Maximum value: "+print(n-1,tot_weight,weights,values));
	}
}



//Tabulation		TC : O(n*tot_weight)		SC : O(n*tot_weight)
public class unboundedknapsack 
{
public static void main(String[] args) 
{
	int n=3;
	int weights[]= {3,4,5};
	int values[]= {30,50,60};
	int tot_weight=8;
	int dp[][]=new int[n][tot_weight+1];
	//base condition if index=0
	for(int wt=0;wt<=tot_weight;wt++)
		dp[0][wt]=(wt/weights[0])*values[0];
	for(int index=1;index<n;index++)
	{
		for(int w=0;w<=tot_weight;w++)
		{
			int nottake,take=Integer.MIN_VALUE;
			nottake=dp[index-1][w];
			if(weights[index]<=w)
				take=values[index] + dp[index][w-weights[index]];
			dp[index][w]=Math.max(nottake, take);
		}
	}
	System.out.println("Maximum value: "+dp[n-1][tot_weight]);
}
}


//Space optimisation		TC : O(n*tot_weight)		SC : O(tot_weight)
public class unboundedknapsack 
{
public static void main(String[] args) 
{
	int n=3;
	int weights[]= {3,4,5};
	int values[]= {30,50,60};
	int tot_weight=8;
	int prev[]=new int[tot_weight+1];
	int curr[]=new int[tot_weight+1];
	//base condition if index=0
	for(int wt=0;wt<=tot_weight;wt++)
		prev[wt]=(wt/weights[0])*values[0];
	for(int index=1;index<n;index++)
	{
		for(int w=0;w<=tot_weight;w++)
		{
			int nottake,take=Integer.MIN_VALUE;
			nottake=prev[w];
			if(weights[index]<=w)
				take=values[index] + curr[w-weights[index]];
			curr[w]=Math.max(nottake, take);
		}
		prev=curr;
	}
	System.out.println("Maximum value: "+prev[tot_weight]);
}
}


//Further Space optimisation into single array, we don't use curr[], we use only prev[]	TC : O(n*tot_weight)		SC : O(tot_weight)
public class unboundedknapsack 
{
public static void main(String[] args) 
{
	int n=3;
	int weights[]= {3,4,5};
	int values[]= {30,50,60};
	int tot_weight=8;
	int prev[]=new int[tot_weight+1];
	//base condition if index=0
	for(int wt=0;wt<=tot_weight;wt++)
		prev[wt]=(wt/weights[0])*values[0];
	for(int index=1;index<n;index++)
	{
		for(int w=0;w<=tot_weight;w++)
		{
			int nottake,take=Integer.MIN_VALUE;
			nottake=prev[w];
			if(weights[index]<=w)
				take=values[index] + prev[w-weights[index]];
			prev[w]=Math.max(nottake, take);
		}
	}
	System.out.println("Maximum value: "+prev[tot_weight]);
}
}


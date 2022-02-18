//condition is don't pick adjacent elements and also 1st and last element is adjacent...so, if we pick 1st ele don't pick last ele and if we pick last
//ele don't pick 1st ele. so, take 2 temp arrays, in 1st temp array, don't put 1st ele and put last ele.. in 2nd temp array, put 1st ele and don't
//add last element

package houserobber2;

public class houserobber2
{
	public static int func(int temp[])
	{
		int prev1=temp[0];
		int prev2=0;
		for(int index=1;index<temp.length;index++)
		{
			int pick=temp[index];
			if(index>1)
				pick+=prev2;
			int notpick=0+prev1;
			int curr=Math.max(pick,notpick);
			prev2=prev1;
			prev1=curr;
		}
		return prev1;
	}
	public static void main(String[] args) 
	{
		int arr[]= {1,2,3};
		int n=arr.length;
		int temp1[]=new int[n-1];
		int temp2[]=new int[n-1];
		int k=0,j=0;
		for(int i=0;i<n;i++)
		{
			if(i!=0)
				temp1[k++]=arr[i];
			if(i!=n-1)
				temp2[j++]=arr[i];
		}
		System.out.println("Maximum sum is "+Math.max(func(temp1),func(temp2)));
	}
}
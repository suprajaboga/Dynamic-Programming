//a frog can jump k units from a given distance, i.e.; not 1 step or 2 steps when compared with previous problem

package frogjumpkdistance;

public class frogjumpkdistance {

	public static void main(String[] args) {
		int n=7;
		int k=4;
		int arr[]= {2,6,1,8,2,9,8};
		//pseudo code
		if(index==0)
			return 0;
		int minsteps=Integer.MAX_VALUE;
		for(int j=1;j<=k;j++)
		{
			int jump=f(index-j)+Math.abs(arr[index]-arr[index-j]);
			minsteps=min(minsteps,jump);
		}
		return minsteps;
	}

}

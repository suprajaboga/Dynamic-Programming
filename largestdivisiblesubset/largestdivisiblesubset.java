//Here, every element should be divisible with each other
//Here, we're finding length of largest divisible subset and also printing largest divisibe subset
//similar to longest increasing subsequence, but we first sort the array and change the condition to divisibility.


package largestdivisiblesubset;
import java.util.*;

public class largestdivisiblesubset
{
    public static void main(String args[]) 
    {
      int arr[] = new int[] {2, 8, 3, 4};
      List<Integer> list = new ArrayList<>();
      Arrays.sort(arr);
      int n = arr.length;
      int dp[] = new int[n];
      Arrays.fill(dp,1);
      int maxi = 1;
      for(int ind=0;ind<n;ind++)
      {
          for(int prev=0;prev<ind;prev++)
          {
              if(arr[ind] % arr[prev] == 0)
              {
                  dp[ind] = Math.max(dp[ind], 1+dp[prev]);
                  if(ind == n-1)
                  {
                      if(!list.contains(arr[ind]))
                        list.add(arr[ind]);
                  }
                  if(!list.contains(arr[prev]))
                    list.add(arr[prev]);
              }
          }
          maxi = Math.max(maxi, dp[ind]);
      }
      Collections.sort(list);
      System.out.println("Length of largest divisible subset: " + maxi);
      System.out.println("Largest divisible subset: " + list);
    }
}
//similar to longest increasing subsequence
//if we need to find only the longest string subsequence, then no need to sort
//if the order doesn't matter, like kind of subset, then first sort array in increasing order, then we can use the technique of longest increasing subsequence.

package longeststringchain;
import java.util.*;

public class longeststringchain
{
    public static boolean checkPossible(String s1, String s2)
    {
        int first=0,second=0;
        if(s1.length() != s2.length()+1)
            return false;
        while(first < s1.length())
        {
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second))
            {
                first++;
                second++;
            }
            else
                first++;
        }
        if(first == s1.length() && second == s2.length())
            return true;
        return false;
    }
    public static void main(String args[]) 
    {
      String arr[] = {"a","b","ba","bca","bda","bdca"};
      Arrays.sort(arr,new Comparator<String>() {
          public int compare(String s1,String s2) {
              return s1.length() < s2.length() ? -1 : 1;
          }
      });
      int n = arr.length;
      int dp[] = new int[n];
      Arrays.fill(dp,1);
      int maxi = 1;
      for(int ind=1;ind<n;ind++)
      {
          for(int prev=0;prev<ind;prev++)
          {
              if(checkPossible(arr[ind],arr[prev]))
                dp[ind] = Math.max(dp[ind], 1+dp[prev]);
          }
          maxi = Math.max(maxi, dp[ind]);
      }
      System.out.println("Length of longest string chain: " + maxi);
    }
}
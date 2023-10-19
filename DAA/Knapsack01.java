import java.util.*;
import java.lang.*;
public class Knapsack01 {
   public static int findMax(int n1, int n2) {
      if(n1>n2) {
         return n1;
      } else {
         return n2;
      }
   }
   public static int knapsack(int W, int wt[], int val[], int n) {
      int K[][] = new int[n+1][W+1];
      for(int i = 0; i<=n; i++) {
         for(int w = 0; w<=W; w++) {
            if(i == 0 || w == 0) {
               K[i][w] = 0;
            } else if(wt[i-1] <= w) {
               K[i][w] = findMax(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]);
            } else {
               K[i][w] = K[i-1][w];
            }
         }
      }
      return K[n][W];
   }
   public static void main(String[] args) {
      int[] val = {70, 20, 50};
      int[] wt = {11, 12, 13};
      int W = 30;
      int len = val.length;
      System.out.print("Maximum Profit achieved with this knapsack: " + knapsack(W, wt, val, len));
   }
}
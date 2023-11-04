import java.util.Scanner;

public class Knapsack01 {
    public static int knapsack(int W, int[] wt, int[] val, int len) {
        int[][] dp = new int[len + 1][W + 1];

        for (int i = 0; i <= len; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[len][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int len = scanner.nextInt();

        int[] val = new int[len];
        int[] wt = new int[len];

        System.out.println("Enter the values and weights of the items:");
        for (int i = 0; i < len; i++) {
            System.out.print("Value for item " + (i + 1) + ": ");
            val[i] = scanner.nextInt();
            System.out.print("Weight for item " + (i + 1) + ": ");
            wt[i] = scanner.nextInt();
        }

        System.out.print("Enter the maximum weight (W) of the knapsack: ");
        int W = scanner.nextInt();

        int maxProfit = knapsack(W, wt, val, len);
        System.out.println("Maximum Profit achieved with this knapsack: " + maxProfit);
    }
}

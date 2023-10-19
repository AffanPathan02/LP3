public class KnapsackProblem {
     public static void knapsackSolve(int n, int[] p, int[] w, int W, int[] used, int cur_w, float tot_v) {
        int maxi;
        while (cur_w > 0) {
            maxi = -1;
            for (int i = 0; i < n; ++i) {
                if ((used[i] == 0) &&
                        ((maxi == -1) || ((float) w[i] / p[i] > (float) w[maxi] / p[maxi])))
                    maxi = i;
            }

            used[maxi] = 1;
            cur_w -= p[maxi];
            tot_v += w[maxi];

            if (cur_w >= 0) {
                System.out.println("Added object " + (maxi + 1) + " (" + w[maxi] + "," + p[maxi] + ") completely in the bag. Space left: " + cur_w);
            } else {
                int percentage = (int) ((1 + (float) cur_w / p[maxi]) * 100);
                System.out.println("Added " + percentage + "% (" + w[maxi] + "," + p[maxi] + ") of object " + (maxi + 1) + " in the bag.");
                tot_v -= w[maxi];
                tot_v += (1 + (float) cur_w / p[maxi]) * w[maxi];
            }
        }
        System.out.println("Filled the bag with objects worth " + tot_v);
    }
    
    public static void main(String[] args) {
        int n = 5;
        int[] p = {3, 3, 2, 5, 1};
        int[] w = {10, 15, 10, 12, 8};
        int W = 10;

        int[] used = new int[10];
        int cur_w;
        float tot_v = 0;

        for (int i = 0; i < n; ++i)
            used[i] = 0;
        
        cur_w = W;
        knapsackSolve(n, p, w, W, used, cur_w, tot_v);
    }

   
}

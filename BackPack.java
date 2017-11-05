package lintcode;

public class BackPack {
    public int backPack(int m, int[] A) {
        if (A == null || m == 0) {
            return 0;
        }

        boolean[] DP = new boolean[m + 1];
        DP[0] = true;
        for (int i = 1; i <= A.length; i++) {
            for (int j = m; j >= 0; j--) {
                if (j - A[i - 1] >= 0 && DP[j - A[i - 1]]) {
                    DP[j] = true;
                }
            }
        }

        for (int j = m; j >= 0; j--) {
            if (DP[j]) {
                return j;
            }
        }
        return 0;
    }

    public int backPack0(int m, int[] A) {
        if (A == null || A.length == 0 || m <= 0) {
            return 0;
        }
        boolean[][] dp = new boolean[A.length + 1][m + 1];
        dp[0][0] = true;

        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                //j is large enough:
                if (j - A[i - 1] >= 0) {
                    //not added A[i - 1] or added A[i - 1]
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
                } else {// j not large enough, ofcourse not adding A[i-1]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //Largest possible size with dp[j] == true
        for (int j = m; j >= 0; j--) {
            if (dp[A.length][j]) {
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {2,3,5,7};
        int b = 11;
        BackPack backPack = new BackPack();
        int c = backPack.backPack(b, a);

        System.out.println(c);
    }
}

import java.util.Arrays;

public class BallsAdjacentDiff {


    static final int MAX = 11;

    static long[][][][][] dp = new long[MAX][MAX][MAX][MAX][4];

    static long cnt(int a, int b, int c, int d, int last) {
        if (a<0 || b<0 || c<0 || d<0)
            return 0;

        if (a==1 && b==0 && c==0 && d==0 && last == 0)
            return 1;
        if (a==0 && b==1 && c==0 && d==0 && last == 1)
            return 1;
        if (a==0 && b==0 && c==1 && d==0 && last == 2)
            return 1;
        if (a==0 && b==0 && c==0 && d==1 && last == 3)
            return 1;

        if (dp[a][b][c][d][last]!=-1)
            return dp[a][b][c][d][last];

        if (last==0)
            dp[a][b][c][d][last] = cnt(a-1, b, c, d, 1) + cnt(a-1, b, c, d, 2) + cnt(a-1, b, c, d, 3);
        else if (last==1)
            dp[a][b][c][d][last] = cnt(a, b-1, c, d, 0) + cnt(a, b-1, c, d, 2) + cnt(a, b-1, c, d, 3);
        else if (last==2)
            dp[a][b][c][d][last] = cnt(a, b, c-1, d, 0) + cnt(a, b, c-1, d, 1) + cnt(a, b, c-1, d, 3);
        else if (last==3)
            dp[a][b][c][d][last] = cnt(a, b, c, d-1, 0) + cnt(a, b, c, d-1, 1) + cnt(a, b, c, d-1, 2);

        return dp[a][b][c][d][last];
    }

    static long init(int a, int b, int c, int d) {
        for (long[][][][] row : dp)
            for (long[][][] innerX1Row : row)
                for (long[][] innerX2Row : innerX1Row)
                    for (long[] innerX3Row : innerX2Row)
                        Arrays.fill(innerX3Row, -1);

        return cnt(a, b, c, d, 0) + cnt(a, b, c, d, 1) + cnt(a, b, c, d, 2) + cnt(a, b, c, d, 3);
    }

    public static void solve() {
        System.out.println(init(10, 10, 10, 10));
    }
}

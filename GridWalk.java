import java.util.Arrays;

public class GridWalk {
    static int N = 3, M = 3;
    static int[][] a = {{1,2,2}, {1,1,2},{1,3,3}};
    static int[][] l = {{1,2,3},{1,1,2}};
    static int[][] r = {{1,2,3},{2,2,3}};
    static int[][] paths = new int[N][M];
    public static void main(String[] args) {
        Arrays.fill(paths[0], 1);
        for (int i=0; i<N-1; i++)
            for (int j=0; j<M; j++)
                for (int k=l[i][j]-1; k<=r[i][j]-1; k++)
                    paths[i + 1][k] += paths[i][j];
        System.out.println(Arrays.stream(paths[N-1]).sum());
    }
}

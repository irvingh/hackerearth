import java.util.Arrays;

public class HullPolygon {
    int N = 7;
    int M = 4;
    Point[] poly;
    double[][][][] dp;

    HullPolygon() {
        poly = new Point[N];
        poly[0] = new Point(0, 1);
        poly[1] = new Point(1, 0);
        poly[2] = new Point(2, 1);
        poly[3] = new Point(4, 0);
        poly[4] = new Point(1, 2);
        poly[5] = new Point(2, 2);
        poly[6] = new Point(0, 2);

        Point center = center();
        System.out.println(center);

        System.out.println(Arrays.toString(poly));
        Arrays.sort(poly, (p, q) -> {
            double p1 = Math.atan2(p.getY() - center.getY(), p.getX() - center.getX());
            double p2 = Math.atan2(q.getY() - center.getY(), q.getX() - center.getX());
            if (p1<p2)
                return 1;
            else if (p1>p2)
                return -1;
            return 0;
        });
        System.out.println(Arrays.toString(poly));

        dp = new double[N][N][N][M+1];

//        for (int i=0; i<N; i++) {
//            for (int j=0; j<N; j++)
//                for (int k=0; k<N; k++)
//                    dp[i][j][k][2] = 0;
//            for (int m=3; m<=M; m++) {
//                for (int j=i+1; j<N; j++) {
//                    int minArea = Integer.MAX_VALUE;
//                    for (int l=)
//                }
//            }
//        }
    }

    public void solve() {

    }
    double areaTriangle(int a, int b, int c) {
        return (double)Math.abs(poly[a].getX()*(poly[b].getY()-poly[c].getY()) + poly[b].getX()*(poly[c].getY()-poly[a].getY()) + poly[c].getX()*(poly[a].getY()-poly[b].getY())) / 2;
    }

    public Point center() {
        Point center = new Point(0, 0);
        for (int i=0; i<N; i++) {
            center.addX(poly[i].getX());
            center.addY(poly[i].getY());
        }
        center.setX(center.getX() / 2);
        center.setY(center.getY() / 2);
        return center;
    }

    public class Point {
        double x, y;
        Point(double x, double y) { setX(x); setY(y); }
        void setX(double x) { this.x = x; }
        void setY(double y) { this.y = y; }
        void addX(double x) { this.x += x; }
        void addY(double y) { this.y += y; }
        double getX() { return this.x; }
        double getY() { return this.y; }
        public String toString() { return " x=" + x + " y=" + y; }
    }
}
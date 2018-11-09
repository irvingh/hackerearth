import java.util.*;

public class GraphGCD {
    static int N = 7;
    static int[] ai;
    static int[] res;
    static int[][] gcd = new int[N][N];
    static ArrayList<LinkedList<Integer>> adj = new ArrayList<>();

    static class Graph {
        public static void addEdge(int src, int dst) {
            src--; dst--;
            adj.get(src).addFirst(dst);
            adj.get(dst).addFirst(src);
        }
        public static LinkedList<Integer> adjTo(int v) {
            return adj.get(v);
        }

        static Stack<Integer> path = new Stack<>();
        static HashSet<Integer> onPath = new HashSet<>();

        public static void allPaths(int src, int dst) {
            for (int i=0; i<N; i++)
                for (int j=i+1; j<N; j++) {
                    enumerate(i, i, j);
                }
        }
        public static void enumerate(int src, int tmp, int dst) {
            path.push(tmp);
            onPath.add(tmp);
            if (tmp==dst) {
                for (int i=1; i<path.size()-1; i++)
                    res[path.get(i)] = Math.max(res[path.get(i)], gcd[path.firstElement()][path.lastElement()]);
            } else {
//            if (tmp!=dst); {
//                res[tmp] = Math.max(res[tmp], gcd[src][dst]);
                for (int w : adjTo(tmp))
                    if (!onPath.contains(w))
                        enumerate(src, w, dst);
            }
            path.pop();
            onPath.remove(tmp);
        }
    }

    public static void allGCD() {
        gcd = new int[N][N];
        for (int i=0; i<N; i++) {
            gcd[i][i] = ai[i];
            for (int j=i+1; j<N; j++) {
                gcd[i][j] = gcd(ai[i], ai[j]);
                gcd[j][i] = gcd[i][j];
            }
        }
    }

    public static int gcd(int a, int b) {
        if (b==0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        Graph G = new Graph();
        G.addEdge(1, 2);
        G.addEdge(2, 3);
        G.addEdge(3, 4);
        G.addEdge(4, 5);
        G.addEdge(3, 6);
        G.addEdge(6, 7);

        ai = new int[]{2,1,6,1,6,1,3};
        allGCD();

        res = new int[7];
        G.allPaths(0, 6);
        System.out.println(Arrays.toString(res));
    }
}
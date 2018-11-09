package octCircuits18;

import java.util.*;

public class QuestionPaper {

    public static void main(String[] args) {
        int N = 1000;
        int A = 7;
        int B = 6;
        long l = System.currentTimeMillis();
        Set<Integer> marksDp = new HashSet<>();
        List<Mark> q = new LinkedList<>();
        marksDp.add(0);
        q.add(new Mark(0, 0));
        int i = 0;
        while (q.get(i).i < N) {
            if (marksDp.add(q.get(i).mark + A))
                q.add(new Mark(q.get(i).mark + A, q.get(i).i + 1));
            if (marksDp.add(q.get(i).mark - B))
                q.add(new Mark(q.get(i).mark - B, q.get(i).i + 1));
            i++;
        }
        System.out.println("FINISH=" + (System.currentTimeMillis() - l));
        System.out.println(marksDp.size());
//        TreeSet tsDp = new TreeSet();
//        tsDp.addAll(marksDp);
//        System.out.println(tsDp);
        Set<Integer> s = new HashSet<>();
        int k = 0, cnt = 0;
        l = System.currentTimeMillis();
        for (i=0; i<=N; i++) {
            for (int j = 0; j+i<=N; j++) {
                cnt++;
//                System.out.print(A * i - B * j + "   ");
                if (!s.contains(A * i - B * j))
                    s.add(A * i - B * j);
                else
                    k++;
            }
//            System.out.println();
        }
        System.out.println("FINISH=" + (System.currentTimeMillis() - l));
        System.out.println("cnt===="+cnt+"    k===="+k + "  " + (cnt-k));
    }

    public static class Mark {
        int mark;
        int i;
        Mark(int mark, int i) { this.mark = mark; this.i = i; }
    }
}
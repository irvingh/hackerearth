import java.util.ArrayList;

public class DivideNumber {
    DivideNumber() {
        int cnt = 0; long max=0;
        for (int i=1; i<40001; i++) {
            long tmp = solve(i);
            if (tmp>max)
                max=tmp;
        }
        System.out.println(max);
    }

    long solve(int N) {
        ArrayList<Integer> al=new ArrayList<>();
        int N2 = 1 + N / 2;
        int N7 = (N>7 ? N / 7 : 1);
        for (int i=N7; i<=N2; i++) {
            if (N%i==0)
                al.add(i);
        }
        int len = al.size();
        long max = -1;
        long maxCnt = 0;
        for (int a=0; a<len; a++) {
            long aa = al.get(a);
            for (int c=a; c<len; c++) {
                long cc = al.get(c);
                long dd = N - 2*aa - cc;
                maxCnt++;
                if (dd!=0 && N%dd==0) {
                    long m = aa*aa*cc*dd;
                    if (m>max) {
                        max = m;
                    }
                }
            }
        }
        return maxCnt;
    }
}
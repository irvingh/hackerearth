package octCircuits18;

public class ArrayRevolve {

    public static void main(String[] args) {
        int[] a = new int[]{4,1,2,3,9,1};
        System.out.println(query(6, 2, 5, a));
        update(6, 4, 5, a);
        System.out.println(query(6, 6, 6, a));
        update(6, 2, 4, a);
        System.out.println(query(6, 3, 1, a));
    }

    final static int M = 1000000007;

    static void update(int N, int ID, int VAL, int[] arr){
        // Write your code here
        if (VAL == 0)
            return;
        arr[ID-1] = (arr[ID-1] + VAL) % M;
        if (ID == N)
            update(N, 1, VAL - 1, arr);
        else
            update(N, ID + 1, VAL - 1, arr);
    }
    static int query(int N, int L, int R, int[] arr){
        // Write your code here
        return (int)(_query(N, L, R, arr) % M);
    }
    static int _query(int N, int L, int R, int[] arr){
        // Write your code here
        if (L == R)
            return arr[L-1];
        if (L == N)
            return (arr[L-1] + _query(N, 1, R, arr));
        else
            return (arr[L-1] + _query(N, L + 1, R, arr));
    }}

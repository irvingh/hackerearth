public class QuadraticResidue {
    public static void main(String[] args) {
        int N = 9;
        int M = 1000000;

        for (int x=0; x<1000000; x++) {
            if ((x*x)%M==N) {
                System.out.println(x);
                break;
            }
        }
    }
}
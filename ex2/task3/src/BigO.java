import java.util.Scanner;

public class BigO {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("n?");
        int n = Integer.valueOf(input.next());
        System.out.println(n);
        System.out.println("6n");
        System.out.println(6*n);
        System.out.println("3 log n");
        System.out.println(3 *Math.log(n));
        System.out.println("√n log n");
        System.out.println(Math.pow(n,(double)1/2)*Math.log(n));
        System.out.println("5n^2");
        System.out.println(5*Math.pow(n,2));
        System.out.println("√n");
        System.out.println(Math.pow(n,(double)1/2));
        System.out.println("42");
        System.out.println(42);
        System.out.println("n!");
        System.out.println(fac(n));
        System.out.println("7 log log n");
        System.out.println(7*Math.log(Math.log(n)));
        System.out.println("n log n");
        System.out.println(n*Math.log(n));
    }
    private static int fac(int n){
        int acc = 1;
        for(int i =1;i<=n;i++){
            acc=acc*i;
        }
        return acc;
    }
}
public class FibonacciSeries {
    public static void main(String[] args) {
        int count = 10; 
        int[] fibonacci = new int[count];

        
        fibonacci[0] = 0;
        fibonacci[1] = 1;

       
        for (int i = 2; i < count; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        
        System.out.println("Fibonacci Series up to " + count + " terms:");
        for (int num : fibonacci) {
            System.out.print(num + " ");
        }
    }
}

public class PrimeNumbersInArray {

    public static void main(String[] args) {
        int[] numbers = {10, 15, 3, 7, 5, 20, 2, 11, 13, 16, 17, 19};
        
        System.out.println("Prime numbers in the array are:");
        for (int number : numbers) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
    }

    
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

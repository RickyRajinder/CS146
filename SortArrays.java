
public class SortArrays {

    /*
    Selection Sort is O(n^2)
     */
    public static void selectionSort(double[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    double temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int fibonacciRecurse(int n){
        if (n == 0 || n == 1) {
            return n;
        }
        else
            return fibonacciRecurse(n-2) + fibonacciRecurse(n-1);
    }

    public static int fibonacciIteration(int n){
        if (n == 0 || n ==1) {
            return n;
        }
        int temp1 = 0;
        int temp2 = 1;
        int result = 0;
        for (int i = 0; i < n; i++){
            result = temp1 + temp2;
            temp1 = temp2;
            temp2 = result;
        }
        return result;
    }



}

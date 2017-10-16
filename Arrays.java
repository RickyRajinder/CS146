public class Arrays {

    public static int getMax(int[] arr){
        int x = arr[0];
        int pos = 0;
        for (int i = 0; i < arr.length; i++){
            if ((arr[i] >= x)) {
                x = arr[i];
                pos = i;
            }

        }
        return pos;
    }

    public static int getMin(int[] arr){
        int x = arr[0];
        int pos = 0;
        for (int i = 0; i < arr.length; i++){
            if ((arr[i] < x)) {
                x = arr[i];
                pos = i;
            }

        }
        return pos;
    }

    public static void swapLargestAndSmallest(int[] a)
    {
      int minPos = getMin(a);
      int maxPos = getMax(a);

      int temp = a[minPos];
      a[minPos] = a[maxPos];
      a[maxPos] = temp;
    }

    public static void main(String[] args)
    {
        int[] a = new int[] { 5, 4, 1, 9, 2, 6 };
        System.out.println(getMin(a));
        System.out.println(getMax(a));
        Arrays.swapLargestAndSmallest(a);
        System.out.println(java.util.Arrays.toString(a));
        System.out.println("Expected: [5, 4, 9, 1, 2, 6]");
        a = new int[] {1, 4, 1, 9, 2, 6};
        Arrays.swapLargestAndSmallest(a);
        System.out.println(java.util.Arrays.toString(a));
        System.out.println("Expected: [9, 4, 1, 1, 2, 6]");
        a = new int[] {1, 4, 2, 9, 9, 6};
        Arrays.swapLargestAndSmallest(a);
        System.out.println(java.util.Arrays.toString(a));
        System.out.println("Expected: [9, 4, 2, 9, 1, 6]");
        a = new int[] {1};
        Arrays.swapLargestAndSmallest(a);
        System.out.println(java.util.Arrays.toString(a));
        System.out.println("Expected: [1]");
    }
}

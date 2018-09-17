import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {

    }

    public static int[] bSort(int[] numArray) {
        int[] copy = Arrays.copyOf(numArray, numArray.length);
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < copy.length; i++) {
                int temp = 0;
                if (copy[i - 1] > copy[i]) {
                    temp = copy[i - 1];
                    copy[i - 1] = copy[i];
                    copy[i] = temp;
                    swapped = true;
                }
            }
        }
        return copy;
    }
}

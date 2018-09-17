import java.io.File;
import java.net.URI;
import java.net.URL;
import java.time.Instant;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Sort {
    public static void main(String[] args) {
        int[] data1 = pullDataFromFile("data1.txt");
        int[] data2 = pullDataFromFile("data2.txt");
        int[] data3 = pullDataFromFile("data3.txt");
        int[] data4 = pullDataFromFile("data4.txt");

        long bSort1 = bubbleBench(data1);
        long bSort2 = bubbleBench(data2);
        long bSort3 = TimeUnit.MILLISECONDS.convert(bubbleBench(data3),TimeUnit.NANOSECONDS);
        long bSort4 = TimeUnit.MILLISECONDS.convert(bubbleBench(data4),TimeUnit.NANOSECONDS);

        long stdSort1 = stdSort(data1);
        long stdSort2 = stdSort(data2);
        long stdSort3 = TimeUnit.MILLISECONDS.convert(stdSort(data3),TimeUnit.NANOSECONDS);
        long stdSort4 = TimeUnit.MILLISECONDS.convert(stdSort(data4),TimeUnit.NANOSECONDS);

        System.out.println("bsort:std sort");
        System.out.println(bSort1 + ":" + stdSort1);
        System.out.println(bSort2 + ":" + stdSort2);
        System.out.println(bSort3 + ":" + stdSort3);
        System.out.println(bSort4 + ":" + stdSort4);

    }
    private static long bubbleBench(int[] arr){
        int[] copy = Arrays.copyOf(arr, arr.length);
        long begin = System.nanoTime();
        bSort(copy);
        long end = System.nanoTime();
        return end - begin;
    }
    private static long stdSort(int[] arr){
        long begin = System.nanoTime();
        Arrays.sort(arr);
        long end = System.nanoTime();
        return end - begin;
    }
    private static void bSort(int[] numArray) {

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < numArray.length; i++) {
                int temp = 0;
                if (numArray[i - 1] > numArray[i]) {
                    temp = numArray[i - 1];
                    numArray[i - 1] = numArray[i];
                    numArray[i] = temp;
                    swapped = true;
                }
            }
        }
    }

    private static int[] pullDataFromFile(String filename){
        try {
            String resource = Sort.class.getResource(filename).getFile();
            File temp = new File(resource);
            Scanner scan = new Scanner(temp);

            String content = scan.nextLine();
            String[] partials = content.split(" ");
            int[] datas = new int[partials.length];
            for (int i = 0; i < partials.length; i++) {
                datas[i] = Integer.parseInt(partials[i]);
            }
            scan.close();
            return datas;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new int[0];
        }
    }
}

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Mean {
    public static void main(String[] args) {
        String path = Mean.class.getResource("data2.txt").getFile();
        File file = new File(path);
        Optional<Stream<String>> sStream = toStringStream(file.getAbsolutePath());
        int[] total = sStream.map(Mean::toIntArr).orElse(new int[0]);
        System.out.println("arith");
        System.out.println(arithmeticMean(total));
        System.out.println("harmonic");
        System.out.println(harmonicMean(total));
        System.out.println("geometric");
        System.out.println(geometricMean(total));
    }

    private static double arithmeticMean(int[] values){
        int sum = Arrays.stream(values).reduce(0,(a,b) -> a+b);
        return (double)sum / (double)values.length;
    }
    private static double harmonicMean(int[] values){
        double sum = Arrays.stream(values)
                .asDoubleStream()
                .reduce(0,(acc, val)-> acc + Math.pow(val,-1));
        return (double)values.length / sum;
    }
    private static double geometricMean(int[] values){
        double total = Arrays.stream(values).asDoubleStream().reduce(1,(a,b)-> a*b);
        return Math.pow(total,1/(double)values.length);
    }



    private static Optional<Stream<String>> toStringStream(String fileName) {
        Optional<Stream<String>> textStream = Optional.empty();
        try{
            textStream =  Optional.of(Files.lines(Paths.get(fileName)));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return textStream;
    }
    private static int[] toIntArr(Stream<String> sStream){
        return sStream
                .map(str -> str.split(" "))
                .map(Mean::strAToIntA)
                .reduce(new int[0],(a,b) -> IntStream.concat(Arrays.stream(a),Arrays.stream(b)).toArray());
    }
    private static int[] strAToIntA(String[] strA){
        return  Arrays.stream(strA)
                .mapToInt(Integer::valueOf).toArray();
    }
}

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MinMax {
    public static void main(String[] args) {
        String path = MinMax.class.getResource("data.txt").getFile();
        File file = new File(path);
        Optional<Stream<String>> sStream = toStringStream(file.getAbsolutePath());
        int[] total = sStream.map(MinMax::toIntArr).orElse(new int[0]);
        System.out.println("max");
        System.out.println(max(total));
        System.out.println("min");
        System.out.println(min(total));
    }

    public static OptionalInt minCheat(int[] values){
        return Arrays.stream(values).min();
    }
    private static int max(int[] values){
        return Arrays.stream(values)
                .reduce(Integer.MIN_VALUE,(a,b)-> a>b?a:b);
    }
    private static int min(int[] values){
        return Arrays.stream(values)
                .reduce(Integer.MAX_VALUE,(a,b)-> a<b?a:b);
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
                .map(MinMax::strAToIntA)
                .reduce(new int[0],(a,b) -> IntStream.concat(Arrays.stream(a),Arrays.stream(b)).toArray());
    }
    private static int[] strAToIntA(String[] strA){
        return  Arrays.stream(strA)
                .mapToInt(Integer::valueOf).toArray();
    }
}

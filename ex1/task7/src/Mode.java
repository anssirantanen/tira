import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Mode {
    public static void main(String[] args) {
        String path = Mode.class.getResource("data.txt").getFile();
        File file = new File(path);
        Optional<Stream<String>> sStream = toStringStream(file.getAbsolutePath());
        int[] total = sStream.map(Mode::toIntArr).orElse(new int[0]);
        System.out.println(countMode(total));
    }

    private static List<Integer> countMode(int[] values){
        Map<Integer,Integer> agg = new HashMap<>();
        Arrays.stream(values).forEach(num ->agg.merge(num,1,(a,b)-> a+b));
        int hit = 0;
        List<Integer> high= new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : agg.entrySet()){
            if (entry.getValue() > hit) {
                hit = entry.getValue();
                high.clear();
                high.add(entry.getKey());
            } else if (entry.getValue() == hit) {
                high.add(entry.getKey());
            }
        }
        return high;
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
                .map(Mode::strAToIntA)
                .reduce(new int[0],(a,b) -> IntStream.concat(Arrays.stream(a),Arrays.stream(b)).toArray());
    }
    private static int[] strAToIntA(String[] strA){
        return  Arrays.stream(strA)
                .mapToInt(Integer::valueOf).toArray();
    }
}

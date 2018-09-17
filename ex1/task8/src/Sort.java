import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sort {   public static void main(String[] args) {
    String path = Sort.class.getResource("data3.txt").getFile();
    File file = new File(path);
    Optional<Stream<String>> sStream = toStringStream(file.getAbsolutePath());
    String[] strArr = sStream.map(stringStream -> (String[])stringStream.toArray(String[]::new)).orElse(new String[0]);
    Arrays.sort(strArr);
    System.out.println(Arrays.toString(strArr));
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
}

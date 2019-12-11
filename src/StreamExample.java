import java.io.*;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.StringTokenizer;

public class StreamExample {
    private static int sum = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Random rand = new Random();

        int sum = 0;

        int sum2 = rand.ints(100, 1, 100)
         .filter(x -> x % 2 == 0) // Predicate used to filter out some of the stream
         .map(x -> x * x) // Function<int -> int> used to change things in the stream
         .reduce((r, x) -> r + x) // Using unitary version, returns Optional
         // .reduce(0, (r, x) -> r + x) // Start at 0, add each element (Uses Function (BinaryOperator))
         // .sum() // A reduction type operation that gives a single int value
         // .reduce(x -> sum += x) // Can't do this as Java does not permit this sort of variable access
         // .forEach(x -> StreamExample.sum += x) // A Consumer, using the elements in the stream, would have no return
         .orElse(0) // Returns the answer unless we got a null, then it returns 0
        ;


        var in = new BufferedReader(new InputStreamReader(new FileInputStream("string.txt")));

        String result = in.lines().filter(x -> x.contains("i"))
          .map(x -> x + "MinhajWasHere")
          .min((x, y) -> x.compareToIgnoreCase(y)) // Returns Optional
          .orElseThrow(NoSuchElementException::new); // Throw exception if the answer isn't there


    }

}

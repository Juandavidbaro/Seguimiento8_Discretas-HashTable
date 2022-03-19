import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */
	private Array magazine;
	private Array note;
	
    public static void checkMagazine(List<String> magazine, List<String> note) {
    // Write your code here
    	
        if(note.size() > magazine.size()){
            System.out.println("No");
            return;
        }

        Map<String, Integer> map = new HashMap<>();
        for(String s : magazine){
            if(!map.containsKey(s)){
                map.put(s, 1);
            } else {
                map.put(s, map.get(s)+1);
            }
        }

        for(String ns : note){
            if(map.containsKey(ns)){
                map.put(ns, map.get(ns)-1);
                if(map.get(ns) < 0){
                    System.out.println("No");
                    return;
                }
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
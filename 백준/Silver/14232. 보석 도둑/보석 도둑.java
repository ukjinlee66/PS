import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // int []arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long N = Long.parseLong(br.readLine());
        LinkedList<Long> list = new LinkedList<>();
        for(long i=2;i<=Math.sqrt(N);i++){
            while(N % i == 0){
                list.add(i);
                N /= i;
            }
        }
        if (N != 1) list.add(N);
        bw.write(list.size() + "\n");
        for(int i=0;i<list.size();i++) {
            if (i == list.size() - 1) 
                bw.write(list.get(i) + "\n");
            else
                bw.write(list.get(i) + " ");
        }
        bw.flush();
    }
}
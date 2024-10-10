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
        
        int N = Integer.parseInt(br.readLine());
        boolean checker[] = new boolean[1000];
        Arrays.fill(checker, true);
        for(int i=123;i<=987;i++) {
            int first = Integer.toString(i).charAt(0) - '0';
            int second = Integer.toString(i).charAt(1) - '0';
            int third = Integer.toString(i).charAt(2) - '0';
            if ((first == 0 || second == 0 || third == 0) || (first == second || first == third || second == third)) {
                checker[i] = false;
            }
        }

        for (int i=0;i<N;i++) {
            int []arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int first = Integer.toString(arr[0]).charAt(0) - '0';
            int second = Integer.toString(arr[0]).charAt(1) - '0';
            int third = Integer.toString(arr[0]).charAt(2) - '0';
            int strike = arr[1];
            int ball = arr[2];
            
            for(int j=123;j<=987;j++) {
                if (checker[j]) {
                    int first2 = Integer.toString(j).charAt(0) - '0';
                    int second2 = Integer.toString(j).charAt(1) - '0';
                    int third2 = Integer.toString(j).charAt(2) - '0';
                    if (first2 == 0 || second2 == 0 || third2 == 0) continue;
                    if (first2 == second2 || first2 == third2 || second2 == third2) continue;
                    int strike2 = 0;
                    int ball2 = 0;
                    
                    if (first == first2) strike2++;
                    if (second == second2) strike2++;
                    if (third == third2) strike2++;
                    
                    if (first == second2 || first == third2) ball2++;
                    if (second == first2 || second == third2) ball2++;
                    if (third == first2 || third == second2) ball2++;
                    
                    if (strike != strike2 || ball != ball2) {
                        checker[j] = false;
                    }
                }
            }
        }
        int ret =0;
        for (int i=123;i<=987;i++) {
            if (checker[i]) {
                ret++;
            }
        }
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
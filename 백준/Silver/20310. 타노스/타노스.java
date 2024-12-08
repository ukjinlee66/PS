import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int INF = Integer.MAX_VALUE;
    static int ret;
    static int N;
    static int In[];
    static String str;
    static int zero, one;
    
    public static void main(String[] args)    throws IOException {
        str = br.readLine();
        zero = 0;
        one = 0;
        for(int i=0;i<str.length();i++) {
            if (str.charAt(i) == '0') {
                zero++;
            } else {
                one++;
            }
        }
        zero /=2;
        one /= 2;
        while (zero > 0) {
            bw.write("0");
            zero--;
        }
        while (one > 0) {
            bw.write("1");
            one--;
        }
        bw.write("\n");
        
        bw.flush();
        bw.close();
    }
}
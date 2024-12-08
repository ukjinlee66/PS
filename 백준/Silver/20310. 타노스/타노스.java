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
        StringBuilder s = new StringBuilder();
        for(int i=0;i<str.length();i++) {
            s.append(str.charAt(i));
        }
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '0') {
                for(int j=s.length()-1;j>i;j--) {
                    if (s.charAt(j) == '0') {
                        s.setCharAt(j, '2');
                        s.setCharAt(i, '3');
                        break;
                    }
                }
            } else if (s.charAt(i) == '1') {
                for(int j=s.length()-1;j>i;j--) {
                    if (s.charAt(j) == '1') {
                        s.setCharAt(i, '2');
                        s.setCharAt(j, '4');
                        break;
                    }
                }
            }
        }
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '2')
                continue;
            if (s.charAt(i) == '3') {
                bw.write("0");
            } else if (s.charAt(i) == '4') {
                bw.write("1");
            }
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
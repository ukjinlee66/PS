import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static String in[];
    static int answer = 0;
        public static void main(String[] args)    throws IOException {
                N = Integer.parseInt(br.readLine());
                in = new String[N];
                for (int i=0;i<N;i++) {
                    in[i] = br.readLine();
                }
                Arrays.sort(in, new CompStr());
                for(String a : in)
                    bw.write(a+"\n");
                bw.flush();
                bw.close();
            }
        public static class CompStr implements Comparator<String> {

            @Override
            public int compare(String a, String b) {
                if (a.length() != b.length()) {
                    return Integer.compare(a.length(), b.length());
                } else {
                    
                    int aNum = StringToInt(a);
                    int bNum = StringToInt(b);

                    if (aNum == bNum) {
                        return a.compareTo(b);
                    } else {
                        return aNum - bNum;
                    }
                } 
            }
            public int StringToInt(String a) {
                int ret = 0;
                for(char c : a.toCharArray()) {
                    if(Character.isDigit(c))
                        ret+=c-'0';
                }
                return ret;
            }
        }
}
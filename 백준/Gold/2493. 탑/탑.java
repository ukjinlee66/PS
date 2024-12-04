import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int In[];
    static int ret[];
    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Top> s = new Stack<>();

        for(int i=0;i<In.length;i++) {
            if (s.isEmpty()) {
                bw.write("0");
                s.push(new Top(In[i], i+1));
            } else {
                if (s.peek().value <= In[i]) {
                    while(!s.isEmpty()) {
                        s.pop();
                        if (s.isEmpty()) {
                            bw.write("0");
                            s.push(new Top(In[i], i+1));
                            break;
                        } 
                        else if (s.peek().value > In[i]) {
                            bw.write(s.peek().idx + "");
                            s.push(new Top(In[i], i+1));
                            break;
                        }
                    }
                } else {
                    bw.write(s.peek().idx + "");
                    s.push(new Top(In[i], i+1));
                }
            }
            if (i==In.length-1) {
                bw.write("\n");
            } else {
                bw.write(" ");
            }
        }
        bw.flush();
        bw.close();
    }

    public static class Top {
        int value;
        int idx;
        public Top(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }
}
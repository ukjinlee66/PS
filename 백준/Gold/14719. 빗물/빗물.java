import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int map[][];
    public static void main(String[] args) throws IOException {
        int In[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new int[In[1]][In[0]];
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxIdx = 0;
        int maxNum = 0;
        for(int i=0;i<In.length;i++) {
            if (maxNum < In[i]) {
                maxNum = In[i];
                maxIdx = i;
            }
        }
        int currentHeight = 0;
        int ret = 0;
        int sum = 0;
        for(int i=0;i<=maxIdx;i++) {
            if (In[i] > 0 && currentHeight == 0) {
                currentHeight = In[i];
            } else if (currentHeight > In[i]) {
                sum+=currentHeight - In[i];
            } else {
                currentHeight = In[i];
                ret += sum;
                sum = 0;
            }
        }
        currentHeight = 0;
        sum = 0;
        for(int i=In.length-1;i>=maxIdx;i--) {
            if (In[i] > 0 && currentHeight == 0) {
                currentHeight = In[i];
            } else if (currentHeight > In[i]) {
                sum+=currentHeight - In[i];
            } else {
                currentHeight = In[i];
                ret += sum;
                sum = 0;
            }
        }
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }
}
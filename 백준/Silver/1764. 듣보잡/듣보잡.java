import java.io.*;
import java.util.*;

    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static int N,M;
        static String str;
        static int ret;
        static int In[];
        static int map[][];
        static Queue<Integer> q = new LinkedList<>();
    
        public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In[0];
        M = In[1];
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for(int i=0;i<N;i++) {
            str = br.readLine();
            set1.add(str);
        }
        for(int i=0;i<M;i++) {
            str = br.readLine();
            set2.add(str);
        }
        set2.retainAll(set1);
        bw.write(set2.size() + "\n");
        ArrayList<String> list = new ArrayList<>(set2);
        Collections.sort(list);
        for(String s : list) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
}
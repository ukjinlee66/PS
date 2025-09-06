import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int answer = 0;
        public static void main(String[] args)    throws IOException {
                N = Integer.parseInt(br.readLine());
                Map<Long, Integer> map = new HashMap<>();
                for (int i=0;i<N;i++) {
                    Long in = Long.parseLong(br.readLine());
                    if (map.containsKey(in)) {
                        map.put(in, map.get(in)+1);
                    } else {
                        map.put(in, 1);
                    }
                }
                List<Long> keySet = new ArrayList<>(map.keySet());
                keySet.sort(new Comparator<Long>() {
                    @Override
                    public int compare(Long a, Long b) {
                        if (!map.get(a).equals(map.get(b)))
                            return Integer.compare(map.get(b), map.get(a));
                        return a.compareTo(b);
                        
                    }
                });
                bw.write(keySet.get(0)+"\n");
                bw.flush();
                bw.close();
            }
}
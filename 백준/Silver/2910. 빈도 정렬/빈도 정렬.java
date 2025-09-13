import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Map<Integer, Integer> map = new HashMap<>();
    static Map<Integer, Integer> rank = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int[] T = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] N = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i=0;i<N.length;i++) {
            map.put(N[i],map.getOrDefault(N[i], 0)+1);
            if (!rank.containsKey(N[i])) {
                rank.put(N[i],i);
            }
        }
        List<Integer> keyList = Arrays.stream(N).boxed().collect(Collectors.toList());
        keyList.sort(new Comparator<>() {
            @Override
            public int compare(Integer k1, Integer k2) {
                if (map.get(k1).equals(map.get(k2))) { // value equals
                    return rank.get(k1).compareTo(rank.get(k2));
                }
                return map.get(k2).compareTo(map.get(k1));
            }
        });
        for (Integer i : keyList) {
            bw.write(i + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
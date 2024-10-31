import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int arr[];
    static int ar[];
    static int result[];

    public static void main(String[] args) throws IOException {
        // long N = Long.parseLong(br.readLine());
        // int N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int GCD = arr[0];
        int LCM = arr[1];
        int multi = GCD * LCM;
        // a 와 b는 서로소 GCD(a,b) = 1 즉 서로소의 차가 가장 작은 경우를 찾아야 한다.
        // n1 = GCD * a
        // n2 = GCD * b
        // a * b = LCM / GCD
        int minN1 = 0;
        int minN2 = 0;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=Math.sqrt(LCM/GCD);i++) {
            if ((LCM/GCD) % i == 0) {
                int a = i;
                int b = (LCM/GCD) / i;
                if (getGCD(a,b) == 1) {
                    int n1 = GCD * a;
                    int n2 = GCD * b;
                    if (n1 * n2 == multi) {
                        if (Math.abs(n1-n2) < min) {
                            min = Math.abs(n1-n2);
                            minN1 = n1;
                            minN2 = n2;
                        }
                    }
                }
            }
        }

        bw.write(minN1 + " " + minN2 + "\n");
        bw.flush();
        bw.close();
    }

    public static void permutation(int depth, boolean[] visited, int start) throws IOException {
        if (depth == M) {
            for(int i=0;i<M;i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=start;i<N;i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = ar[i];
                permutation(depth+1, visited, start+1);
                visited[i] = false;
            }
        }
    }

    public static void permutation(int depth, int start) throws IOException {
        if (depth == M) {
            for(int i=0;i<M;i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=0;i<N;i++) {
            result[depth] = ar[i];
            permutation(depth+1, i);
        }
    }

    public static void combination(int cnt, int start, boolean visited[]) throws IOException {
        if (cnt == M) {
            for(int i=0;i<N;i++) {
                if (visited[i]){
                    bw.write(ar[i] + " ");
                }
            }
            bw.write("\n");
            return;
        }
        if (start == N) {
            return;
        }
        visited[start] = true;
        combination(cnt+1, start + 1, visited);
        visited[start] = false;
        combination(cnt, start + 1, visited);
    }

    public static void combination(int idx, int cnt, int start) throws IOException {
        if (cnt == M) {
            for(int i=0;i<result.length;i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        if (start == N) {
            return;
        }
        result[idx] = ar[start];
        combination(idx+1,cnt+1, start);
        combination(idx,cnt, start+1);
    }

    public static int getGCD(int n1, int n2) {
        if (n1 % n2 == 0) {
            return n2;
        } else {
            return getGCD(n2, n1 % n2);
        }
        //LCM : n1 * n2 / GCD
    }
    public static int[] reverseGCD(int GCD, int LCM) {
        int x1 = 2;
        int x2 = 2+GCD;
        for(int i=x1;i<=x2;i+=GCD) {
            if (LCM % i == 0) {
                return new int[]{i, LCM/i};
            }
        }
        return new int[]{0,0};
        
    }
    public static int getLCM(int a[]) {
        if (a.length == 1) {
            return a[0];
        }
        int gcd = getGCD(a[0], a[1]);
        int lcm = a[0] * a[1] / gcd;

        for(int i=2;i<a.length;i++) {
            gcd = getGCD(lcm, a[i]);
            lcm = lcm * a[i] / gcd;
        }
        // gcd or lcm
        return lcm;
    }
}
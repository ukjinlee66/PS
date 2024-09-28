import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean[] isPrime;
    
    static void isPrime_fun(int n){ 
        isPrime = new boolean[n+1]; // N번째의 수 까지 받기위해 N+1까지 동적할당
        
        for(int i = 0; i < isPrime.length; i++){
            isPrime[i] = true; // boolean배열의 default값은 false이므로 true로 바꿔주기
        }
        
        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아니니깐 false
        
        for(int i = 2; i <= Math.sqrt(n); i++){ // 2부터 n의 제곱근까지의 모든 수를 확인
            if(isPrime[i]){ // 해당수가 소수라면, 해당수를 제외한 배수들을 모두 false 처리하기
                for(int j = i*i; j<= n; j += i){//그 이하의 수는 모두 검사했으므로 i*i부터 시작
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // int []arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = Integer.parseInt(br.readLine());
        isPrime_fun(1000000);
        for (int i=0;i<N;i++) {
            long number = Long.parseLong(br.readLine());
            
            if (isPrimeNumber(number)) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isPrimeNumber(long targetNumber) {
        for (int i=0;i<1000000;i++) {
            if (isPrime[i]) {
                if (targetNumber % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
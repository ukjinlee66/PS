import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int apartment[][];
    static int prefixSumApartment[][];
    static int in[];
    static int answer = 0;
        public static void main(String[] args)    throws IOException {
            N = Integer.parseInt(br.readLine());
            apartment = new int[15][15];
            prefixSumApartment = new int[15][15];
            initApartment();
            for(int i=0;i<N;i++) {
                int k = Integer.parseInt(br.readLine());
                int n = Integer.parseInt(br.readLine());
                bw.write(apartment[k][n-1]+"\n");
            }
            bw.flush();
            bw.close();
        }
        public static void initApartment() {
            prefixSumApartment[0][0] = 1;
            for(int i=0;i<=14;i++) {
                apartment[0][i] = i+1;
                if (i > 0)
                    prefixSumApartment[0][i] = prefixSumApartment[0][i-1]+apartment[0][i];
            }
            
            
            for(int i=1;i<=14;i++) {
                for(int j=0;j<14;j++) {
                    if (j==0){
                        apartment[i][0] = apartment[i-1][0];
                        prefixSumApartment[i][0] = apartment[i][0];
                    }
                    else {
                        apartment[i][j] = prefixSumApartment[i-1][j];
                    }
                    if (j > 0)
                        prefixSumApartment[i][j] = prefixSumApartment[i][j-1]+apartment[i][j];
                }
            }
        }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N[];
    static int map[][][][][][][][][][][];
    static Queue<Pair> q;
    static int totalCnt = 0;
    static int dimension[][];
    static int answer = 0;
        public static void main(String[] args)    throws IOException {
            N = new int[11];
            String[] input = br.readLine().split(" ");
            for(int i=0; i<11; i++) N[i] = Integer.parseInt(input[i]);
            int temp = N[1];
            N[1] = N[0];
            N[0] = temp;
            dimension = new int [11][22];
            for(int i=0;i<11;i++) {
                for(int j=0;j<22;j++) {
                    if (j == (i*2))
                        dimension[i][(i*2)] = 1;
                    else if (j == (i*2)+1)
                        dimension[i][(i*2)+1] = -1;
                    else
                        dimension[i][j] = 0;
                }
            }
            map = new int[N[0]][N[1]][N[2]][N[3]][N[4]][N[5]][N[6]][N[7]][N[8]][N[9]][N[10]];
            q = new LinkedList<Pair>();

            for(int k=0;k<N[10];k++) {
                for(int j = 0; j < N[9];j++) {
                    for(int i = 0; i< N[8];i++) {
                        for(int h=0;h<N[7];h++) {
                            for(int g = 0; g < N[6];g++) {
                                for(int f = 0; f< N[5];f++) {
                                    for(int e=0;e<N[4];e++) {
                                        for(int d = 0; d < N[3];d++) {
                                            for(int c = 0; c < N[2];c++) {
                                                for(int a=0;a<N[0];a++) {
                                                    input = br.readLine().split(" ");
                                                    int[] in = new int[N[1]];
                                                    for(int z=0; z<N[1]; z++) in[z] = Integer.parseInt(input[z]);
                                                    for(int b=0;b<in.length;b++) {
                                                        map[a][b][c][d][e][f][g][h][i][j][k] = in[b];
                                                        if (in[b] == 1)
                                                            q.add(new Pair(a,b,c,d,e,f,g,h,i,j,k));
                                                        else if (in[b] == 0)
                                                            totalCnt++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            while(!q.isEmpty()) {
                int qSize = q.size();
                for(int k=0;k<qSize;k++) {
                    Pair current = q.poll();
                    int cur[] = current.X;
                    int next[] = new int[11];

                    for(int i=0;i<22;i++) {
                        boolean flag = false;
                        for(int j=0;j<11;j++) {
                            next[j] = cur[j]+dimension[j][i];
                            if (next[j] < 0 || next[j] >= N[j]) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag)
                            continue;
                        
                        if(map[next[0]][next[1]][next[2]][next[3]][next[4]][next[5]][next[6]][next[7]][next[8]][next[9]][next[10]] != 0)
                            continue;
                        
                        totalCnt--;
                        map[next[0]][next[1]][next[2]][next[3]][next[4]][next[5]][next[6]][next[7]][next[8]][next[9]][next[10]] = 1;
                        q.add(new Pair(next[0],next[1],next[2],next[3],next[4],next[5],next[6],next[7],next[8],next[9],next[10]));
                    }
                }
                if(!q.isEmpty())
                    answer++;
                else if (totalCnt <= 0)
                    break;
            }
            if (totalCnt == 0)
                bw.write(answer + "\n");
            else
                bw.write("-1\n");

            bw.flush();
            bw.close();
        }
        public static class Pair {
            int X[];
            Pair(int ... n) {
                X = new int[11];
                for(int i=0;i<n.length;i++){
                    X[i] = n[i];
                }
            }
        }
}
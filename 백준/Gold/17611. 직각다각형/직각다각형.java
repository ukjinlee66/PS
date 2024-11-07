import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N,K;
    static int minY, maxY, minX, maxX;
    static Point point[];
    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        point = new Point[N];
        ret = Integer.MIN_VALUE;
        minY = Integer.MAX_VALUE;
        maxY = Integer.MIN_VALUE;
        minX = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;

        for(int i=0;i<N;i++) {
            int In[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            In[0] += 500000; // 음수 제거
            In[1] += 500000;
            point[i] = new Point(In[0], In[1]);
            minY = Math.min(minY, In[1]);
            maxY = Math.max(maxY, In[1]);
            minX = Math.min(minX, In[0]);
            maxX = Math.max(maxX, In[0]);
        }
        int arX[] = new int[1000011];
        int arY[] = new int[1000011];
        for(int i=0;i<N;i++) {
            int next = (i+1) % N;
            int x1,x2,y1,y2;
            x1 = Math.min(point[i].x, point[next].x);
            x2 = Math.max(point[i].x, point[next].x);
            y1 = Math.min(point[i].y, point[next].y);
            y2 = Math.max(point[i].y, point[next].y);
            arX[x1]++;
            arX[x2]--;
            arY[y1]++;
            arY[y2]--;
        }
        ret = Math.max(ret, Math.max(arX[0], arY[0]));
        for(int i=1;i<1000001;i++) {
            arX[i] += arX[i-1];
            arY[i] += arY[i-1];
            ret = Math.max(ret, Math.max(arX[i], arY[i]));
        }
        // for(int x=minX+1;x<=maxX;x++) {
        //     arX[x] += arX[x-1];
        //     ret = Math.max(ret, arX[x]);
        // }
        // for(int y=minY+1;y<=maxY;y++) {
        //     arY[y] += arY[y-1];
        //     ret = Math.max(ret, arY[y]);
        // }
        
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
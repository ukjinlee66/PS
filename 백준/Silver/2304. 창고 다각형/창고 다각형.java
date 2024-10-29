import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // int []arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // long N = Long.parseLong(br.readLine());
        int N = Integer.parseInt(br.readLine());
        Point arr[] = new Point[N];
        int ret = 0;
        int maxY = 0;
        int maxX = 0;
        for(int i=0;i<N;i++){
            int []arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i] = new Point(arr2[0], arr2[1]);
            if (maxY < arr2[1]) {
                maxY = arr2[1];
                maxX = arr2[0];
            }
        }
        Arrays.sort(arr, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x == o2.x) {
                    return o1.y - o2.y;
                } else {
                    return o1.x - o2.x;
                }
            }
        });

        int curH = arr[0].y;
        int curX = arr[0].x;
        if (maxX != arr[0].x && maxX != arr[N-1].x) { // x축의 끝 점이 최대 높이가 아닌 경우 무조건 갸운데 최대 높이까지만 순회
            int start2 = 0;
            for(int i=1;i<N;i++) {
                if (arr[i].x == maxX) {
                    ret += Math.abs(arr[i].x - curX) * curH;
                    start2 = i;
                    break;
                }
                if (curH < arr[i].y) {
                    ret += Math.abs(arr[i].x - curX) * curH;
                    curH = arr[i].y;
                    curX = arr[i].x;
                }
            }
            curH = arr[N-1].y;
            curX = arr[N-1].x;
            for(int i=N-1;i>=start2;i--) {
                if (curH <= arr[i].y) {
                    ret += Math.abs(arr[i].x - curX) * curH;
                    curH = arr[i].y;
                    curX = arr[i].x;
                }
            }
            ret += maxY;
        } else { // 시작 또는 마지막이 최대 높이인 경우
            if (arr[0].x == maxX) { // 시작
                curH = arr[N-1].y;
                curX = arr[N-1].x;
                for(int i=N-1;i>=0;i--) {
                    if (curH <= arr[i].y) {
                        ret += Math.abs(arr[i].x - curX) * curH;
                        curH = arr[i].y;
                        curX = arr[i].x;
                    }
                }
            } else { // 마지막
                for(int i=1;i<N;i++) {
                    if (curH <= arr[i].y) {
                        ret += Math.abs(arr[i].x - curX) * curH;
                        curH = arr[i].y;
                        curX = arr[i].x;
                    }
                }
            }
            ret += maxY;
        }
        if (ret == 0) {
            ret = Math.abs(arr[N-1].x - arr[0].x + 1) * arr[N-1].y;
        }
        bw.write(ret + "\n");
        bw.flush();
    }

    public static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
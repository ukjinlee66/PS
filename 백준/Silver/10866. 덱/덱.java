import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Deque<Integer> deque = new ArrayDeque();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            String[] commands = br.readLine().split(" ");
            String command = commands[0];
            switch(command) {
                case "push_front" :
                    deque.addFirst(Integer.parseInt(commands[1]));
                    break;
                case "push_back" :
                    deque.addLast(Integer.parseInt(commands[1]));
                break;
                case "pop_front" :
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.pollFirst()+"\n");
                break;
                case "pop_back" :
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.pollLast()+"\n");
                break;
                case "front" :
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.getFirst()+"\n");
                break;
                case "back" :
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.getLast()+"\n");
                break;
                case "size" :
                    bw.write(deque.size()+"\n");
                break;
                case "empty" :
                    bw.write(deque.isEmpty() == true ? "1\n" : "0\n");
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}
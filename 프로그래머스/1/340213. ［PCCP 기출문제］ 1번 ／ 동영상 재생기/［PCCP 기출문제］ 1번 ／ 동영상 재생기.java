import java.time.*;
class Solution {
    static LocalTime cur;
    static LocalTime video;
    static LocalTime opStart;
    static LocalTime opEnd;
    
    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        cur = LocalTime.of(00,Integer.parseInt(pos.substring(0,2)), Integer.parseInt(pos.substring(3,5)));
        video = LocalTime.of(00,Integer.parseInt(video_len.substring(0,2)),Integer.parseInt(video_len.substring(3,5)));
        opStart = LocalTime.of(00,Integer.parseInt(op_start.substring(0,2)),Integer.parseInt(op_start.substring(3,5)));
        opEnd = LocalTime.of(00,Integer.parseInt(op_end.substring(0,2)),Integer.parseInt(op_end.substring(3,5)));
        for(int i=0;i<commands.length;i++) {
            System.out.println(cur);
            if (cur.compareTo(opStart)>=0 && cur.compareTo(opEnd)<=0)
                cur = opEnd;
            if (commands[i].equals("prev")) {
                if (cur.compareTo(LocalTime.of(00,00,10))<=0) {
                    cur = LocalTime.of(00,00,00);
                } else {
                    cur = cur.minusSeconds(10);
                }
            } else {
                if (cur.plusSeconds(10).compareTo(video)<=0) {
                    cur = cur.plusSeconds(10);
                }
                else {
                    cur = video;
                }
                
            }
            if (cur.compareTo(opStart)>=0 && cur.compareTo(opEnd)<=0)
                cur = opEnd;
        }
        
        return returnTime();
    }
    
    private static String returnTime() {
        int currentMin = cur.getMinute();
        int currentSec = cur.getSecond();
        StringBuilder sb = new StringBuilder();
        if (currentMin == 0) {
            sb.append("00");
        } else if (currentMin < 10) {
            sb.append("0");
            sb.append(String.valueOf(currentMin));
        } else {
            sb.append(String.valueOf(currentMin));
        }
        sb.append(":");
        if (currentSec == 0) {
            sb.append("00");
        } else if (currentSec < 10) {
            sb.append("0");
            sb.append(String.valueOf(currentSec));
        } else {
            sb.append(String.valueOf(currentSec));
        }
        return sb.toString();
    }
}
import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> h = new HashMap<>();
        for(int i=0;i<keymap.length;i++) {
            for(int j=0;j<keymap[i].length();j++) {
                char curStr = keymap[i].charAt(j);
                if (!h.containsKey(curStr)) {
                    h.put(curStr, j+1);
                } else {
                    int cnt = h.get(curStr);
                    if (cnt > j+1)
                        h.replace(curStr,j+1);
                }
            }
        }
        for(int i=0;i<targets.length;i++) {
            for(int j=0;j<targets[i].length();j++){
                if (!h.containsKey(targets[i].charAt(j))) {
                    answer[i] = -1;
                    break;
                }
                answer[i]+=h.get(targets[i].charAt(j));
            }
        }
        return answer;
    }
}
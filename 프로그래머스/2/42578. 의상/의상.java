import java.util.*;
class Solution {
    static int answer;
    static Map<String, Integer> map;
    public int solution(String[][] clothes) {
        answer = 1;
        map = new HashMap<>();
        
        for(int i=0;i<clothes.length;i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0) + 1);
        }
        for(String k : map.keySet()) {
            answer *= (map.get(k) + 1);
        }
        return answer-1;
    }
}
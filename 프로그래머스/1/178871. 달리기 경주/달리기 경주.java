import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String [] answer = new String[players.length];
        HashMap<String,Integer> name = new HashMap<>();
        HashMap<Integer,String> rank = new HashMap<>();
        for(int i=0;i<players.length;i++) {
            name.put(players[i],i);
            rank.put(i,players[i]);
        }
        for(int i=0;i<callings.length;i++){
            int num = name.get(callings[i]);
            String name2 = rank.get(num-1);
            name.replace(callings[i],num-1);
            name.replace(name2,num);
            rank.replace(num-1,callings[i]);
            rank.replace(num,name2);
        }
        int index = 0;
        for(int key : rank.keySet()) {
            answer[key] = rank.get(key);
        }
        return answer;
    }
}
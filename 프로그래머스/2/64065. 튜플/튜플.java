import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        Set<Integer> ans = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        s = s.replace("{","");
        s = s.replace("}","");
        String[] str = s.split(",");
        for(int i=0;i<str.length;i++) {
            if(1 <= Integer.parseInt(str[i]) && Integer.parseInt(str[i]) <= 100001){
                int num = Integer.parseInt(str[i]);
                if (map.containsKey(num)) {
                    map.replace(num, map.get(num)+1);
                } else {
                    map.put(num, 1);
                }
            }
        }
        List<Integer> keyset = new ArrayList<>(map.keySet());
        
        keyset.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        int[] answer = new int[keyset.size()];
        int idx = 0;
        for(Integer num : keyset) {
            answer[idx++]=num;
        }
        return answer;
    }
}
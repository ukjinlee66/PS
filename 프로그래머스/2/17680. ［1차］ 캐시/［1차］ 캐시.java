import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0)
            return cities.length*5;
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();
        int start = 0;
        for(int i=0;i<cities.length;i++) {
            if (list.size() == cacheSize) {
                start = i;
                break;
            }
            if(list.contains(cities[i].toUpperCase())) {
                list=swap(list.indexOf(cities[i].toUpperCase()), list);
                answer+=1;
            } else {
                list.addFirst(cities[i].toUpperCase());
                answer+=5;
            }
        }
        for(int i=start;i<cities.length;i++) {
            if(list.contains(cities[i].toUpperCase())) { // cache hit
                swap(list.indexOf(cities[i].toUpperCase()), list);
                answer+=1;
            } else { // cache miss
                list.addFirst(cities[i].toUpperCase());
                list.removeLast();
                answer+=5;
            }
        }
        
        return answer;
    }
    
    public LinkedList<String> swap(int d1, LinkedList<String> list) {
        if (d1 <= 1)  return list;
        String temp = list.get(list.indexOf(list.get(d1)));
        list.remove(list.indexOf(temp));
        list.addFirst(temp);
        return list;
    }
}
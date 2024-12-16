import java.util.*;
class Solution {
    static HashMap<String, Integer> friend;
    static int graph[][];
    static String In[];
    static ArrayList<fri> gift;
    static int ar[];
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        friend = new HashMap<>();
        gift = new ArrayList<>();
        graph = new int[friends.length][friends.length];
        ar = new int[friends.length];
        for(int i=0;i<friends.length;i++) {
            friend.put(friends[i],i);
            gift.add(new fri());
        }
        for(int i=0;i<gifts.length;i++) {
            In = gifts[i].split(" ");
            
            int f1 = friend.get(In[0]);
            int f2 = friend.get(In[1]);
            
            graph[f1][f2]++;
            gift.get(f1).send++;
            gift.get(f2).recive++;
        }
        for(int i=0;i<friends.length;i++) {
            for(int j=i+1;j<friends.length;j++) {
                int f1 = i;
                int f2 = j;
                if (graph[f1][f2] > graph[f2][f1]) {
                    ar[f1]++;
                }
                else if (graph[f1][f2] == graph[f2][f1]) {
                    int rate1 = gift.get(f1).getRate();
                    int rate2 = gift.get(f2).getRate();
                    if (rate1 > rate2) {
                        ar[f1]++;
                    } else if (rate1 < rate2) {
                        ar[f2]++;
                    }
                } else {
                    ar[f2]++;
                }
            }
        }
        for(int i=0;i<friends.length;i++) {
            answer = Math.max(answer, ar[i]);
        }
        
        return answer;
    }
    
    public static class fri {
        int send;
        int recive;
        public fri() {
            this.send = 0;
            this.recive = 0;
        }
        public int getRate() {
            return this.send-this.recive;
        }
    }
}
import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = new int[data.length][4];
        ArrayList<int[]> ar = new ArrayList<>();
        
        for(int i=0;i<data.length;i++) {
            if (data[i][sortNumber(ext)] <= val_ext)
            {
                int[] temp = new int[4];
                for(int j=0;j<4;j++) {
                    temp[j] = data[i][j];
                }
                ar.add(temp);
            }
        }
        Collections.sort(ar, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[sortNumber(sort_by)] - o2[sortNumber(sort_by)];
            }
        });
        answer = new int[ar.size()][4];
        int index=0;
        for(int[] o : ar) {
            for(int i=0;i<4;i++) {
                answer[index][i] = o[i];
            }
            index++;
        }
        return answer;
    }
    
    public int sortNumber(String sort_by) {
        switch(sort_by) {
            case "code" : 
                return 0;
            case "date" :
                return 1;
            case "maximum" :
                return 2;
            case "remain" :
                return 3;
            default :
                return -1;
        }
    }
}
import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=citations.length;i>=0;i--) {
            int min = 0;
            int max = 0;
            for(int j=0;j<citations.length;j++) {
                if (citations[j] >= i)
                {
                    max = citations.length-j;
                    break;
                }
                else
                    min++;
                    
            }
            if (min <= i && max>=i)
                return i;
        }
        return answer;
    }
}
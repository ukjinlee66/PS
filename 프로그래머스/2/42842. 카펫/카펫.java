class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=3;i<=brown;i++) {
            for(int j=3;j<=brown;j++) {
                if (i*j == brown+yellow && (i*2 + (j-2)*2) == brown &&
                   (i-2)*(j-2) == yellow)
                {
                    answer[0] = i <= j ? j : i;
                    answer[1] = i <= j ? i : j;
                    return answer;
                }
            }
        }
        return answer;
    }
}
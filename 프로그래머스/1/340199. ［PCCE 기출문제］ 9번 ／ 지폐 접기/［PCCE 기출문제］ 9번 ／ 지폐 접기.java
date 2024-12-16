class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int N = wallet[0];
        int M = wallet[1];
        int b1 = bill[0];
        int b2 = bill[1];
        
        while ((b1 > N || b2 > M) || (b1 > M || b2 > N)) {
            if((b1<=N && b2<=M) || (b1<=M && b2<=N))
                break;
            if (b1 > b2){
                b1/=2;
                answer++;
            }
            else{
                b2/=2;
                answer++;
            }
        }
        return answer;
    }
}
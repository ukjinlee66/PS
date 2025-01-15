class Solution {
    public int[] solution(int[] sequence, int k) {
        int preIndex = 0;
    int proIndex = 0;
    long sum = 0L;
    int minLength = Integer.MAX_VALUE;
    int[] answer = {-1, -1};

    while (true) {
        if (sum >= k) {
            if (sum == k && proIndex - preIndex < minLength) {
                minLength = proIndex - preIndex;
                answer[0] = preIndex;
                answer[1] = proIndex - 1;
            }
            sum -= sequence[preIndex++];
        } else {
            if (proIndex == sequence.length) break;
            sum += sequence[proIndex++];
        }
    }

    return answer;
    }
}
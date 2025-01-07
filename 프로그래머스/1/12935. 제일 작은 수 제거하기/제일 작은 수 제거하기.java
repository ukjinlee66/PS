class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        if (arr.length>1){
             answer = new int[arr.length-1];
            int minnum = 2147483647;
            int minidx = 0;
            for(int i=0;i<arr.length;i++)
            {
                if (minnum > arr[i]) {
                    minnum = arr[i];
                    minidx = i;
                }
            }
            int idx=0;
            for(int i=0;i<arr.length;i++) {
                if(i==minidx) continue;
                answer[idx++] = arr[i];
            }
        }
        else
            answer = new int[]{-1};
        return answer;
    }
}
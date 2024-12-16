class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        for(int i=0;i<park.length;i++) {
            for(int j=0;j<park[i].length;j++) {
                if(park[i][j].equals("-1")) {
                for(int k=0;k<mats.length;k++) {
                    if (i+mats[k]-1 < park.length &&
                       j+mats[k]-1 < park[i].length) {
                        boolean flag = false;
                        for(int ii = i;ii<i+mats[k];ii++) {
                            for(int jj=j;jj<j+mats[k];jj++) {
                                if (!park[ii][jj].equals("-1")) {
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag)
                                break;
                        }
                        if (!flag)
                            answer = Math.max(answer, mats[k]);
                    }
                }
            }
            }
        }
        return answer;
    }
}
class Solution {
    static int ans = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        sol(0,picks,minerals,0);
        return ans;
    }
    public void sol(int val, int[] pick, String[] mineral, int idx) {
        if ((pick[0] == 0 && pick[1] == 0 && pick[2] == 0) || idx >= mineral.length)
        {
            ans = Math.min(ans,val);
            return;
        }
        int end = idx+5 >= mineral.length ? mineral.length : idx+5;
        for(int i=0;i<pick.length;i++) {
            if(pick[i] > 0) {
                pick[i]--;
                if (i == 0) { // dia
                    sol(val+end-idx, pick, mineral, end);
                } else if (i== 1) { // iron
                    int num = 0;
                    for(int j=idx;j<end;j++)
                    {
                        num += cal("iron",mineral[j]);
                    }
                    sol(val+num,pick,mineral,end);
                } else { // stone
                    int num = 0;
                    for(int j=idx;j<end;j++)
                    {
                        num += cal("stone",mineral[j]);
                    }
                    sol(val+num,pick,mineral,end);
                }
                pick[i]++;
            }
        }
    }
    
    public int cal(String pick, String mineral) {
        if (pick.equals("iron")) {
            switch (mineral) {
                case "diamond" : return 5;
                default : return 1;
            }
        } else { // stone
            switch (mineral) {
                case "diamond" : return 25;
                case "iron" : return 5;
                default : return 1;
            }
        }
    }
}
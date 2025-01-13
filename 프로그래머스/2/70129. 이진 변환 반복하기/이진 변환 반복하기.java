class Solution {
    static int cnt = 0;
    static int zero = 0;
    public int[] solution(String s) {
        while(!s.equals("1")) {
            s = sol(s);
        }
        int[] answer = {cnt, zero};
        return answer;
    }
    
    public String sol(String st) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = st.split("");
        for(String s : strArr) {
            if (s.equals("1"))
                sb.append(s);
        }
        zero+=strArr.length-sb.length();
        cnt++;
        return Integer.toString(sb.length(), 2);
    }
}
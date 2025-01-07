class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++) {
            if((i==0 || String.valueOf(s.charAt(i-1)).equals(" ")) &&
              '9' < s.charAt(i)) {
                sb.append(String.valueOf(Character.toUpperCase(s.charAt(i))));
            } else 
                sb.append(String.valueOf(Character.toLowerCase(s.charAt(i))));
        }
        
        return sb.toString();
    }
}
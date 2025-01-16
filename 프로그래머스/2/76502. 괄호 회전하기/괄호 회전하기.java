import java.util.*;
class Solution {
    static int ans = 0;
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (check(sb))
            ans++;
        for(int i=0;i<s.length()-1;i++) {
            sb = change(sb);
            if (check(sb))
                ans++;
        }
        return ans;
    }
    public StringBuilder change(StringBuilder sb) {
        String temp = String.valueOf(sb.charAt(0));
        sb.deleteCharAt(0);
        sb.append(temp);
        return sb;
    }
    
    public boolean check(StringBuilder s) {
        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            String str = String.valueOf(s.charAt(i));
            switch(str) {
                case "[" : stack.push(str);
                    break;
                case "]" : if(stack.isEmpty() || !stack.peek().equals("[")) return false;
                    stack.pop();
                    break;
                case "{" : stack.push(str);
                    break;
                case "}" : if(stack.isEmpty() || !stack.peek().equals("{")) return false;
                    stack.pop();
                    break;
                case "(" : stack.push(str);
                    break;
                case ")" : if(stack.isEmpty() || !stack.peek().equals("(")) return false;
                    stack.pop();
                    break;
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
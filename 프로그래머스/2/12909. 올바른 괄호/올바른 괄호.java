import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if (String.valueOf(s.charAt(i)).equals("("))
                stack.push(String.valueOf(s.charAt(i)));
            else {
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty() ? true : false;
    }
}
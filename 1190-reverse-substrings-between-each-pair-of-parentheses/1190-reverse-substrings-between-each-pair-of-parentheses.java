class Solution {
public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') 
            {
                stack.push(current.toString());
                current = new StringBuilder();
            } 
            else if (ch == ')') 
            {
                current.reverse();
                current = new StringBuilder(stack.pop()).append(current);
            } 
            else 
            {
                current.append(ch);
            }
        }
        
        return current.toString();
    }
}
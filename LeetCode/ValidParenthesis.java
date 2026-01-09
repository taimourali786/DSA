import java.util.ArrayDeque;

public class ValidParenthesis{

    public boolean isValid(String s) {
        ArrayDeque<Character> memory = new ArrayDeque();
        for(char currentChar: s.toCharArray()) {
            if(currentChar == '(' || currentChar == '{' || currentChar == '[') {
                memory.push(currentChar);
            }
            else {
                if(memory.isEmpty()) {
                    return false;
                }
                char lastPushed = memory.pop();
                if(currentChar == ')' && lastPushed == '(') {
                    continue;
                }
                else if(currentChar == '}' && lastPushed == '{') {
                    continue;
                }
                else if(currentChar == ']' && lastPushed == '[') {
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        return memory.isEmpty();
    }
}
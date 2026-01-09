package Techniques;

import java.util.*;

public class DynamicProgramming {

    private Map<Integer, Integer> memory = new HashMap();

    public Integer fibonacchiSequence(int term) {
        if(term <= 1) {
            return term;
        }
        if(memory.containsKey(term)) {
            return memory.get(term);
        }

        Integer value =  fibonacchiSequence(term - 1) + fibonacchiSequence(term - 2);
        memory.put(term, value);
        return value;
    }
    
}

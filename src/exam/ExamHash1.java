package exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class ExamHash1 implements Exam {
    
    public int run(int M, int Q, Integer[] input) {
        System.out.println("===== M:" + M + " =====");
        long startTime = System.nanoTime(); //DEBUG
        
        Integer[] inputSubtracted = input.clone();
        for(int i = 0; i < input.length; i++)
            inputSubtracted[i] = inputSubtracted[i] - Q;
        
        System.out.println("time elapsed substract: " + ((double)(System.nanoTime() - startTime)) / (1000 * 1000 * 1000));
        startTime = System.nanoTime(); //DEBUG
        
        HashMap<Integer, Integer> inputSubtractedMap =
                new HashMap<Integer, Integer>();
            
            for(int i=0; i < inputSubtracted.length; i++) {
                inputSubtractedMap.put(inputSubtracted[i], i);
            }
        
//        System.out.println("DEBUG: Matached pairs:");
        int count = 0;
        for(int idxPairFirst = 0 ; idxPairFirst < M ; idxPairFirst++) {
            if(input[idxPairFirst] == null)
                continue;
            Integer subtractIndex = inputSubtractedMap.get(input[idxPairFirst]);
            if(subtractIndex != null) {
                count++;
                input[subtractIndex] = null;
            }
        }
        System.out.println("time elapsed compare: " + ((double)(System.nanoTime() - startTime)) / (1000 * 1000 * 1000));
        return count;
    }
}

package exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class ExamHash2 implements Exam {
    
    public int run(int M, int Q, Integer[] input, boolean debug) {
        System.out.println("===== M:" + M + " =====");
        long startTime = System.nanoTime(); //DEBUG
        
        // sort
        long startTimeSort = System.nanoTime(); //DEBUG
        Arrays.sort(input, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer x, Integer y)
            {
                return x - y;
            }
        });
        System.out.println("time elapsed sort: " + ((double)(System.nanoTime() - startTimeSort)) / (1000 * 1000 * 1000));
        
        
        HashMap<Integer, Integer> inputMap =
                new HashMap<Integer, Integer>();
            
        for(int i=0; i < input.length; i++) {
            inputMap.put(input[i], i);
        }
        
        // compare
        long startTimeCompare = System.nanoTime(); //DEBUG
//        System.out.println("DEBUG: Matached pairs:");
        int count = 0;
        for(int idxPairFirst = 0 ; idxPairFirst < M ; idxPairFirst++) {
            if(input[idxPairFirst] == null)
                continue;
            Integer idxPairSecond = inputMap.get(input[idxPairFirst] - Q);
            if(idxPairSecond != null) {
                count++;
                if(debug)
                    System.out.println("DEBUG: (" + input[idxPairFirst] + "," + input[idxPairSecond] + ")");
                inputMap.remove(input[idxPairFirst]);
                inputMap.remove(input[idxPairFirst] - Q);
                input[idxPairSecond] = null;
            }
        }
        System.out.println("time elapsed compare: " + ((double)(System.nanoTime() - startTimeCompare)) / (1000 * 1000 * 1000));
        System.out.println("time elapsed TOTAL: " + ((double)(System.nanoTime() - startTime)) / (1000 * 1000 * 1000));
        return count;
    }
}

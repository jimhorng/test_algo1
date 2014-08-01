package exam;

import java.util.Arrays;
import java.util.Comparator;

public class ExamSortFullCompare1 implements Exam {
    
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
        
        long startTimeSubtract = System.nanoTime(); //DEBUG
//        System.out.println("DEBUG: sorted:" + Arrays.toString(input));
        
        Integer[] inputSubtracted = input.clone();
        for(int i = 0; i < input.length; i++)
            inputSubtracted[i] = inputSubtracted[i] - Q;
        
        System.out.println("time elapsed substract: " + ((double)(System.nanoTime() - startTimeSubtract)) / (1000 * 1000 * 1000));
        long startTimeCompare = System.nanoTime(); //DEBUG
        
//        System.out.println("DEBUG: Matached pairs:");
        int count = 0;
        for(int idxPairFirst = 0 ; idxPairFirst < M ; idxPairFirst++) {
            if(input[idxPairFirst] == null)
                continue;
            for(int idxPairSecond = 1 ; idxPairSecond < M ; idxPairSecond++) {
                if(input[idxPairSecond] == null || idxPairFirst == idxPairSecond)
                    continue;
                if(input[idxPairFirst].equals(inputSubtracted[idxPairSecond])) {
                    count++;
                    if(debug)
                        System.out.println("DEBUG: (" + input[idxPairFirst] + "," + input[idxPairSecond] + ")");
                    input[idxPairFirst] = null;
                    input[idxPairSecond] = null;
                    break;
                }
            }
        }
        System.out.println("time elapsed compare: " + ((double)(System.nanoTime() - startTimeCompare)) / (1000 * 1000 * 1000));
        System.out.println("time elapsed TOTAL: " + ((double)(System.nanoTime() - startTime)) / (1000 * 1000 * 1000));
        return count;
    }
}

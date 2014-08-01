package exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class ExamSort2 implements Exam {
    
    public int run(int M, int Q, Integer[] input) {
        System.out.println("===== M:" + M + " =====");
        long startTime = System.nanoTime(); //DEBUG
        Arrays.sort(input, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer x, Integer y)
            {
                return x - y;
            }
        });
        System.out.println("time elapsed sort: " + ((double)(System.nanoTime() - startTime)) / (1000 * 1000 * 1000));
        startTime = System.nanoTime(); //DEBUG
//        System.out.println("DEBUG: sorted:" + Arrays.toString(input));
        
        LinkedList<Integer> inputList =
            new LinkedList<Integer>(Arrays.asList(input));
        
        Integer[] inputSubtracted = input.clone();
        for(int i = 0; i < input.length; i++)
            inputSubtracted[i] = inputSubtracted[i] - Q;
        
        System.out.println("time elapsed substract: " + ((double)(System.nanoTime() - startTime)) / (1000 * 1000 * 1000));
        startTime = System.nanoTime(); //DEBUG
        
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
//                    System.out.println("DEBUG: (" + input[idxPairFirst] + "," + input[idxPairSecond] + ")");
                    input[idxPairFirst] = null;
                    input[idxPairSecond] = null;
                    break;
                }
            }
        }
        System.out.println("time elapsed compare: " + ((double)(System.nanoTime() - startTime)) / (1000 * 1000 * 1000));
        return count;
    }
}

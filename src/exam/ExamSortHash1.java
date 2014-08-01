package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class ExamSortHash1 implements Exam {
    
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
        
        
        HashMap<Integer, ArrayList<Integer>> inputMap =
                new HashMap<Integer, ArrayList<Integer>>();
            
        for(int i=0; i < input.length; i++) {
            if(inputMap.containsKey(input[i])) {
                ArrayList<Integer> indexes = inputMap.get(input[i]);
                indexes.add(i);
            }
            else
                inputMap.put(input[i], new ArrayList<Integer>(Arrays.asList(i)));
        }
        
        // compare
        long startTimeCompare = System.nanoTime(); //DEBUG
//        System.out.println("DEBUG: Matached pairs:");
        int count = 0;
        for(int idxPairFirst = 0 ; idxPairFirst < M ; idxPairFirst++) {
            if(input[idxPairFirst] == null)
                continue;
            ArrayList<Integer> indexesPairSecond = inputMap.get(input[idxPairFirst] + Q);
            if(indexesPairSecond != null) {
                count++;
                Integer idxPairSecond = indexesPairSecond.remove(0);
                if(debug)
                    System.out.println("DEBUG: (" + input[idxPairFirst] + "," + input[idxPairSecond] + ")");
                inputMap.get(input[idxPairFirst]).remove((Integer)idxPairFirst);
                if(inputMap.get(input[idxPairFirst]).isEmpty())
                    inputMap.remove(input[idxPairFirst]);
                if(indexesPairSecond.isEmpty())
                    inputMap.remove(input[idxPairFirst] + Q);
                input[idxPairFirst] = null;
                input[idxPairSecond] = null;
            }
        }
        System.out.println("time elapsed compare: " + ((double)(System.nanoTime() - startTimeCompare)) / (1000 * 1000 * 1000));
        System.out.println("time elapsed TOTAL: " + ((double)(System.nanoTime() - startTime)) / (1000 * 1000 * 1000));
        return count;
    }
}

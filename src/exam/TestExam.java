package exam;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestExam {
    
    Exam exam = new ExamHash1(); // switch object-under-test
    
    @Test
    public void test_8() {
        int M = 8;
        int Q = 3;
        Integer[] input = new Integer[]{1, 3, 6, 8, 9, 20, 23, 4};
        assertEquals(3, this.exam.run(M, Q, input));
    }
    
    @Test
    public void test_20() {
        int M = 20;
        int Q = 4;
        Integer[] input = new Integer[]{1, 3, 6, 8, 9, 20, 23, 4, 100, 104,
                                        5, 13, 24, 99, 3452, 0, 56, 454, 3241, -334};
        assertEquals(5, this.exam.run(M, Q, input));
    }
    
    @Test
    public void test_repeated() {
        int M = 10;
        int Q = 3;
        Integer[] input = new Integer[]{1, 3, 3, 6, 6, 20, 23, 4, 100, 104};
        assertEquals(4, this.exam.run(M, Q, input));
    }
    
    @Test
    public void test_100000() {
        int M = 100000;
        int Q = 3;
        Integer[] input = generateLargeIntArray(M);
        assertEquals(3, this.exam.run(M, Q, input));
    }
    
    private Integer[] generateLargeIntArray(int size) {
        List<Integer> largeArray = new ArrayList<Integer>();
        for(int i=0; i< size * 2; i++) {
            largeArray.add(i);
        }
        Collections.shuffle(largeArray);
        Integer[] newLargeArray = new Integer[size];
        for(int i=0; i< size; i++) {
            newLargeArray[i] = largeArray.get(i);
        }
        return newLargeArray;
    }
}

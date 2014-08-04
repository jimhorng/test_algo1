package exam;

import java.util.Scanner;

public class Main {
    
    // switch object-under-test
//  static Exam exam = new ExamSortFullCompare1();
//  static Exam exam = new ExamHash1();
    static Exam exam = new ExamSortHash1();
    private static boolean DEBUG = false;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstLine = scan.nextLine();
        String secondLine = scan.nextLine();
        
        System.out.println("first line: " + firstLine);
        System.out.println("second line: " + secondLine);
        
        String[] tmp = firstLine.split("\\s+");
        int M = Integer.parseInt(tmp[0]);
        int Q = Integer.parseInt(tmp[1]);
        
        Integer[] input = new Integer[M];
        String[] tmp2 = secondLine.split("\\s+");
        for(int i=0; i < M; i++)
            input[i] = Integer.valueOf(tmp2[i]);
        
        System.out.println("count: " + exam.run(M, Q, input, DEBUG));
    }
}

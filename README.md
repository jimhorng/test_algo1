Name: Jim Horng
Email: jimhorng@gmail.com

# Algorithm #
Given M distinct integers, they will be stored in an array named array_origin.
all integers in array_origin will be subtracted by Q and store in array_substracted.

The computation(subtraction) cost is O(n) in any cases.

Each integer in array_origin will be compare to each integer in array_substracted, except for integer with the same index.
If the values equals, meaning that the difference between the two integer of pair which composed by integer of array_origin index and integer of array_subtracted index, equals to Q.
Then, the value of both index in array_origin will be marked as null to make next iteration to skip these two integer, in order to satisfy the condition of distinct pair.
The cost here are integer comparisons: 
* O(n^2) on worse case, where there's no pair difference that matches Q.
* O(n) on best case, where every pair difference matches Q and are composed by integer and its next integer.
        e.g. Q=3, integer series: 0 3 6 9 12 15...etc.

# Run the Code #
* for console: run live365_exam.Exam.main()
* for unit test: run live365_exam.TestExam.java as unit test
    - include lib/*.jar as CLASSPATH
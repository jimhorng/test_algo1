Name: Jim Horng
Email: jimhorng@gmail.com

# Additional Requirements #
* Series integers of M might contains repeated values


# Algorithm #
Logic at exam.ExamSortHash1.java  
1.  Sort given M integers stored in an array(named array_origin)  
    (to get maximum distinct pairs)
    * cost: timsort, O(nlog(n))
2.  Convert array_origin to hashmap(named hashmap_inverted)  , key as integer, value as list of indexes of that integer in array_origin  
    (e.g. 4 4 1 becomes {4:[0,1], 1:[2]})
3.  Iterate all integers in array_origin, find if the value of integer + Q exists as key in hashmap_inverted, 
    * if exists, get index back and remove index, if key-value's index is empty, remove all key
    * if not, skip to next integer


# Performance #
* 0.4s for M=100000 on my local machine
(subtract and compare version cost 18s)


# Run the Code #
* for console: run exam.Main.java
* for unit test: run exam.TestExam.java as unit test
    - include lib/*.jar as CLASSPATH
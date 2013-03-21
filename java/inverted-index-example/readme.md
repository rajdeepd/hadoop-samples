#MapReduce Sample
This sample uses the MapReduce API to find the Median temperature from an Input file

## Sample Input File
	
	T[0]=This is the sample app for Inverted Index Problem
	T[1]=We will solve it using a Simple Map Reduce Program
	T[2]=This program is written in Java
	

## Copy Input File into HDFS
	
	bin/hadoop fs -copyFromLocal ../hadoop-samples/myinput/sample-inverted.txt /user/vmware/myinput/sample-inverted.txt

## Execute the MapReduce Job
	
	bin/hadoop jar ../hadoop-samples/java/inverted-index-example/target/inverted-index-example-1.0.jar \
          com.hadoop.example.InvertedIndexJob  /user/vmware/myinput/sample-inverted.txt  /user/vmware/output/inverted

## Copy Output to Local File System  

	bin/hadoop fs -copyToLocal /user/vmware/output/inverted output/inverted
	
	
## Output from the MapReduce Task
   
   	$ cat output/inverted/part-r-00000 
	Index	T[0]
	Inverted	T[0]
	Java	T[2]
	Map	T[1]
	Problem	T[0]
	Program	T[1]
	Reduce	T[1]
	Simple	T[1]
	This	T[0] T[2]	
	We	T[1]
	a	T[1]
	app	T[0]
	for	T[0]
	in	T[2]
	is	T[2] T[0]
	it	T[1]
	program	T[2]
	sample	T[0]
	solve	T[1]
	the	T[0]
	using	T[1]
	will	T[1]
	written	T[2]

   
  

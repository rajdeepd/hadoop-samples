#MapReduce Sample
This sample uses the MapReduce API to find the Median temperature from an Input file

## Sample Input File
	
	1990;21
	1990;20
	1990;24
	1991;23
	1991;24
	1991;26
	1991;27	

## Copy Input File into HDFS
	
	bin/hadoop fs -copyFromLocal ../hadoop-samples/myinput/sample2.txt /user/vmware/myinput/sample2.txt

## Execute the MapReduce Job
	
	bin/hadoop jar ../hadoop-samples/hadoop-median-example/target/hadoop-median-example-1.0.jar \
  		com.hadoop.example.hadoop.MedianTemperature  /user/vmware/myinput/sample2.txt  /user/vmware/output-median 
  
## Copy Output to Local File System  

	bin/hadoop fs -copyToLocal /user/vmware/output-median output-median
	
	
## Output from the MapReduce Task
   
   $ cat output/median/part-r-00000 
     1990	21
     1991	24
   
  
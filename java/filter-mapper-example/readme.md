#MapReduce Sample
This sample uses the MapReduce API to Filter Customer comment with rating "1"

##Input File
	
	myinput/sample-filter.txt

## Copy Input File into HDFS
	
	bin/hadoop fs -copyFromLocal ../hadoop-samples/myinput/sample-filter.txt /user/vmware/myinput/sample-filter.txt

## Execute the MapReduce Job
	
	bin/hadoop jar ../hadoop-samples/filter-mapper-example/target/filter-mapper-example-1.0.jar \
  		com.hadoop.example.FilterJob  /user/vmware/myinput/sample-filter.txt  /user/vmware/output/filter 
  
## Copy Output to Local File System  

	bin/hadoop fs -copyToLocal /user/vmware/output/filter output/filter
	
	
## Output from the MapReduce Task
   
        $ cat output/max/part-r-00000 
        1990	24
        1991	27
   
   
  

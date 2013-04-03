#MapReduce Sample
This sample uses the MapReduce API to find the Max temperature from an Input file

##Input File
	
	1990;21
	1990;20
	1990;24
	1991;23
	1991;24
	1991;26
	1991;27	

## Copy Input File into HDFS
	
	bin/hadoop fs -copyFromLocal ../hadoop-samples/myinput/sample-max.txt /user/vmware/myinput/sample-max.txt

## Execute the MapReduce Job
	
	bin/hadoop jar ../hadoop-samples/java/hadoop-max-example/target/hadoop-max-example-1.0.jar \
  		com.hadoop.example.MaxTemperature  /user/vmware/myinput/sample-max.txt  /user/vmware/output/max 
  
## Copy Output to Local File System  

	bin/hadoop fs -copyToLocal /user/vmware/output/max output/max
	
	
## Output from the MapReduce Task
   
        $ cat output/max/part-r-00000 
        1990	24
        1991	27
   
   
  

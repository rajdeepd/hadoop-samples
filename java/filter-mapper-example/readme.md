#MapReduce Sample
This sample uses the MapReduce API to Filter Customer comment with rating "1"

##Input File
myinput/sample-filter.txt

        10/11/2012,r..@yahoo.com,3,I was really satisfied with the customer service at the store
	09/12/2012,x..@yahoo.com,3,Basic needs met at the store
	10/11/2012,r.@gmail.com,4,Excellent
	09/12/2012,x..@hotmail.com,5,Great Collection
	01/02/2013,dan...@xyz.com,1,Horrible service at the store
	09/12/2012,zz..@hotmail.com,5,Great Collection
	01/02/2013,d...@gmail.com,4,Good collection and service at the store

## Copy Input File into HDFS
	
	bin/hadoop fs -copyFromLocal ../hadoop-samples/myinput/sample-filter.txt /user/vmware/myinput/sample-filter.txt

## Execute the MapReduce Job
	
	bin/hadoop jar ../hadoop-samples/java/filter-mapper-example/target/filter-mapper-example-1.0-SNAPSHOT.jar \
  		com.hadoop.example.FilterJob  /user/vmware/myinput/sample-filter.txt  /user/vmware/output/filter 
  
## Copy Output to Local File System  

	bin/hadoop fs -copyToLocal /user/vmware/output/filter output/filter
	
	
## Output from the MapReduce Task
   
        $ cat output/filter/part-r-00000 
        Horrible service at the store
        
   
  

#MapReduce Sample
This sample uses the MapReduce API to Filter Customer with negative comments using a Bloom Filter

##Input File
myinput/sample-bloomfilter.txt

        10/11/2012,r..@yahoo.com,3,I was really satisfied with the customer service at the store
	09/12/2012,x..@yahoo.com,3,Basic needs met at the store
	10/11/2012,r.@gmail.com,4,Excellent
	09/12/2012,x..@hotmail.com,5,Great Collection
	01/02/2013,dan...@xyz.com,1,bad service
	09/12/2012,zz..@hotmail.com,5,Great Collection
	01/02/2013,d...@gmail.com,4,Good collection and service at the store

## Copy Input File into HDFS
	
	bin/hadoop fs -copyFromLocal ../hadoop-samples/myinput/sample-bloomfilter.txt /user/vmware/myinput/sample-bloomfilter.txt

## Execute the MapReduce Job
	
	bin/hadoop jar ../hadoop-samples/java/bloom-filter-example/target/bloom-filter-example-1.0-SNAPSHOT.jar \
  		com.hadoop.example.FilterJob  /user/vmware/myinput/sample-bloomfilter.txt  /user/vmware/output/bloomfilter 
  
## Copy Output to Local File System  

	bin/hadoop fs -copyToLocal /user/vmware/output/bloomfilter output/bloomfilter
	
	
## Output from the MapReduce Task
   
        $ cat output/bloomfilter/part-r-00000 
        01/02/2013,dan...@xyz.com,1,bad service
        
   
  

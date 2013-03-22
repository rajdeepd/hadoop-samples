#MapReduce Sample using Count with Counter Example

This sample uses the MapReduce API to count the number of words using the Count with Counter Pattern

## Sample Input File
	
	Sample text for Word Count.
	

## Copy Input File into HDFS
	
	bin/hadoop fs -copyFromLocal ../hadoop-samples/myinput/sample-counter.txt /user/vmware/myinput/sample-counter.txt

## Execute the MapReduce Job
	
	bin/hadoop jar ../hadoop-samples/java/inverted-index-example/target/count-with-counter-example-1.0.jar \
          com.hadoop.example.WordCountJob  /user/vmware/myinput/sample-counter.txt  /user/vmware/output/counter

## Copy Output to Local File System  

	bin/hadoop fs -copyToLocal /user/vmware/output/counter output/counter
	
	
## Output from the MapReduce Task
   
		Computational:1
		MapReduce:2
		a:6
		across:2
		administratively:1
		advantage:1
		all:1
		and:3
		are:2
		as:1
		assets:1
		can:2
		cluster:1
		collectively:1
		computers:1
		dat:2
		data:2
		database:1
		datasets:1
		decrease:1
		distributed:1
		either:1
		filesystem:1
		for:1
		framework:1
		geographically:1
		grid:1
		hardwar:1
		hardware:1
		heterogenous:1
		huge:1
		if:2
		in:2
		is:1
		large:1
		local:1
		locality:1
		more:1
		near:1
		network:1
		nodes:3
		number:1
		occur:1
		of:4
		on:3
		or:3
		parallelizable:1
		problems:1
		processing:3
		referred:1
		same:1
		shared:1
		similar:1
		storage:1
		stored:1
		structured:1
		system:1
		take:1
		the:3
		to:2
		transmission:1
		unstructure:1
		use:2
		using:1
   	
	

   
  

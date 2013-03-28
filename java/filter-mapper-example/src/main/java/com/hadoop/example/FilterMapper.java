package com.hadoop.example;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FilterMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

	  protected void map(LongWritable key, Text value, Context context)
	      throws java.io.IOException, InterruptedException {
	    String[] tokens = value.toString().split(",");
	    int rating = Integer.parseInt(tokens[2]);
	    if(rating == 1){
	    	System.out.println(tokens[3]);
	    	context.write(new Text(tokens[3]),NullWritable.get() );
	    }
	  }  
}

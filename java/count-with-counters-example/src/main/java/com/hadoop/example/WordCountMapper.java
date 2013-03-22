package com.hadoop.example;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	  private static String WORD = "Word";
	
	  protected void map(LongWritable key, Text value, Context context)
	      throws java.io.IOException, InterruptedException {
	    String[] tokens = value.toString().split(" ");
	    for(String token : tokens){
	    	token = trim(token);
	    	Counter counter= context.getCounter(WORD, token);
	    	counter.increment(1);
	    	System.out.println(counter);
	    }
	  }  
	  
	private String trim(String token) {
		if (token.endsWith(".") || token.endsWith(",")) {
			token = token.substring(0, token.length() - 2);
		}
		if (token.endsWith(")")) {
			token = token.substring(0, token.length() - 2);
		}
		if (token.startsWith("(")) {
			token = token.substring(1);
		}
		return token;
	}
}

package com.hadoop.example;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/*
 * Sample Data <year> <temperature>
 * 1990;32
 * 1990;31
 * 1990;30
 * 1991;28
 * 1991;35
 * 1991;30
 */

public class MaxTemperatureMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	  private Text yearText = new Text();
	  private final static IntWritable tempWritable = new IntWritable(0);
	
	  protected void map(LongWritable key, Text value, Context context)
	      throws java.io.IOException, InterruptedException {
	    String[] line = value.toString().split(";");
	    String year = line[0];
	    yearText.set(year);
	    int temp = Integer.parseInt(line[1]);
	    tempWritable.set(temp);
	    context.write(yearText,tempWritable);
	  }  
}

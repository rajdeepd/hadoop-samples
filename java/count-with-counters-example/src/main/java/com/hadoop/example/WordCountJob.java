package com.hadoop.example;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.CounterGroup;
import org.apache.hadoop.mapreduce.Counters;
import org.apache.hadoop.mapreduce.Job;

public class WordCountJob {

  public static void main(String[] args) 
		  throws IOException, ClassNotFoundException, InterruptedException {
    if (args.length != 2) {
      System.err.println("Usage: WordCountJob <input path> <output path>");
      System.exit(-1);
    }
    
    Job job = new Job();
    job.setJarByClass(com.hadoop.example.WordCountJob.class);
    job.setJobName("WordCount with Counter");
   
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    
    job.setMapperClass(com.hadoop.example.WordCountMapper.class);

    job.waitForCompletion(true);
    
    CounterGroup counters = job.getCounters().getGroup("Word");
    for(Counter counter:counters){
    	System.out.println(counter.getDisplayName() + ":" + counter.getValue());
    }
  }
}

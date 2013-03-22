package com.hadoop.example;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends
Reducer<Text, IntWritable, Text, IntWritable> {
	ArrayList<Integer> temperatureList = new ArrayList<Integer>();
	protected void reduce(Text key, Iterable<IntWritable> values, Context context) 
			throws java.io.IOException, InterruptedException {
		for (IntWritable value : values) {
			temperatureList.add(value.get());
		}
		Collections.sort(temperatureList);
		int size  = temperatureList.size(); 
		int maxValue = temperatureList.get(size -1);
		context.write(key, new IntWritable(maxValue));
	}
}

package com.hadoop.example;

import java.util.ArrayList;
import java.util.Collections;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MedianTemperatureReducer extends
        Reducer<Text, IntWritable, Text, IntWritable> {
	ArrayList<Integer> temperatureList = new ArrayList<Integer>();
	
	protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws java.io.IOException, InterruptedException {
		int median = 0;
		for (IntWritable value : values) {
			temperatureList.add(value.get());
		}
		Collections.sort(temperatureList);
		int size  = temperatureList.size();

		if(size%2 == 0){
			int half = size/2;

			median  = temperatureList.get(half);
		}else {
			int half = (size + 1)/2;
			median = temperatureList.get(half -1);
		}
		context.write(key, new IntWritable(median));
	}

}

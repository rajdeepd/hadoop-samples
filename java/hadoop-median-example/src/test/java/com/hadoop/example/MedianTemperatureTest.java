package com.hadoop.example;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class MedianTemperatureTest {
	MapDriver<LongWritable, Text, Text, IntWritable> mapDriver;
	ReduceDriver<Text, IntWritable, Text, IntWritable> reduceDriver;
	MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable> mapReduceDriver;

	@Before
	public void setUp() {
		MedianTemperatureMapper mapper = new MedianTemperatureMapper();
		MedianTemperatureReducer reducer = new MedianTemperatureReducer();
		mapDriver = MapDriver.newMapDriver();
		mapDriver.setMapper(mapper);
		reduceDriver = ReduceDriver.newReduceDriver(reducer);
		mapReduceDriver = MapReduceDriver.newMapReduceDriver(mapper, reducer);
	}

	@Test
	public void testMapper() {
		mapDriver.withInput(new LongWritable(), new Text(
				"1990;25"));
		mapDriver.withOutput(new Text("1990"), new IntWritable(25));
		mapDriver.runTest();
	}

	@Test
	public void testReducer() {
		 List<IntWritable> values = new ArrayList<IntWritable>();
		 values.add(new IntWritable(1));
		 values.add(new IntWritable(2));
		 values.add(new IntWritable(3));
		 reduceDriver.withInput(new Text("1990"), values);
		 reduceDriver.withOutput(new Text("1990"), new IntWritable(2));
		 reduceDriver.runTest();
	}
}

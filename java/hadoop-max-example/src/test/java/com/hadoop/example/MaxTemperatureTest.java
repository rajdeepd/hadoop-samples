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

public class MaxTemperatureTest {
	MapDriver<LongWritable, Text, Text, IntWritable> mapDriver;
	ReduceDriver<Text, IntWritable, Text, IntWritable> reduceDriver;
	MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable> mapReduceDriver;

	@Before
	public void setUp() {
		MaxTemperatureMapper mapper = new MaxTemperatureMapper();
		MaxTemperatureReducer reducer = new MaxTemperatureReducer();
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
		 values.add(new IntWritable(21));
		 values.add(new IntWritable(22));
		 values.add(new IntWritable(23));
		 reduceDriver.withInput(new Text("1990"), values);
		 reduceDriver.withOutput(new Text("1990"), new IntWritable(23));
		 reduceDriver.runTest();
	}
}

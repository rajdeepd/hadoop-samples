package com.hadoop.example;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class FilterTest {
	MapDriver<LongWritable, Text, Text, NullWritable> mapDriver;
	//ReduceDriver<Text, IntWritable, Text, IntWritable> reduceDriver;
	//MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable> mapReduceDriver;

	@Before
	public void setUp() {
		FilterMapper mapper = new FilterMapper();
		mapDriver = MapDriver.newMapDriver();
		mapDriver.setMapper(mapper);
	}

	@Test
	public void testMapper() {
		mapDriver.withInput(new LongWritable(), new Text(
				"01/02/2013,dan...@xyz.com,1,Horrible service at the store"));
		
		mapDriver.withOutput(new Text("Horrible service at the store"),
				             NullWritable.get());
		mapDriver.runTest();
	}
}

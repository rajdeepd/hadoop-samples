package com.hadoop.example;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

public class WordCountTest {
	MapDriver<LongWritable, Text, Text, IntWritable> mapDriver;
	ReduceDriver<Text, IntWritable, Text, IntWritable> reduceDriver;
	MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable> mapReduceDriver;

	@Before
	public void setUp() {
		WordCountMapper mapper = new WordCountMapper();
	    mapDriver = MapDriver.newMapDriver();
		mapDriver.setMapper(mapper);
	}

	@Test
	public void testMapper() {
		mapDriver.withInput(new LongWritable(), new Text(
				"hi there hi"));
		mapDriver.runTest();
		assert(mapDriver.getCounters().getGroup("Word").size() == 2);
		assert(mapDriver.getCounters().getGroup("Word").findCounter("hi").getValue() == 2);
		assert(mapDriver.getCounters().getGroup("Word").findCounter("there").getValue() == 1);
	}
}

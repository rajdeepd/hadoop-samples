package com.hadoop.example;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Before;
import org.junit.Test;


public class FilterTest {
	MapDriver<LongWritable, Text, Text, NullWritable> mapDriver;

	@Before
	public void setUp() {
		FilterMapper mapper = new FilterMapper();
		mapDriver = MapDriver.newMapDriver();
		mapDriver.setMapper(mapper);
	}

	@Test
	public void testMapper() {
		String value = "01/02/2013,dan...@xyz.com,1,bad service";
		mapDriver.withInput(new LongWritable(), new Text(
				value));
		
		mapDriver.withOutput(new Text(value),
				             NullWritable.get());
		mapDriver.runTest();
	}
}

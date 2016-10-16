package com.bigdata.hadoop.MapReduce;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class WriterMapper extends MapReduceBase implements Mapper<Object, Object, NullWritable,
Text> {


	@Override
	public void map(Object key, Object value, OutputCollector<NullWritable, Text> output, Reporter reporter)
			throws IOException {
		String source =  "C:/Users/gabri/git/Projetos-Pessoais/BigData/src/com/bigdata/data/mapReduceOut/part-r-00000";
				   Text jsonDoc = new Text(source);
				   // send the doc directly
				   output.collect(NullWritable.get(), jsonDoc);
		
	}

	

}

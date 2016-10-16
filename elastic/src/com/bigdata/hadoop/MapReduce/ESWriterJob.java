package com.bigdata.hadoop.MapReduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.elasticsearch.hadoop.mr.EsOutputFormat;

public class ESWriterJob {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		

        Path inputPath = new Path("C:/Users/gabri/git/Projetos-Pessoais/BigData/src/com/bigdata/data/crimes.csv");
        Path outputDir = new Path("C:/Users/gabri/git/Projetos-Pessoais/BigData/src/com/bigdata/data/out.txt");
 
		Configuration conf = new Configuration(true);
		conf.set("es.nodes", "localhost");
		conf.set("es-port", "9200");
		conf.set("es.resource", "crimes/crimes");
		Job job = new Job(conf, "writer");
		job.setJarByClass(WordCountMapper.class);
		
		//es-hadoop conf
		 job.setOutputFormatClass(EsOutputFormat.class);
         job.setMapOutputValueClass(MapWritable.class);
         job.setMapperClass(WordCountMapper.class); 
         job.setReducerClass(WordCountReduce.class);
         job.setNumReduceTasks(1);

         job.setOutputKeyClass(Text.class);
         job.setOutputValueClass(IntWritable.class);
         
         FileInputFormat.addInputPath( job, inputPath);
         job.setInputFormatClass(TextInputFormat.class);
         
         boolean result = job.waitForCompletion(true);
         System.out.println(result);
         System.exit(result ? 0 : 1);

	}

}

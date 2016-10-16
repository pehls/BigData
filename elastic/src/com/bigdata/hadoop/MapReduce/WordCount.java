package com.bigdata.hadoop.MapReduce;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.elasticsearch.hadoop.mr.EsOutputFormat;

import com.bigdata.util.ElasticSearch;
import com.bigdata.util.ElasticStatic;
 
        public class WordCount {

//        	public static void main(String[] args) throws IOException,
//        			InterruptedException, ClassNotFoundException {
//
//        		Path inputPath = new Path("C:/Users/gabri/git/Projetos-Pessoais/BigData/src/com/bigdata/data/out/idXoffense.json");
//                Path outputDir = new Path("C:/Users/gabri/git/Projetos-Pessoais/BigData/src/com/bigdata/data/out");
//
//        		// Create configuration
//        		Configuration conf = new Configuration(true);
//
//        		// Create job
//        		Job job = new Job(conf, "WordCount");
//        		job.setJarByClass(WordCountMapper.class);
//
//        		// Setup MapReduce
//        		job.setMapperClass(WordCountMapper.class);
//        		job.setReducerClass(WordCountReduce.class);
//        		job.setNumReduceTasks(1);
//
//        		// Specify key / value
//        		job.setOutputKeyClass(Text.class);
//        		job.setOutputValueClass(IntWritable.class);
//
//        		// Input
//        		FileInputFormat.addInputPath(job, inputPath);
//        		job.setInputFormatClass(TextInputFormat.class);
//
//        		// Output
//        		FileOutputFormat.setOutputPath(job, outputDir);
//        		job.setOutputFormatClass(TextOutputFormat.class);
//
//        		// Delete output if exists
//        		FileSystem hdfs = FileSystem.get(conf);
//        		if (hdfs.exists(outputDir))
//        			hdfs.delete(outputDir, true);
//
//        		// Execute job
//        		int code = job.waitForCompletion(true) ? 0 : 1;
//        		System.exit(code);
//
//        	}

			public WordCount(String urlInput) throws Exception {
				long tempoinit = System.currentTimeMillis();
				Path inputPath = new Path(urlInput);
                Path outputDir = new Path("C:/Users/gabri/Desktop/projetos/bigData/elastic/src/com/bigdata/data/mapReduceOut");

        		// Create configuration
        		Configuration conf = new Configuration();
        		
        		//conf for elastic
        		//Configuration conf = new Configuration();
//        		 conf.set("es.nodes","localhost");    
//                          conf.set("es-port","9200");    
//                          conf.set("es.resource","teste/values");
//                          conf.set("es.query","{ \"match_all\" : { } }");

        		// Create job
        		Job job = new Job(conf, "WordCount");
        		
//        		job.setJarByClass(WordCountMapper.class);
//        		
//        		job.setOutputFormatClass(EsOutputFormat.class);
//                job.setMapOutputValueClass(MapWritable.class);
//                job.setMapperClass(WordCountMapper.class);        
//                ((JobConf) job).setSpeculativeExecution(false);
//         
//                FileInputFormat.addInputPath(job, new Path(args[0]));
//                job.setInputFormatClass(KeyValueTextInputFormat.class);
        		//job = new Job(conf);
        		job.setJarByClass(WordCountMapper.class);

        		// Setup MapReduce
        		job.setMapperClass(WordCountMapper.class);
        		job.setReducerClass(WordCountReduce.class);
        		job.setNumReduceTasks(1);

        		// Specify key / value
        		job.setOutputKeyClass(Text.class);
        		job.setOutputValueClass(IntWritable.class);

        		// Input
        		FileInputFormat.addInputPath(job, inputPath);
        		job.setInputFormatClass(TextInputFormat.class);

        		// Output
        		FileOutputFormat.setOutputPath(job, outputDir);
        		job.setOutputFormatClass(TextOutputFormat.class);

        		// Delete output if exists
        		FileSystem hdfs = FileSystem.get(conf);
        		if (hdfs.exists(outputDir))
        			hdfs.delete(outputDir, true);

        		// Execute job
        		int code = job.waitForCompletion(true) ? 0 : 1;
        		System.out.println("TEMPO TOTAL MapReduce");
    			System.out.println(System.currentTimeMillis()-tempoinit);
        		System.exit(code);

        	}

        }
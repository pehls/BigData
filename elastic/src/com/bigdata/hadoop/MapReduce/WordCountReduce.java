package com.bigdata.hadoop.MapReduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.json.JSONObject;

import com.bigdata.model.Count;
import com.bigdata.model.Crime;
import com.bigdata.util.ElasticSearch;
import com.bigdata.util.ElasticStatic;

public class WordCountReduce extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	//ElasticSearch elastic = new ElasticSearch();
	public void reduce(Text text, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int sum = 0;
		
		Count c = new Count();
		for (IntWritable value : values) {
			sum += value.get();
		}
		context.write(text, new IntWritable(sum));
		//ElasticStatic.elastic.addIndiceRequisicao("teste", "values",""+Count.getCount(), new Crime(Count.getCount(), text.toString(), sum));

		//elastic.addIndiceRequisicao("teste", "values",""+Count.getCount(), new Crime(Count.getCount(), text.toString(), sum));
	}
}

// public void reduce(Text key, Iterable<Text> values, Context context) throws
// IOException, InterruptedException {
//
// try {
// JSONObject obj = new JSONObject();
// JSONArray ja = new JSONArray();
// for (Text val : values) {
// JSONObject jo = new JSONObject().put("Crime", val.toString());
// ja.put(jo);
// }
// obj.put("crimes", ja);
// obj.put("publicaddres", key.toString());
// context.write(NullWritable.get(), new Text(obj.toString()));
// } catch (JSONException e) {
// e.printStackTrace();
// }
// }
// }
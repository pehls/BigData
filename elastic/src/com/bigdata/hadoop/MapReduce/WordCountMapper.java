package com.bigdata.hadoop.MapReduce;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.elasticsearch.hadoop.cfg.Settings;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.supercsv.io.CsvMapReader;
import org.supercsv.prefs.CsvPreference;

import com.bigdata.util.CSVReaderOffense;

public class WordCountMapper extends Mapper<Object, Text, Text, IntWritable> {

	private final IntWritable ONE = new IntWritable(1);
	private Text word = new Text();

	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		// String url = new
		// String("C:/Users/gabri/git/Projetos-Pessoais/BigData/src/com/bigdata/data/out/idXoffense.json");
		try {
			Object object = null;
			JSONArray ja = null;
			JSONParser jsonParser = new JSONParser();
			object = jsonParser.parse(value.toString());
			ja = (JSONArray) object;
			for (int i = 0; i < ja.size(); i++) {
				JSONObject obj = (JSONObject) ja.get(i);
				word.set(obj.get("offense").toString());
				context.write(word, ONE);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// try {
		// ja = CSVReaderOffense.readerResponse(url);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// for (String str : csv) {
		// word.set(str);
		// context.write(word, ONE);
		// }

	}

}
// public class WordCountMapper extends Mapper<LongWritable, Text,IntWritable,
// IntWritable> {
//
// private final IntWritable ONE = new IntWritable(1);
// private Text word = new Text();
//
// public static class Map extends Mapper<LongWritable, Text, Text, Text>{
//
// public void map(LongWritable key, Text value, Context context) throws
// IOException, InterruptedException{
//
// String publicaddress;
// String controlnbr;
// String offense;
// String description;
// String neighborhood;
// String line = value.toString();
// String[] tuple = line.split(",");
// try{
// for(int i=0;i<tuple.length; i++){
// JSONObject obj = new JSONObject(tuple[i]);
// publicaddress = obj.getString("publicaddress");
// controlnbr = obj.getString("controlnbr");
// offense = obj.getString("offense");
// description = obj.getString("description");
// neighborhood = obj.getString("neighborhood");
// context.write(new Text (publicaddress),
// new Text (controlnbr)
// );
// }
// }catch(JSONException e){
// e.printStackTrace();
// }
// }
// }
// }

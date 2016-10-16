package com.bigdata.testes;



import com.bigdata.hadoop.MapReduce.WordCount;
import com.bigdata.util.CSVReaderControlnbr;
import com.bigdata.util.CSVReaderDescription;
import com.bigdata.util.CSVReaderNeighborhood;
import com.bigdata.util.CSVReaderOffense;
import com.bigdata.util.CSVReaderPublicAddress;
import com.bigdata.util.ElasticSearch;

public class TesteCSVReader {

	public static void main(String[] args) {
		WordCount wcMapReduce ;
		String url = "C:/Users/gabri/Desktop/projetos/bigData/elastic/src/com/bigdata/data/crimes.csv";
		try {
//			CSVReaderPublicAddress read = new CSVReaderPublicAddress(url);
//			CSVReaderControlnbr read2 = new CSVReaderControlnbr(url);
//			CSVReaderDescription read3 = new CSVReaderDescription(url);
//			CSVReaderNeighborhood read4 = new CSVReaderNeighborhood(url);
			long tempoinit = System.currentTimeMillis();
			CSVReaderOffense read5 = new CSVReaderOffense(url);
			System.out.println("TEMPO TOTAL CSV READER");
			System.out.println(System.currentTimeMillis()-tempoinit);
			wcMapReduce = new WordCount("C:/Users/gabri/Desktop/projetos/bigData/elastic/src/com/bigdata/data/out/idXoffense.json");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

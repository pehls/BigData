package com.bigdata.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONWriter;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.bigdata.model.Crime;

public class CSVReaderControlnbr {
	final String[] header = new String[] { "publicaddress", "controlnbr", "CCN", "Precinct", "ReportedDate",
			"BeginDate", "Time", "Offense", "Description", "UCRCode", "EnteredDate", "Long", "Lat", "x", "y",
			"Neighborhood", "lastchanged", "LastUpdateDate", "OBJECTID", "ESRI_OID" };
	final CellProcessor[] processors = getProcessors();

	private static CellProcessor[] getProcessors() {

		final CellProcessor[] processors = new CellProcessor[] { new Optional(), new Optional(), new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(), new NotNull(), new NotNull(),
				new Optional(), new Optional(), new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(), new Optional() };

		return processors;
	}

	public CSVReaderControlnbr(String url) throws Exception {
		ICsvBeanReader beanReader = null;
		
		JSONArray ja = new JSONArray();
		try {
			beanReader = new CsvBeanReader(new FileReader(url), CsvPreference.STANDARD_PREFERENCE);

			// the header elements are used to map the values to the bean (names
			// must match)
			final String[] header = beanReader.getHeader(true);
			final CellProcessor[] processors = getProcessors();
			
			Crime customer;
			int i = 0;
			while ((customer = beanReader.read(Crime.class, header, processors)) != null) {
				JSONObject obj = new JSONObject();
				obj.put("id_crime", i);
				obj.put("controlnbr", customer.getControlnbr());
				ja.put(obj);
				
				i++;
			}
			try {

				FileWriter file = new FileWriter(
						"C:/Users/gabri/git/Projetos-Pessoais/BigData/src/com/bigdata/data/out/idXcontrolnbr.json");
				file.write(ja.toString());
				file.flush();
				file.close();
				System.out.println(ja);
			} catch (IOException e) {
				e.printStackTrace();

			}
		} finally {
			if (beanReader != null) {
				beanReader.close();
			}
		}

	}
}

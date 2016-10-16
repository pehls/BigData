package com.bigdata.util;

import java.io.FileWriter;
import java.io.Writer;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.bigdata.model.Crime;

public class CSVWriter {

	public CSVWriter() {
		// create the customer beans
		
		ICsvBeanWriter beanWriter = null;
		try {
			beanWriter = new CsvBeanWriter(new FileWriter("/BigData/src/com/bigdata/data/crimes.csv"),
					CsvPreference.STANDARD_PREFERENCE);

			// the header elements are used to map the bean values to each
			// column (names must match)
			final String[] header = new String[] { "publicaddress", "controlnbr", "CCN", "Precinct", "ReportedDate",
					"BeginDate", "Time", "Offense", "Description", "UCRCode", "EnteredDate", "Long", "Lat", "x", "y",
					"Neighborhood", "lastchanged", "LastUpdateDate", "OBJECTID", "ESRI_OID" };
			final CellProcessor[] processors = getProcessors();

			// write the header
			beanWriter.writeHeader(header);

			// write the beans
			for (final Crime customer : customer) {
				beanWriter.write(customer, header, processors);
			}

		} finally {
			if (beanWriter != null) {
				beanWriter.close();
			}
		}
	}

	private static CellProcessor[] getProcessors() {

		final CellProcessor[] processors = new CellProcessor[] { 
				new UniqueHashCode(),
				new NotNull(),
				new NotNull(), 
				new NotNull(), 
				new NotNull(), 
				new NotNull(), 
				new Optional(), 
				new Optional()
		};

		return processors;
	}

}

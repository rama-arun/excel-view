package me.aboullaite.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import me.aboullaite.model.Section1;

/**
 * Created by aboullaite on 2017-02-24.
 */
public class CsvView extends AbstractCsvView {

	@Override
	protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=\"my-csv-file.csv\"");

		List<Section1> section1s = (List<Section1>) model.get("section1");
		String[] header = { "When to do", "What to do" };
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		csvWriter.writeHeader(header);

		for (Section1 section1 : section1s) {
			csvWriter.write(section1, header);
		}
		csvWriter.close();

	}
}

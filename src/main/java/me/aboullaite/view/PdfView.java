package me.aboullaite.view;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import me.aboullaite.model.Section1;
import me.aboullaite.model.Section10;
import me.aboullaite.model.Section11;
import me.aboullaite.model.Section12;
import me.aboullaite.model.Section13;
import me.aboullaite.model.Section14;
import me.aboullaite.model.Section15;
import me.aboullaite.model.Section16;
import me.aboullaite.model.Section17;
import me.aboullaite.model.Section18;
import me.aboullaite.model.Section19;
import me.aboullaite.model.Section2;
import me.aboullaite.model.Section20;
import me.aboullaite.model.Section21;
import me.aboullaite.model.Section3;
import me.aboullaite.model.Section4;
import me.aboullaite.model.Section5;
import me.aboullaite.model.Section6;
import me.aboullaite.model.Section7;
import me.aboullaite.model.Section8;
import me.aboullaite.model.Section9;
import me.aboullaite.service.UserService;

/**
 * Created by aboullaite on 2017-02-25.
 */
public class PdfView extends AbstractPdfView {

	@Autowired
	UserService userService;

	public static final String IMG1 = "src/main/resources/money.jpg";

	@Override
	protected void buildPage2PdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// change the file name
		List<Section1> section1s = (List<Section1>) model.get("section1");

		Image img = Image.getInstance(IMG1);
		document.add(img);
		document.add(new Paragraph(""));
		document.addTitle("Letter of Last Instructions");
		document.add(new Paragraph(
				"              							                                                  for: "
						+ request.getParameter("client").replaceAll("_", " ")
						+ "              					           printed:" + LocalDate.now()));
		document.add(new Paragraph(""));
		Font bold = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
		document.add(new Paragraph("TO DO LIST", bold));
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));

		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100.0f);
		table.setSpacingBefore(10);

		PdfPTable table2 = new PdfPTable(1);
		table2.setWidthPercentage(100.0f);
		table2.setSpacingBefore(10);

		PdfPTable table3 = new PdfPTable(1);
		table3.setWidthPercentage(100.0f);
		table3.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(BaseColor.BLACK);
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setPadding(5);
		cell.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell.setPhrase(new Phrase("When to do", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("What to do", font));
		table.addCell(cell);

		PdfPCell cella = new PdfPCell();
		cella.setBorderColor(BaseColor.LIGHT_GRAY);
		Font f = FontFactory.getFont(FontFactory.TIMES, 11);

		Font red = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
		Paragraph redText = new Paragraph("You have not provided any information for this section. ", red);

		if (section1s.size() == 0) {
			document.add(table);
			document.add(redText);
		} else {
			for (Section1 section1 : section1s) {
				cella.setPhrase(new Phrase(section1.getKey(), f));
				table.addCell(cella);
				cella.setPhrase(new Phrase(section1.getValue().replaceAll("\"", ""), f));
				table.addCell(cella);
			}

			document.add(table);
		}
		PdfPCell cell2 = new PdfPCell();
		cell2.setPhrase(new Phrase("	-- page 2 --  ", FontFactory.getFont(FontFactory.COURIER, 10)));
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell2.setBorder(Rectangle.NO_BORDER);
		table2.addCell(cell2);
		document.add(table2);

		PdfPCell cell3 = new PdfPCell();
		cell3.setPhrase(new Phrase(
				"	John Vyge, 2017. This document is not a legal document nor is it "
						+ "	designed to give any specific legal advice pertaining to any "
						+ "	specific circumstances. It is important that professional legal "
						+ "	and financial advice be obtained before acting upon any of the "
						+ "	information contained in this document. Unauthorized use and/or "
						+ "	duplication of this material without express and written "
						+ "	permission from the author and/or owner is strictly prohibited."
						+ "	You are authorized to print out this document for your own "
						+ "	personal use only. Excerpts and links may be used, provided that "
						+ "	full and clear credit is given to John Vyge and with appropriate "
						+ "	and specific direction to the original content.",
				FontFactory.getFont(FontFactory.COURIER, 7)));
		cell3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell3.setBorder(Rectangle.NO_BORDER);
		table3.addCell(cell3);
		document.add(table3);
	}

	@Override
	protected void buildPage3PdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// change the file name
		Image img = Image.getInstance(IMG1);
		document.add(img);
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setColor(BaseColor.BLUE);
		List<Section2> section2s = (List<Section2>) model.get("section2");
		document.add(new Paragraph(
				"              							                                                  for: "
						+ request.getParameter("client").replaceAll("_", " ")
						+ "              					           printed:" + LocalDate.now()));
		document.add(new Paragraph(""));
		Font bold = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
		document.add(new Paragraph("WHO TO NOTIFY", bold));
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("Immediate Family & Friends", fontTitle));
		PdfPTable tableSection2 = new PdfPTable(5);
		tableSection2.setWidthPercentage(100.0f);
		tableSection2.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(BaseColor.BLACK);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setPadding(5);
		cell.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell.setPhrase(new Phrase("Name", font));
		tableSection2.addCell(cell);

		cell.setPhrase(new Phrase("Relationship", font));
		tableSection2.addCell(cell);

		cell.setPhrase(new Phrase("City", font));
		tableSection2.addCell(cell);

		cell.setPhrase(new Phrase("Email", font));
		tableSection2.addCell(cell);

		cell.setPhrase(new Phrase("Phone", font));
		tableSection2.addCell(cell);

		PdfPCell cella = new PdfPCell();
		cella.setBorderColor(BaseColor.LIGHT_GRAY);
		Font f = FontFactory.getFont(FontFactory.TIMES, 11);
		Font red = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
		Paragraph redText = new Paragraph("You have not provided any information for this section. ", red);

		if (section2s.size() == 0) {
			document.add(tableSection2);
			document.add(redText);
		} else {
			for (Section2 section2 : section2s) {
				cella.setPhrase(new Phrase(section2.getName().replaceAll("\"", ""), f));
				tableSection2.addCell(cella);
				cella.setPhrase(new Phrase(section2.getRelationship().replaceAll("\"", ""), f));
				tableSection2.addCell(cella);
				cella.setPhrase(new Phrase(section2.getCity().replaceAll("\"", ""), f));
				tableSection2.addCell(cella);
				cella.setPhrase(new Phrase(section2.getEmail().replaceAll("\"", ""), f));
				tableSection2.addCell(cella);
				cella.setPhrase(new Phrase(section2.getPhone().replaceAll("\"", ""), f));
				tableSection2.addCell(cella);
			}

			document.add(tableSection2);
		}
		/** Section 3 **/
		PdfPTable tableSection3 = new PdfPTable(5);
		List<Section3> section3s = (List<Section3>) model.get("section3");
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("Funeral Home", fontTitle));
		tableSection3.setWidthPercentage(100.0f);
		tableSection3.setSpacingBefore(10);

		// define table header cell
		PdfPCell cell2 = new PdfPCell();
		cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell2.setPadding(5);
		cell2.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell2.setPhrase(new Phrase("Name", font));
		tableSection3.addCell(cell2);

		cell2.setPhrase(new Phrase("Relationship", font));
		tableSection3.addCell(cell2);

		cell2.setPhrase(new Phrase("City", font));
		tableSection3.addCell(cell2);

		cell2.setPhrase(new Phrase("Email", font));
		tableSection3.addCell(cell2);

		cell2.setPhrase(new Phrase("Phone", font));
		tableSection3.addCell(cell2);

		cella.setBorderColor(BaseColor.LIGHT_GRAY);
		if (section3s.size() == 0) {
			document.add(tableSection3);
			document.add(redText);
		} else {
			for (Section3 section3 : section3s) {
				cella.setPhrase(new Phrase(section3.getName().replaceAll("\"", ""), f));
				tableSection3.addCell(cella);
				cella.setPhrase(new Phrase(section3.getRelationship().replaceAll("\"", ""), f));
				tableSection3.addCell(cella);
				cella.setPhrase(new Phrase(section3.getCity().replaceAll("\"", ""), f));
				tableSection3.addCell(cella);
				cella.setPhrase(new Phrase(section3.getEmail().replaceAll("\"", ""), f));
				tableSection3.addCell(cella);
				cella.setPhrase(new Phrase(section3.getPhone().replaceAll("\"", ""), f));
				tableSection3.addCell(cella);
			}

			document.add(tableSection3);
		}
		/** Section 4 **/
		PdfPTable tableSection4 = new PdfPTable(5);
		List<Section4> section4s = (List<Section4>) model.get("section4");
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("Professional Advisors", fontTitle));
		tableSection4.setWidthPercentage(100.0f);
		tableSection4.setSpacingBefore(10);

		// define table header cell
		PdfPCell cell4 = new PdfPCell();
		cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell4.setPadding(5);
		cell4.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell4.setPhrase(new Phrase("Name", font));
		tableSection4.addCell(cell4);

		cell4.setPhrase(new Phrase("Relationship", font));
		tableSection4.addCell(cell4);

		cell4.setPhrase(new Phrase("City", font));
		tableSection4.addCell(cell4);

		cell4.setPhrase(new Phrase("Email", font));
		tableSection4.addCell(cell4);

		cell4.setPhrase(new Phrase("Phone", font));
		tableSection4.addCell(cell4);
		if (section4s.size() == 0) {
			document.add(tableSection4);
			document.add(redText);
		} else {
			for (Section4 section4 : section4s) {
				cella.setPhrase(new Phrase(section4.getName().replaceAll("\"", ""), f));
				tableSection4.addCell(cella);
				cella.setPhrase(new Phrase(section4.getRelationship().replaceAll("\"", ""), f));
				tableSection4.addCell(cella);
				cella.setPhrase(new Phrase(section4.getCity().replaceAll("\"", ""), f));
				tableSection4.addCell(cella);
				cella.setPhrase(new Phrase(section4.getEmail().replaceAll("\"", ""), f));
				tableSection4.addCell(cella);
				cella.setPhrase(new Phrase(section4.getPhone().replaceAll("\"", ""), f));
				tableSection4.addCell(cella);
			}

			document.add(tableSection4);
		}
		/** end **/

		/** Section 5 **/
		PdfPTable tableSection5 = new PdfPTable(5);
		List<Section5> section5s = (List<Section5>) model.get("section5");
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("Medical Contacts", fontTitle));
		tableSection5.setWidthPercentage(100.0f);
		tableSection5.setSpacingBefore(10);

		// define table header cell
		PdfPCell cell5 = new PdfPCell();
		cell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell5.setPadding(5);
		cell5.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell5.setPhrase(new Phrase("Name", font));
		tableSection5.addCell(cell5);

		cell5.setPhrase(new Phrase("Relationship", font));
		tableSection5.addCell(cell5);

		cell5.setPhrase(new Phrase("City", font));
		tableSection5.addCell(cell5);

		cell5.setPhrase(new Phrase("Email", font));
		tableSection5.addCell(cell5);

		cell5.setPhrase(new Phrase("Phone", font));
		tableSection5.addCell(cell5);
		if (section5s.size() == 0) {
			document.add(tableSection5);
			document.add(redText);
		} else {
			for (Section5 section5 : section5s) {
				cella.setPhrase(new Phrase(section5.getName().replaceAll("\"", ""), f));
				tableSection5.addCell(cella);
				cella.setPhrase(new Phrase(section5.getRelationship().replaceAll("\"", ""), f));
				tableSection5.addCell(cella);
				cella.setPhrase(new Phrase(section5.getCity().replaceAll("\"", ""), f));
				tableSection5.addCell(cella);
				cella.setPhrase(new Phrase(section5.getEmail().replaceAll("\"", ""), f));
				tableSection5.addCell(cella);
				cella.setPhrase(new Phrase(section5.getPhone().replaceAll("\"", ""), f));
				tableSection5.addCell(cella);
			}

			document.add(tableSection5);
		}
		/** end **/

		/** Section 6 **/
		PdfPTable tableSection6 = new PdfPTable(5);
		List<Section6> section6s = (List<Section6>) model.get("section6");
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("Insurance Contacts", fontTitle));
		tableSection6.setWidthPercentage(100.0f);
		tableSection6.setSpacingBefore(10);

		// define table header cell
		PdfPCell cell6 = new PdfPCell();
		cell6.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell6.setPadding(5);
		cell6.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell6.setPhrase(new Phrase("Name", font));
		tableSection6.addCell(cell6);

		cell6.setPhrase(new Phrase("Relationship", font));
		tableSection6.addCell(cell6);

		cell6.setPhrase(new Phrase("City", font));
		tableSection6.addCell(cell6);

		cell6.setPhrase(new Phrase("Email", font));
		tableSection6.addCell(cell6);

		cell6.setPhrase(new Phrase("Phone", font));
		tableSection6.addCell(cell6);
		if (section6s.size() == 0) {
			document.add(tableSection6);
			document.add(redText);
		} else {
			for (Section6 section6 : section6s) {
				cella.setPhrase(new Phrase(section6.getName().replaceAll("\"", ""), f));
				tableSection6.addCell(cella);
				cella.setPhrase(new Phrase(section6.getRelationship().replaceAll("\"", ""), f));
				tableSection6.addCell(cella);
				cella.setPhrase(new Phrase(section6.getCity().replaceAll("\"", ""), f));
				tableSection6.addCell(cella);
				cella.setPhrase(new Phrase(section6.getEmail().replaceAll("\"", ""), f));
				tableSection6.addCell(cella);
				cella.setPhrase(new Phrase(section6.getPhone().replaceAll("\"", ""), f));
				tableSection6.addCell(cella);
			}

			document.add(tableSection6);
		}
		/** end **/

		PdfPTable tablePage = new PdfPTable(1);
		tablePage.setWidthPercentage(100.0f);
		tablePage.setSpacingBefore(10);

		PdfPTable tableFooter = new PdfPTable(1);
		tableFooter.setWidthPercentage(100.0f);
		tableFooter.setSpacingBefore(10);

		PdfPCell cellPage = new PdfPCell();
		cellPage.setPhrase(new Phrase("	-- page 3 --  ", FontFactory.getFont(FontFactory.COURIER, 10)));
		cellPage.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellPage.setBorder(Rectangle.NO_BORDER);
		tablePage.addCell(cellPage);
		document.add(tablePage);

		PdfPCell cellFooter = new PdfPCell();
		cellFooter.setPhrase(new Phrase(
				"	John Vyge, 2017. This document is not a legal document nor is it "
						+ "	designed to give any specific legal advice pertaining to any "
						+ "	specific circumstances. It is important that professional legal "
						+ "	and financial advice be obtained before acting upon any of the "
						+ "	information contained in this document. Unauthorized use and/or "
						+ "	duplication of this material without express and written "
						+ "	permission from the author and/or owner is strictly prohibited."
						+ "	You are authorized to print out this document for your own "
						+ "	personal use only. Excerpts and links may be used, provided that "
						+ "	full and clear credit is given to John Vyge and with appropriate "
						+ "	and specific direction to the original content.",
				FontFactory.getFont(FontFactory.COURIER, 7)));
		cellFooter.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellFooter.setBorder(Rectangle.NO_BORDER);
		tableFooter.addCell(cellFooter);
		document.add(tableFooter);
	}

	@Override
	protected void buildPage4PdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// change the file name
		PdfPCell cella = new PdfPCell();
		cella.setBorderColor(BaseColor.LIGHT_GRAY);
		Font f = FontFactory.getFont(FontFactory.TIMES, 11);
		Image img = Image.getInstance(IMG1);
		document.add(img);
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setColor(BaseColor.BLUE);
		List<Section7> section7s = (List<Section7>) model.get("section7");
		document.add(new Paragraph(
				"              							                                                  for: "
						+ request.getParameter("client").replaceAll("_", " ")
						+ "              					           printed:" + LocalDate.now()));
		document.add(new Paragraph(""));
		Font bold = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
		document.add(new Paragraph("WHERE TO GET CASH NOW", bold));
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("Our Family Budget", fontTitle));
		PdfPTable tableSection7 = new PdfPTable(3);
		tableSection7.setWidthPercentage(100.0f);
		tableSection7.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(BaseColor.BLACK);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setPadding(5);
		cell.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell.setPhrase(new Phrase("Which Account", font));
		tableSection7.addCell(cell);

		cell.setPhrase(new Phrase("Type of Expense", font));
		tableSection7.addCell(cell);

		cell.setPhrase(new Phrase("Amount", font));
		tableSection7.addCell(cell);
		Font red = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
		Paragraph redText = new Paragraph("You have not provided any information for this section. ", red);

		if (section7s.size() == 0) {
			document.add(tableSection7);
			document.add(redText);
		} else {
			for (Section7 section7 : section7s) {
				cella.setPhrase(new Phrase(section7.getAccount().replaceAll("\"", ""), f));
				tableSection7.addCell(cella);
				cella.setPhrase(new Phrase(section7.getExpense().replaceAll("\"", ""), f));
				tableSection7.addCell(cella);
				cella.setPhrase(new Phrase(section7.getAmount().replaceAll("\"", ""), f));
				tableSection7.addCell(cella);
			}

			document.add(tableSection7);
		}
		/** Section 8 **/
		PdfPTable tableSection8 = new PdfPTable(3);
		List<Section8> section8s = (List<Section8>) model.get("section8");
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("1 - Bank Accounts", fontTitle));
		tableSection8.setWidthPercentage(100.0f);
		tableSection8.setSpacingBefore(10);

		// define table header cell
		PdfPCell cell2 = new PdfPCell();
		cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell2.setPadding(5);
		cell2.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell2.setPhrase(new Phrase("Bank", font));
		tableSection8.addCell(cell2);

		cell2.setPhrase(new Phrase("Account Number", font));
		tableSection8.addCell(cell2);

		cell2.setPhrase(new Phrase("Balance", font));
		tableSection8.addCell(cell2);
		if (section8s.size() == 0) {
			document.add(tableSection8);
			document.add(redText);
		} else {
			for (Section8 section8 : section8s) {
				cella.setPhrase(new Phrase(section8.getBank().replaceAll("\"", ""), f));
				tableSection8.addCell(cella);
				cella.setPhrase(new Phrase(section8.getAccountnum().replaceAll("\"", ""), f));
				tableSection8.addCell(cella);
				cella.setPhrase(new Phrase(section8.getBalance().replaceAll("\"", ""), f));
				tableSection8.addCell(cella);
			}

			document.add(tableSection8);
		}
		/** Section 9 **/
		PdfPTable tableSection9 = new PdfPTable(5);
		List<Section9> section9s = (List<Section9>) model.get("section9");
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("2 - Life Insurance", fontTitle));
		tableSection9.setWidthPercentage(100.0f);
		tableSection9.setSpacingBefore(10);

		// define table header cell
		PdfPCell cell4 = new PdfPCell();
		cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell4.setPadding(5);
		cell4.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell4.setPhrase(new Phrase("Policies", font));
		tableSection9.addCell(cell4);

		cell4.setPhrase(new Phrase("Base Plan Name", font));
		tableSection9.addCell(cell4);

		cell4.setPhrase(new Phrase("Type of Coverage", font));
		tableSection9.addCell(cell4);

		cell4.setPhrase(new Phrase("Death Benefit", font));
		tableSection9.addCell(cell4);

		cell4.setPhrase(new Phrase("Issue Date", font));
		tableSection9.addCell(cell4);
		if (section9s.size() == 0) {
			document.add(tableSection9);
			document.add(redText);
		} else {
			for (Section9 section9 : section9s) {
				cella.setPhrase(new Phrase(section9.getPname().replaceAll("\"", ""), f));
				tableSection9.addCell(cella);
				cella.setPhrase(new Phrase(section9.getBpname().replaceAll("\"", ""), f));
				tableSection9.addCell(cella);
				cella.setPhrase(new Phrase(section9.getCoverage().replaceAll("\"", ""), f));
				tableSection9.addCell(cella);
				cella.setPhrase(new Phrase(section9.getDeath().replaceAll("\"", ""), f));
				tableSection9.addCell(cella);
				cella.setPhrase(new Phrase(section9.getIssuedate().replaceAll("\"", ""), f));
				tableSection9.addCell(cella);
			}

			document.add(tableSection9);
		}
		/** end **/

		/** Section 10 **/
		PdfPTable tableSection10 = new PdfPTable(5);
		List<Section10> section10s = (List<Section10>) model.get("section10");
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("3 - Critical Care Insurance", fontTitle));
		tableSection10.setWidthPercentage(100.0f);
		tableSection10.setSpacingBefore(10);

		// define table header cell
		PdfPCell cell5 = new PdfPCell();
		cell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell5.setPadding(5);
		cell5.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell5.setPhrase(new Phrase("Policies", font));
		tableSection10.addCell(cell5);

		cell5.setPhrase(new Phrase("Base Plan Name", font));
		tableSection10.addCell(cell5);

		cell5.setPhrase(new Phrase("Type of Coverage", font));
		tableSection10.addCell(cell5);

		cell5.setPhrase(new Phrase("Death Benefit", font));
		tableSection10.addCell(cell5);

		cell5.setPhrase(new Phrase("Issue Date", font));
		tableSection10.addCell(cell5);
		if (section10s.size() == 0) {
			document.add(tableSection10);
			document.add(redText);
		} else {
			for (Section10 section10 : section10s) {
				cella.setPhrase(new Phrase(section10.getPname().replaceAll("\"", ""), f));
				tableSection10.addCell(cella);
				cella.setPhrase(new Phrase(section10.getBpname().replaceAll("\"", ""), f));
				tableSection10.addCell(cella);
				cella.setPhrase(new Phrase(section10.getCoverage().replaceAll("\"", ""), f));
				tableSection10.addCell(cella);
				cella.setPhrase(new Phrase(section10.getDeath().replaceAll("\"", ""), f));
				tableSection10.addCell(cella);
				cella.setPhrase(new Phrase(section10.getIssuedate().replaceAll("\"", ""), f));
				tableSection10.addCell(cella);
			}

			document.add(tableSection10);
		}
		/** end **/

		/** Section 11 **/
		PdfPTable tableSection11 = new PdfPTable(4);
		List<Section11> section11s = (List<Section11>) model.get("section11");
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("4 - Pensions Death Benefit", fontTitle));
		tableSection11.setWidthPercentage(100.0f);
		tableSection11.setSpacingBefore(10);

		// define table header cell
		PdfPCell cell6 = new PdfPCell();
		cell6.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell6.setPadding(5);
		cell6.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell6.setPhrase(new Phrase("Pension", font));
		tableSection11.addCell(cell6);

		cell6.setPhrase(new Phrase("Terms of Pension", font));
		tableSection11.addCell(cell6);

		cell6.setPhrase(new Phrase("Death Benefit", font));
		tableSection11.addCell(cell6);

		cell6.setPhrase(new Phrase("Term/Period", font));
		tableSection11.addCell(cell6);
		if (section11s.size() == 0) {
			document.add(tableSection11);
			document.add(redText);
		} else {
			for (Section11 section11 : section11s) {
				cella.setPhrase(new Phrase(section11.getPensionSource().replaceAll("\"", ""), f));
				tableSection11.addCell(cella);
				cella.setPhrase(new Phrase(section11.getPensionTerms().replaceAll("\"", ""), f));
				tableSection11.addCell(cella);
				cella.setPhrase(new Phrase(section11.getDeathTerms().replaceAll("\"", ""), f));
				tableSection11.addCell(cella);
				cella.setPhrase(new Phrase(section11.getTermsOfPeriod().replaceAll("\"", ""), f));
				tableSection11.addCell(cella);
			}

			document.add(tableSection11);
		}
		/** end **/

		PdfPTable tablePage = new PdfPTable(1);
		tablePage.setWidthPercentage(100.0f);
		tablePage.setSpacingBefore(10);

		PdfPTable tableFooter = new PdfPTable(1);
		tableFooter.setWidthPercentage(100.0f);
		tableFooter.setSpacingBefore(10);

		PdfPCell cellPage = new PdfPCell();
		cellPage.setPhrase(new Phrase("	-- page 4 --  ", FontFactory.getFont(FontFactory.COURIER, 10)));
		cellPage.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellPage.setBorder(Rectangle.NO_BORDER);
		tablePage.addCell(cellPage);
		document.add(tablePage);

		PdfPCell cellFooter = new PdfPCell();
		cellFooter.setPhrase(new Phrase(
				"	John Vyge, 2017. This document is not a legal document nor is it "
						+ "	designed to give any specific legal advice pertaining to any "
						+ "	specific circumstances. It is important that professional legal "
						+ "	and financial advice be obtained before acting upon any of the "
						+ "	information contained in this document. Unauthorized use and/or "
						+ "	duplication of this material without express and written "
						+ "	permission from the author and/or owner is strictly prohibited."
						+ "	You are authorized to print out this document for your own "
						+ "	personal use only. Excerpts and links may be used, provided that "
						+ "	full and clear credit is given to John Vyge and with appropriate "
						+ "	and specific direction to the original content.",
				FontFactory.getFont(FontFactory.COURIER, 7)));
		cellFooter.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellFooter.setBorder(Rectangle.NO_BORDER);
		tableFooter.addCell(cellFooter);
		document.add(tableFooter);
	}

	@Override
	protected void buildPage5PdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// change the file name
		PdfPCell cella = new PdfPCell();
		cella.setBorderColor(BaseColor.LIGHT_GRAY);
		Font f = FontFactory.getFont(FontFactory.TIMES, 11);
		Image img = Image.getInstance(IMG1);
		document.add(img);
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setColor(BaseColor.BLUE);
		List<Section12> section12s = (List<Section12>) model.get("section12");
		document.add(new Paragraph(
				"              							                                                  for: "
						+ request.getParameter("client").replaceAll("_", " ")
						+ "              					           printed:" + LocalDate.now()));
		document.add(new Paragraph(""));
		Font bold = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
		document.add(new Paragraph("LOCATION OF IMPORTANT ITEMS", bold));
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("Important Items", fontTitle));
		PdfPTable tableSection12 = new PdfPTable(3);
		tableSection12.setWidthPercentage(100.0f);
		tableSection12.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(BaseColor.BLACK);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setPadding(5);
		cell.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell.setPhrase(new Phrase("Description", font));
		tableSection12.addCell(cell);

		cell.setPhrase(new Phrase("Notes", font));
		tableSection12.addCell(cell);

		cell.setPhrase(new Phrase("Location", font));
		tableSection12.addCell(cell);
		Font red = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
		Paragraph redText = new Paragraph("You have not provided any information for this section. ", red);

		if (section12s.size() == 0) {
			document.add(tableSection12);
			document.add(redText);
		} else {
			for (Section12 section12 : section12s) {
				cella.setPhrase(new Phrase(section12.getDesc().replaceAll("\"", ""), f));
				tableSection12.addCell(cella);
				cella.setPhrase(new Phrase(section12.getNotes().replaceAll("\"", ""), f));
				tableSection12.addCell(cella);
				cella.setPhrase(new Phrase(section12.getLocation().replaceAll("\"", ""), f));
				tableSection12.addCell(cella);
			}

			document.add(tableSection12);
		}
		/** Section 13 **/

		List<Section13> section13s = (List<Section13>) model.get("section13");
		document.add(new Paragraph(""));
		document.add(new Paragraph("OUR INSURANCE", bold));
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("Insurance Contacts", fontTitle));
		PdfPTable tableSection13 = new PdfPTable(4);
		tableSection13.setWidthPercentage(100.0f);
		tableSection13.setSpacingBefore(10);

		// define table header cell
		PdfPCell cell13 = new PdfPCell();
		cell13.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell13.setPadding(5);
		cell13.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell13.setPhrase(new Phrase("Policies", font));
		tableSection13.addCell(cell13);

		cell13.setPhrase(new Phrase("Company Name", font));
		tableSection13.addCell(cell13);

		cell13.setPhrase(new Phrase("Type of Coverage", font));
		tableSection13.addCell(cell13);

		cell13.setPhrase(new Phrase("Contact Phone Number", font));
		tableSection13.addCell(cell13);

		if (section13s.size() == 0) {
			document.add(tableSection13);
			document.add(redText);
		} else {
			for (Section13 section13 : section13s) {
				cella.setPhrase(new Phrase(section13.getPolicy().replaceAll("\"", ""), f));
				tableSection13.addCell(cella);
				cella.setPhrase(new Phrase(section13.getCname().replaceAll("\"", ""), f));
				tableSection13.addCell(cella);
				cella.setPhrase(new Phrase(section13.getTcoverage().replaceAll("\"", ""), f));
				tableSection13.addCell(cella);
				cella.setPhrase(new Phrase(section13.getContactp().replaceAll("\"", ""), f));
				tableSection13.addCell(cella);
			}

			document.add(tableSection13);
		}
		PdfPTable tablePage = new PdfPTable(1);
		tablePage.setWidthPercentage(100.0f);
		tablePage.setSpacingBefore(10);

		PdfPTable tableFooter = new PdfPTable(1);
		tableFooter.setWidthPercentage(100.0f);
		tableFooter.setSpacingBefore(10);

		PdfPCell cellPage = new PdfPCell();
		cellPage.setPhrase(new Phrase("	-- page 5 --  ", FontFactory.getFont(FontFactory.COURIER, 10)));
		cellPage.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellPage.setBorder(Rectangle.NO_BORDER);
		tablePage.addCell(cellPage);
		document.add(tablePage);

		PdfPCell cellFooter = new PdfPCell();
		cellFooter.setPhrase(new Phrase(
				"	John Vyge, 2017. This document is not a legal document nor is it "
						+ "	designed to give any specific legal advice pertaining to any "
						+ "	specific circumstances. It is important that professional legal "
						+ "	and financial advice be obtained before acting upon any of the "
						+ "	information contained in this document. Unauthorized use and/or "
						+ "	duplication of this material without express and written "
						+ "	permission from the author and/or owner is strictly prohibited."
						+ "	You are authorized to print out this document for your own "
						+ "	personal use only. Excerpts and links may be used, provided that "
						+ "	full and clear credit is given to John Vyge and with appropriate "
						+ "	and specific direction to the original content.",
				FontFactory.getFont(FontFactory.COURIER, 7)));
		cellFooter.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellFooter.setBorder(Rectangle.NO_BORDER);
		tableFooter.addCell(cellFooter);
		document.add(tableFooter);

	}

	@Override
	protected void buildPage6PdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		PdfPCell cella = new PdfPCell();
		cella.setBorderColor(BaseColor.LIGHT_GRAY);
		Font f = FontFactory.getFont(FontFactory.TIMES, 11);
		// change the file name
		Image img = Image.getInstance(IMG1);
		document.add(img);
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setColor(BaseColor.BLUE);
		List<Section14> section14s = (List<Section14>) model.get("section14");
		document.add(new Paragraph(
				"              							                                                  for: "
						+ request.getParameter("client").replaceAll("_", " ")
						+ "              					           printed:" + LocalDate.now()));
		document.add(new Paragraph(""));
		Font bold = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
		document.add(new Paragraph("ESTIMATED MONTHLY SURVIVAL INCOME", bold));
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("1 - Social Security Income", fontTitle));
		PdfPTable tableSection14 = new PdfPTable(4);
		tableSection14.setWidthPercentage(100.0f);
		tableSection14.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(BaseColor.BLACK);

		// define table header cell
		PdfPCell cell14 = new PdfPCell();
		cell14.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell14.setPadding(4);
		cell14.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell14.setPhrase(new Phrase("Survivor", font));
		tableSection14.addCell(cell14);

		cell14.setPhrase(new Phrase("Benefits cannot exceed...", font));
		tableSection14.addCell(cell14);

		cell14.setPhrase(new Phrase("Total", font));
		tableSection14.addCell(cell14);

		cell14.setPhrase(new Phrase("Maximum per Month", font));
		tableSection14.addCell(cell14);
		Font red = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
		Paragraph redText = new Paragraph("You have not provided any information for this section. ", red);

		if (section14s.size() == 0) {
			document.add(tableSection14);
			document.add(redText);
		} else {
			for (Section14 section14 : section14s) {
				cella.setPhrase(new Phrase(section14.getSurvivor().replaceAll("\"", ""), f));
				tableSection14.addCell(cella);
				cella.setPhrase(new Phrase(section14.getBenefits().replaceAll("\"", ""), f));
				tableSection14.addCell(cella);
				cella.setPhrase(new Phrase(section14.getTotal().replaceAll("\"", ""), f));
				tableSection14.addCell(cella);
				cella.setPhrase(new Phrase(section14.getMax().replaceAll("\"", ""), f));
				tableSection14.addCell(cella);
			}

			document.add(tableSection14);
		}
		/** Section 15 **/
		PdfPTable tableSection15 = new PdfPTable(4);
		List<Section15> section15s = (List<Section15>) model.get("section15");
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("2 - Pension Income", fontTitle));
		tableSection15.setWidthPercentage(100.0f);
		tableSection15.setSpacingBefore(10);

		// define table header cell
		PdfPCell cell15 = new PdfPCell();
		cell15.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell15.setPadding(4);
		cell15.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell15.setPhrase(new Phrase("Survivor", font));
		tableSection15.addCell(cell15);

		cell15.setPhrase(new Phrase("Benefits cannot exceed...", font));
		tableSection15.addCell(cell15);

		cell15.setPhrase(new Phrase("Total", font));
		tableSection15.addCell(cell15);

		cell15.setPhrase(new Phrase("Maximum per Month", font));
		tableSection15.addCell(cell15);

		if (section15s.size() == 0) {
			document.add(tableSection15);
			document.add(redText);
		} else {
			for (Section15 section15 : section15s) {
				cella.setPhrase(new Phrase(section15.getSurvivor().replaceAll("\"", ""), f));
				tableSection15.addCell(cella);
				cella.setPhrase(new Phrase(section15.getBenefits().replaceAll("\"", ""), f));
				tableSection15.addCell(cella);
				cella.setPhrase(new Phrase(section15.getTotal().replaceAll("\"", ""), f));
				tableSection15.addCell(cella);
				cella.setPhrase(new Phrase(section15.getMax().replaceAll("\"", ""), f));
				tableSection15.addCell(cella);
			}

			document.add(tableSection15);
		}
		/** Section 16 **/
		PdfPTable tableSection16 = new PdfPTable(4);
		List<Section16> section16s = (List<Section16>) model.get("section16");
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("3 - Investments", fontTitle));
		tableSection16.setWidthPercentage(100.0f);
		tableSection16.setSpacingBefore(10);

		// define table header cell
		PdfPCell cell16 = new PdfPCell();
		cell16.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell16.setPadding(4);
		cell16.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell16.setPhrase(new Phrase("Account Type", font));
		tableSection16.addCell(cell16);

		cell16.setPhrase(new Phrase("Account With", font));
		tableSection16.addCell(cell16);

		cell16.setPhrase(new Phrase("Total", font));
		tableSection16.addCell(cell16);

		cell16.setPhrase(new Phrase("Income per Year - 4%", font));
		tableSection16.addCell(cell16);
		if (section16s.size() == 0) {
			document.add(tableSection16);
			document.add(redText);
		} else {
			for (Section16 section16 : section16s) {
				cella.setPhrase(new Phrase(section16.getAcctname().replaceAll("\"", ""), f));
				tableSection16.addCell(cella);
				cella.setPhrase(new Phrase(section16.getAccttype().replaceAll("\"", ""), f));
				tableSection16.addCell(cella);
				cella.setPhrase(new Phrase(section16.getTotal().replaceAll("\"", ""), f));
				tableSection16.addCell(cella);
				cella.setPhrase(new Phrase(section16.getIpy().replaceAll("\"", ""), f));
				tableSection16.addCell(cella);
			}

			document.add(tableSection16);
		}
		/** Section 17 **/
		PdfPTable tableSection17 = new PdfPTable(4);
		List<Section17> section17s = (List<Section17>) model.get("section17");
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("4 - Passive Income Sources", fontTitle));
		tableSection17.setWidthPercentage(100.0f);
		tableSection17.setSpacingBefore(10);

		// define table header cell
		PdfPCell cell17 = new PdfPCell();
		cell17.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell17.setPadding(4);
		cell17.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell17.setPhrase(new Phrase("Account Type", font));
		tableSection17.addCell(cell17);

		cell17.setPhrase(new Phrase("Source", font));
		tableSection17.addCell(cell17);

		cell17.setPhrase(new Phrase("Value", font));
		tableSection17.addCell(cell17);

		cell17.setPhrase(new Phrase("Net Monthly Cashflow", font));
		tableSection17.addCell(cell17);

		if (section17s.size() == 0) {
			document.add(tableSection17);
			document.add(redText);
		} else {
			for (Section17 section17 : section17s) {
				cella.setPhrase(new Phrase(section17.getAccttype().replaceAll("\"", ""), f));
				tableSection17.addCell(cella);
				cella.setPhrase(new Phrase(section17.getAcctname().replaceAll("\"", ""), f));
				tableSection17.addCell(cella);
				cella.setPhrase(new Phrase(section17.getValue().replaceAll("\"", ""), f));
				tableSection17.addCell(cella);
				cella.setPhrase(new Phrase(section17.getCashflow().replaceAll("\"", ""), f));
				tableSection17.addCell(cella);
			}

			document.add(tableSection17);
		}
		PdfPTable tablePage = new PdfPTable(1);
		tablePage.setWidthPercentage(100.0f);
		tablePage.setSpacingBefore(10);

		PdfPTable tableFooter = new PdfPTable(1);
		tableFooter.setWidthPercentage(100.0f);
		tableFooter.setSpacingBefore(10);

		PdfPCell cellPage = new PdfPCell();
		cellPage.setPhrase(new Phrase("	-- page 6 --  ", FontFactory.getFont(FontFactory.COURIER, 10)));
		cellPage.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellPage.setBorder(Rectangle.NO_BORDER);
		tablePage.addCell(cellPage);
		document.add(tablePage);

		PdfPCell cellFooter = new PdfPCell();
		cellFooter.setPhrase(new Phrase(
				"	John Vyge, 2017. This document is not a legal document nor is it "
						+ "	designed to give any specific legal advice pertaining to any "
						+ "	specific circumstances. It is important that professional legal "
						+ "	and financial advice be obtained before acting upon any of the "
						+ "	information contained in this document. Unauthorized use and/or "
						+ "	duplication of this material without express and written "
						+ "	permission from the author and/or owner is strictly prohibited."
						+ "	You are authorized to print out this document for your own "
						+ "	personal use only. Excerpts and links may be used, provided that "
						+ "	full and clear credit is given to John Vyge and with appropriate "
						+ "	and specific direction to the original content.",
				FontFactory.getFont(FontFactory.COURIER, 7)));
		cellFooter.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellFooter.setBorder(Rectangle.NO_BORDER);
		tableFooter.addCell(cellFooter);
		document.add(tableFooter);
	}

	@Override
	protected void buildPage7PdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		PdfPCell cella = new PdfPCell();
		cella.setBorderColor(BaseColor.LIGHT_GRAY);
		Font f = FontFactory.getFont(FontFactory.TIMES, 11);
		// change the file name
		Image img = Image.getInstance(IMG1);
		document.add(img);
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setColor(BaseColor.BLUE);
		List<Section18> section18s = (List<Section18>) model.get("section18");
		document.add(new Paragraph(
				"              							                                                  for: "
						+ request.getParameter("client").replaceAll("_", " ")
						+ "              					           printed:" + LocalDate.now()));
		document.add(new Paragraph(""));
		Font bold = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
		document.add(new Paragraph("FINANCIAL OBLIGATIONS", bold));
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("1 - Money Owed", fontTitle));
		PdfPTable tableSection18 = new PdfPTable(5);
		tableSection18.setWidthPercentage(100.0f);
		tableSection18.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(BaseColor.BLACK);

		// define table header cell
		PdfPCell cell18 = new PdfPCell();
		cell18.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell18.setPadding(4);
		cell18.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell18.setPhrase(new Phrase("Type", font));
		tableSection18.addCell(cell18);

		cell18.setPhrase(new Phrase("Creditor", font));
		tableSection18.addCell(cell18);

		cell18.setPhrase(new Phrase("Total", font));
		tableSection18.addCell(cell18);

		cell18.setPhrase(new Phrase("Payment", font));
		tableSection18.addCell(cell18);

		cell18.setPhrase(new Phrase("Frequency", font));
		tableSection18.addCell(cell18);

		Font red = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
		Paragraph redText = new Paragraph("You have not provided any information for this section. ", red);

		if (section18s.size() == 0) {
			document.add(tableSection18);
			document.add(redText);
		} else {
			for (Section18 section18 : section18s) {
				cella.setPhrase(new Phrase(section18.getType().replaceAll("\"", ""), f));
				tableSection18.addCell(cella);
				cella.setPhrase(new Phrase(section18.getCreditor().replaceAll("\"", ""), f));
				tableSection18.addCell(cella);
				cella.setPhrase(new Phrase(section18.getTotal().replaceAll("\"", ""), f));
				tableSection18.addCell(cella);
				cella.setPhrase(new Phrase(section18.getPayment().replaceAll("\"", ""), f));
				tableSection18.addCell(cella);
				cella.setPhrase(new Phrase(section18.getFrequency().replaceAll("\"", ""), f));
				tableSection18.addCell(cella);
			}

			document.add(tableSection18);
		}
		/** Section 15 **/
		PdfPTable tableSection19 = new PdfPTable(5);
		List<Section19> section19s = (List<Section19>) model.get("section19");
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("2 - Money Owed to Me", fontTitle));
		tableSection19.setWidthPercentage(100.0f);
		tableSection19.setSpacingBefore(10);

		// define table header cell
		PdfPCell cell19 = new PdfPCell();
		cell19.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell19.setPadding(4);
		cell19.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell19.setPhrase(new Phrase("Type", font));
		tableSection19.addCell(cell19);

		cell19.setPhrase(new Phrase("Debitor", font));
		tableSection19.addCell(cell19);

		cell19.setPhrase(new Phrase("Total", font));
		tableSection19.addCell(cell19);

		cell19.setPhrase(new Phrase("Payment", font));
		tableSection19.addCell(cell19);

		cell19.setPhrase(new Phrase("Frequency", font));
		tableSection19.addCell(cell19);

		if (section19s.size() == 0) {
			document.add(tableSection19);
			document.add(redText);
		} else {
			for (Section19 section19 : section19s) {
				cella.setPhrase(new Phrase(section19.getType().replaceAll("\"", ""), f));
				tableSection19.addCell(cella);
				cella.setPhrase(new Phrase(section19.getDebitor().replaceAll("\"", ""), f));
				tableSection19.addCell(cella);
				cella.setPhrase(new Phrase(section19.getTotal().replaceAll("\"", ""), f));
				tableSection19.addCell(cella);
				cella.setPhrase(new Phrase(section19.getPayment().replaceAll("\"", ""), f));
				tableSection19.addCell(cella);
				cella.setPhrase(new Phrase(section19.getFrequency().replaceAll("\"", ""), f));
				tableSection19.addCell(cella);
			}
			document.add(tableSection19);
		}

		PdfPTable tablePage = new PdfPTable(1);
		tablePage.setWidthPercentage(100.0f);
		tablePage.setSpacingBefore(10);

		PdfPTable tableFooter = new PdfPTable(1);
		tableFooter.setWidthPercentage(100.0f);
		tableFooter.setSpacingBefore(10);

		PdfPCell cellPage = new PdfPCell();
		cellPage.setPhrase(new Phrase("	-- page 7 --  ", FontFactory.getFont(FontFactory.COURIER, 10)));
		cellPage.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellPage.setBorder(Rectangle.NO_BORDER);
		tablePage.addCell(cellPage);
		document.add(tablePage);

		PdfPCell cellFooter = new PdfPCell();
		cellFooter.setPhrase(new Phrase(
				"	John Vyge, 2017. This document is not a legal document nor is it "
						+ "	designed to give any specific legal advice pertaining to any "
						+ "	specific circumstances. It is important that professional legal "
						+ "	and financial advice be obtained before acting upon any of the "
						+ "	information contained in this document. Unauthorized use and/or "
						+ "	duplication of this material without express and written "
						+ "	permission from the author and/or owner is strictly prohibited."
						+ "	You are authorized to print out this document for your own "
						+ "	personal use only. Excerpts and links may be used, provided that "
						+ "	full and clear credit is given to John Vyge and with appropriate "
						+ "	and specific direction to the original content.",
				FontFactory.getFont(FontFactory.COURIER, 7)));
		cellFooter.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellFooter.setBorder(Rectangle.NO_BORDER);
		tableFooter.addCell(cellFooter);
		document.add(tableFooter);
	}

	@Override
	protected void buildPage8PdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// change the file name
		Font f = FontFactory.getFont(FontFactory.TIMES, 11);
		Image img = Image.getInstance(IMG1);
		document.add(img);
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setColor(BaseColor.BLUE);
		List<Section20> section20s = (List<Section20>) model.get("section20");
		document.add(new Paragraph(
				"              							                                                  for: "
						+ request.getParameter("client").replaceAll("_", " ")
						+ "              					           printed:" + LocalDate.now()));
		document.add(new Paragraph(""));
		Font bold = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
		document.add(new Paragraph("WRITTEN LAST WISHES", bold));
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("My Last Wishes", fontTitle));
		PdfPTable tableSection20 = new PdfPTable(1);
		tableSection20.setWidthPercentage(100.0f);
		tableSection20.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(BaseColor.BLACK);

		// define table header cell
		PdfPCell cell20 = new PdfPCell();
		cell20.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell20.setPadding(4);
		cell20.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell20.setPhrase(new Phrase("By " + request.getParameter("client").replaceAll("_", " "), font));
		tableSection20.addCell(cell20);
		PdfPCell cell20a = new PdfPCell();
		cell20a.setBorder(Rectangle.NO_BORDER);

		Font red = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
		Paragraph redText = new Paragraph("You have not provided any information for this section. ", red);

		if (section20s.size() == 0) {
			document.add(tableSection20);
			document.add(redText);
		} else {
			for (Section20 section20 : section20s) {
				cell20a.setPhrase(new Phrase(section20.getWill(), f));
				tableSection20.addCell(cell20a);
			}
		}
		PdfPCell cell20b = new PdfPCell();
		PdfPCell cell20c = new PdfPCell();
		PdfPCell cell20d = new PdfPCell();
		PdfPCell cell20e = new PdfPCell();
		cell20b.setBorder(Rectangle.NO_BORDER);
		cell20c.setBorder(Rectangle.NO_BORDER);
		cell20d.setBorder(Rectangle.NO_BORDER);
		cell20e.setBorder(Rectangle.NO_BORDER);
		cell20b.setPhrase(new Phrase("  "));
		cell20c.setPhrase(new Phrase("  "));
		cell20d.setPhrase(new Phrase("  "));
		cell20e.setPhrase(new Phrase("Signature: _____________________________________  Date: _________________"));
		tableSection20.addCell(cell20b);
		tableSection20.addCell(cell20c);
		tableSection20.addCell(cell20d);
		tableSection20.addCell(cell20e);

		document.add(tableSection20);

		PdfPTable tablePage = new PdfPTable(1);
		tablePage.setWidthPercentage(100.0f);
		tablePage.setSpacingBefore(10);

		PdfPTable tableFooter = new PdfPTable(1);
		tableFooter.setWidthPercentage(100.0f);
		tableFooter.setSpacingBefore(10);

		PdfPCell cellPage = new PdfPCell();
		cellPage.setPhrase(new Phrase("	-- page 8 --  ", FontFactory.getFont(FontFactory.COURIER, 10)));
		cellPage.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellPage.setBorder(Rectangle.NO_BORDER);
		tablePage.addCell(cellPage);
		document.add(tablePage);

		PdfPCell cellFooter = new PdfPCell();
		cellFooter.setPhrase(new Phrase(
				"	John Vyge, 2017. This document is not a legal document nor is it "
						+ "	designed to give any specific legal advice pertaining to any "
						+ "	specific circumstances. It is important that professional legal "
						+ "	and financial advice be obtained before acting upon any of the "
						+ "	information contained in this document. Unauthorized use and/or "
						+ "	duplication of this material without express and written "
						+ "	permission from the author and/or owner is strictly prohibited."
						+ "	You are authorized to print out this document for your own "
						+ "	personal use only. Excerpts and links may be used, provided that "
						+ "	full and clear credit is given to John Vyge and with appropriate "
						+ "	and specific direction to the original content.",
				FontFactory.getFont(FontFactory.COURIER, 7)));
		cellFooter.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellFooter.setBorder(Rectangle.NO_BORDER);
		tableFooter.addCell(cellFooter);
		document.add(tableFooter);
	}

	@Override
	protected void buildPage9PdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// change the file name
		Font f = FontFactory.getFont(FontFactory.TIMES, 11);
		response.setHeader("Content-Disposition",
				"attachment; filename=\"letter_of_last_instructions_" + request.getParameter("client") + ".pdf\"");
		Image img = Image.getInstance(IMG1);
		document.add(img);
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setColor(BaseColor.BLUE);
		List<Section21> section21s = (List<Section21>) model.get("section21");
		document.add(new Paragraph(
				"              							                                                  for: "
						+ request.getParameter("client").replaceAll("_", " ")
						+ "              					           printed:" + LocalDate.now()));
		document.add(new Paragraph(""));
		Font bold = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
		document.add(new Paragraph("ADDITIONAL INSTRUCTIONS", bold));
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("Important Notes", fontTitle));
		PdfPTable tableSection21 = new PdfPTable(1);
		tableSection21.setWidthPercentage(100.0f);
		tableSection21.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(BaseColor.BLACK);

		// define table header cell
		PdfPCell cell21 = new PdfPCell();
		cell21.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell21.setPadding(4);
		cell21.setBorderColor(BaseColor.LIGHT_GRAY);

		// write table header
		cell21.setPhrase(new Phrase("By " + request.getParameter("client").replaceAll("_", " "), font));
		tableSection21.addCell(cell21);
		PdfPCell cell21a = new PdfPCell();
		cell21a.setBorder(Rectangle.NO_BORDER);
		Font red = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
		Paragraph redText = new Paragraph("You have not provided any information for this section. ", red);

		if (section21s.size() == 0) {
			document.add(tableSection21);
			document.add(redText);
		} else {
			for (Section21 section21 : section21s) {
				cell21a.setPhrase(new Phrase(section21.getAdditionalInstructions(), f));
				tableSection21.addCell(cell21a);
			}
		}
		PdfPCell cell21b = new PdfPCell();
		PdfPCell cell21c = new PdfPCell();
		PdfPCell cell21d = new PdfPCell();
		PdfPCell cell21e = new PdfPCell();
		cell21b.setBorder(Rectangle.NO_BORDER);
		cell21c.setBorder(Rectangle.NO_BORDER);
		cell21d.setBorder(Rectangle.NO_BORDER);
		cell21e.setBorder(Rectangle.NO_BORDER);
		cell21b.setPhrase(new Phrase("  "));
		cell21c.setPhrase(new Phrase("  "));
		cell21d.setPhrase(new Phrase("  "));
		cell21e.setPhrase(new Phrase("Signature: _____________________________________  Date: _________________"));
		tableSection21.addCell(cell21b);
		tableSection21.addCell(cell21c);
		tableSection21.addCell(cell21d);
		tableSection21.addCell(cell21e);

		document.add(tableSection21);

		PdfPTable tablePage = new PdfPTable(1);
		tablePage.setWidthPercentage(100.0f);
		tablePage.setSpacingBefore(10);

		PdfPTable tableFooter = new PdfPTable(1);
		tableFooter.setWidthPercentage(100.0f);
		tableFooter.setSpacingBefore(10);

		PdfPCell cellPage = new PdfPCell();
		cellPage.setPhrase(new Phrase("	-- page 8 --  ", FontFactory.getFont(FontFactory.COURIER, 10)));
		cellPage.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellPage.setBorder(Rectangle.NO_BORDER);
		tablePage.addCell(cellPage);
		document.add(tablePage);

		PdfPCell cellFooter = new PdfPCell();
		cellFooter.setPhrase(new Phrase(
				"	John Vyge, 2017. This document is not a legal document nor is it "
						+ "	designed to give any specific legal advice pertaining to any "
						+ "	specific circumstances. It is important that professional legal "
						+ "	and financial advice be obtained before acting upon any of the "
						+ "	information contained in this document. Unauthorized use and/or "
						+ "	duplication of this material without express and written "
						+ "	permission from the author and/or owner is strictly prohibited."
						+ "	You are authorized to print out this document for your own "
						+ "	personal use only. Excerpts and links may be used, provided that "
						+ "	full and clear credit is given to John Vyge and with appropriate "
						+ "	and specific direction to the original content.",
				FontFactory.getFont(FontFactory.COURIER, 7)));
		cellFooter.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellFooter.setBorder(Rectangle.NO_BORDER);
		tableFooter.addCell(cellFooter);
		document.add(tableFooter);
	}
}

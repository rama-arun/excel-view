package me.aboullaite.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

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

/**
 * Created by aboullaite on 2017-02-23.
 */
public class ExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// change the file name
		response.setHeader("Content-Disposition",
				"attachment; filename=\"letter_of_last_instructions_" + request.getParameter("client") + ".xls\"");

		@SuppressWarnings("unchecked")
		List<Section1> section1s = (List<Section1>) model.get("section1");

		// create excel xls sheet
		Sheet sheet = workbook.createSheet("LoLI");
		sheet.setDefaultColumnWidth(30);

		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		CellStyle style1 = workbook.createCellStyle();
		CellStyle style2 = workbook.createCellStyle();
		CellStyle style3 = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		Font font1 = workbook.createFont();
		font1.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style1.setFillForegroundColor(HSSFColor.BLACK.index);
		style2.setFillForegroundColor(HSSFColor.BROWN.index);
		style3.setFillForegroundColor(HSSFColor.WHITE.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font.setBold(true);
		font.setColor(HSSFColor.WHITE.index);
		font1.setBold(true);
		font1.setColor(HSSFColor.RED.index);
		style.setFont(font);
		style1.setFont(font);
		style2.setFont(font);
		style3.setFont(font1);
		
		int rowCount = 1;

		// create header row
		Row headerPage1 = sheet.createRow(0);
		headerPage1.createCell(0).setCellValue("TO DO LIST");
		headerPage1.getCell(0).setCellStyle(style1);
		Row headerSection1 = sheet.createRow(rowCount++);
		headerSection1.createCell(0).setCellValue("When to do");
		headerSection1.getCell(0).setCellStyle(style);
		headerSection1.createCell(1).setCellValue("What to do");
		headerSection1.getCell(1).setCellStyle(style);

		if (section1s.size() == 0) {
			Row userRow = sheet.createRow(rowCount);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
			rowCount++;
		} else {
			for (Section1 section1 : section1s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section1.getKey());
				userRow.createCell(1).setCellValue(section1.getValue());
			}
		}

		@SuppressWarnings("unchecked")
		List<Section2> section2s = (List<Section2>) model.get("section2");
		
		// create header row
		Row headerPage2 = sheet.createRow(rowCount++);
		headerPage2.createCell(0).setCellValue("WHO TO NOTIFY");
		headerPage2.getCell(0).setCellStyle(style1);
		Row headerSubHeader1 = sheet.createRow(rowCount++);
		headerSubHeader1.createCell(0).setCellValue("Immediate Family & Friends");
		headerSubHeader1.getCell(0).setCellStyle(style2);
		Row headerSection2 = sheet.createRow(rowCount++);
		headerSection2.createCell(0).setCellValue("Name");
		headerSection2.getCell(0).setCellStyle(style);
		headerSection2.createCell(1).setCellValue("Relationship");
		headerSection2.getCell(1).setCellStyle(style);
		headerSection2.createCell(2).setCellValue("City");
		headerSection2.getCell(2).setCellStyle(style);
		headerSection2.createCell(3).setCellValue("Email");
		headerSection2.getCell(3).setCellStyle(style);
		headerSection2.createCell(4).setCellValue("Phone");
		headerSection2.getCell(4).setCellStyle(style);

		if (section2s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section2 section2 : section2s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section2.getName());
				userRow.createCell(1).setCellValue(section2.getRelationship());
				userRow.createCell(2).setCellValue(section2.getCity());
				userRow.createCell(3).setCellValue(section2.getEmail());
				userRow.createCell(4).setCellValue(section2.getPhone());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section3> section3s = (List<Section3>) model.get("section3");
		
		Row headerSubHeader2 = sheet.createRow(rowCount++);
		headerSubHeader2.createCell(0).setCellValue("Funeral Home");
		headerSubHeader2.getCell(0).setCellStyle(style2);
		Row headerSection3 = sheet.createRow(rowCount++);
		headerSection3.createCell(0).setCellValue("Name");
		headerSection3.getCell(0).setCellStyle(style);
		headerSection3.createCell(1).setCellValue("Relationship");
		headerSection3.getCell(1).setCellStyle(style);
		headerSection3.createCell(2).setCellValue("City");
		headerSection3.getCell(2).setCellStyle(style);
		headerSection3.createCell(3).setCellValue("Email");
		headerSection3.getCell(3).setCellStyle(style);
		headerSection3.createCell(4).setCellValue("Phone");
		headerSection3.getCell(4).setCellStyle(style);

		if (section3s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section3 section3 : section3s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section3.getName());
				userRow.createCell(1).setCellValue(section3.getRelationship());
				userRow.createCell(2).setCellValue(section3.getCity());
				userRow.createCell(3).setCellValue(section3.getEmail());
				userRow.createCell(4).setCellValue(section3.getPhone());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section4> section4s = (List<Section4>) model.get("section4");
		
		Row headerSubHeader3 = sheet.createRow(rowCount++);
		headerSubHeader3.createCell(0).setCellValue("Professional Advisors");
		headerSubHeader3.getCell(0).setCellStyle(style2);
		Row headerSection4 = sheet.createRow(rowCount++);
		headerSection4.createCell(0).setCellValue("Name");
		headerSection4.getCell(0).setCellStyle(style);
		headerSection4.createCell(1).setCellValue("Relationship");
		headerSection4.getCell(1).setCellStyle(style);
		headerSection4.createCell(2).setCellValue("City");
		headerSection4.getCell(2).setCellStyle(style);
		headerSection4.createCell(3).setCellValue("Email");
		headerSection4.getCell(3).setCellStyle(style);
		headerSection4.createCell(4).setCellValue("Phone");
		headerSection4.getCell(4).setCellStyle(style);

		if (section4s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section4 section4 : section4s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section4.getName());
				userRow.createCell(1).setCellValue(section4.getRelationship());
				userRow.createCell(2).setCellValue(section4.getCity());
				userRow.createCell(3).setCellValue(section4.getEmail());
				userRow.createCell(4).setCellValue(section4.getPhone());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section5> section5s = (List<Section5>) model.get("section5");
		
		Row headerSubHeader4 = sheet.createRow(rowCount++);
		headerSubHeader4.createCell(0).setCellValue("Medical Contacts");
		headerSubHeader4.getCell(0).setCellStyle(style2);
		Row headerSection5 = sheet.createRow(rowCount++);
		headerSection5.createCell(0).setCellValue("Name");
		headerSection5.getCell(0).setCellStyle(style);
		headerSection5.createCell(1).setCellValue("Relationship");
		headerSection5.getCell(1).setCellStyle(style);
		headerSection5.createCell(2).setCellValue("City");
		headerSection5.getCell(2).setCellStyle(style);
		headerSection5.createCell(3).setCellValue("Email");
		headerSection5.getCell(3).setCellStyle(style);
		headerSection5.createCell(4).setCellValue("Phone");
		headerSection5.getCell(4).setCellStyle(style);

		if (section5s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section5 section5 : section5s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section5.getName());
				userRow.createCell(1).setCellValue(section5.getRelationship());
				userRow.createCell(2).setCellValue(section5.getCity());
				userRow.createCell(3).setCellValue(section5.getEmail());
				userRow.createCell(4).setCellValue(section5.getPhone());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section6> section6s = (List<Section6>) model.get("section6");
		
		Row headerSubHeader5 = sheet.createRow(rowCount++);
		headerSubHeader5.createCell(0).setCellValue("Insurance Contacts");
		headerSubHeader5.getCell(0).setCellStyle(style2);
		Row headerSection6 = sheet.createRow(rowCount++);
		headerSection6.createCell(0).setCellValue("Name");
		headerSection6.getCell(0).setCellStyle(style);
		headerSection6.createCell(1).setCellValue("Relationship");
		headerSection6.getCell(1).setCellStyle(style);
		headerSection6.createCell(2).setCellValue("City");
		headerSection6.getCell(2).setCellStyle(style);
		headerSection6.createCell(3).setCellValue("Email");
		headerSection6.getCell(3).setCellStyle(style);
		headerSection6.createCell(4).setCellValue("Phone");
		headerSection6.getCell(4).setCellStyle(style);

		if (section6s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section6 section6 : section6s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section6.getName());
				userRow.createCell(1).setCellValue(section6.getRelationship());
				userRow.createCell(2).setCellValue(section6.getCity());
				userRow.createCell(3).setCellValue(section6.getEmail());
				userRow.createCell(4).setCellValue(section6.getPhone());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section7> section7s = (List<Section7>) model.get("section7");
		
		Row headerPage3 = sheet.createRow(rowCount++);
		headerPage3.createCell(0).setCellValue("WHERE TO GET CASH NOW");
		headerPage3.getCell(0).setCellStyle(style1);
		Row headerSubHeader6 = sheet.createRow(rowCount++);
		headerSubHeader6.createCell(0).setCellValue("Our Family Budget");
		headerSubHeader6.getCell(0).setCellStyle(style2);
		Row headerSection7 = sheet.createRow(rowCount++);
		headerSection7.createCell(0).setCellValue("Which Account");
		headerSection7.getCell(0).setCellStyle(style);
		headerSection7.createCell(1).setCellValue("Type of Expense");
		headerSection7.getCell(1).setCellStyle(style);
		headerSection7.createCell(2).setCellValue("Amount");
		headerSection7.getCell(2).setCellStyle(style);

		if (section7s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section7 section7 : section7s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section7.getAccount());
				userRow.createCell(1).setCellValue(section7.getExpense());
				userRow.createCell(2).setCellValue(section7.getAmount());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section8> section8s = (List<Section8>) model.get("section8");
		
		Row headerSubHeader7 = sheet.createRow(rowCount++);
		headerSubHeader7.createCell(0).setCellValue("1 - Bank Accounts");
		headerSubHeader7.getCell(0).setCellStyle(style2);
		Row headerSection8 = sheet.createRow(rowCount++);
		headerSection8.createCell(0).setCellValue("Bank");
		headerSection8.getCell(0).setCellStyle(style);
		headerSection8.createCell(1).setCellValue("Account Number");
		headerSection8.getCell(1).setCellStyle(style);
		headerSection8.createCell(2).setCellValue("Balance");
		headerSection8.getCell(2).setCellStyle(style);

		if (section8s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section8 section8 : section8s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section8.getBank());
				userRow.createCell(1).setCellValue(section8.getAccountnum());
				userRow.createCell(2).setCellValue(section8.getBalance());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section9> section9s = (List<Section9>) model.get("section9");
		
		Row headerSubHeader8 = sheet.createRow(rowCount++);
		headerSubHeader8.createCell(0).setCellValue("2 - Life Insurance");
		headerSubHeader8.getCell(0).setCellStyle(style2);
		Row headerSection9 = sheet.createRow(rowCount++);
		headerSection9.createCell(0).setCellValue("Policies");
		headerSection9.getCell(0).setCellStyle(style);
		headerSection9.createCell(1).setCellValue("Base Plan Name");
		headerSection9.getCell(1).setCellStyle(style);
		headerSection9.createCell(2).setCellValue("Type of Coverage");
		headerSection9.getCell(2).setCellStyle(style);
		headerSection9.createCell(3).setCellValue("Death Benefit");
		headerSection9.getCell(3).setCellStyle(style);
		headerSection9.createCell(4).setCellValue("Issue Date");
		headerSection9.getCell(4).setCellStyle(style);

		if (section9s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section9 section9 : section9s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section9.getPname());
				userRow.createCell(1).setCellValue(section9.getBpname());
				userRow.createCell(2).setCellValue(section9.getCoverage());
				userRow.createCell(3).setCellValue(section9.getDeath());
				userRow.createCell(4).setCellValue(section9.getIssuedate());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section10> section10s = (List<Section10>) model.get("section10");
		
		Row headerSubHeader10 = sheet.createRow(rowCount++);
		headerSubHeader10.createCell(0).setCellValue("3 - Critical Care Insurance");
		headerSubHeader10.getCell(0).setCellStyle(style2);
		Row headerSection10 = sheet.createRow(rowCount++);
		headerSection10.createCell(0).setCellValue("Policies");
		headerSection10.getCell(0).setCellStyle(style);
		headerSection10.createCell(1).setCellValue("Base Plan Name");
		headerSection10.getCell(1).setCellStyle(style);
		headerSection10.createCell(2).setCellValue("Type of Coverage");
		headerSection10.getCell(2).setCellStyle(style);
		headerSection10.createCell(3).setCellValue("Death Benefit");
		headerSection10.getCell(3).setCellStyle(style);
		headerSection10.createCell(4).setCellValue("Issue Date");
		headerSection10.getCell(4).setCellStyle(style);

		if (section10s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section10 section10 : section10s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section10.getPname());
				userRow.createCell(1).setCellValue(section10.getBpname());
				userRow.createCell(2).setCellValue(section10.getCoverage());
				userRow.createCell(3).setCellValue(section10.getDeath());
				userRow.createCell(4).setCellValue(section10.getIssuedate());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section11> section11s = (List<Section11>) model.get("section11");
		
		Row headerSubHeader11 = sheet.createRow(rowCount++);
		headerSubHeader11.createCell(0).setCellValue("4 - Pensions Death Benefit");
		headerSubHeader11.getCell(0).setCellStyle(style2);
		Row headerSection11 = sheet.createRow(rowCount++);
		headerSection11.createCell(0).setCellValue("Pension");
		headerSection11.getCell(0).setCellStyle(style);
		headerSection11.createCell(1).setCellValue("Terms of Pension");
		headerSection11.getCell(1).setCellStyle(style);
		headerSection11.createCell(2).setCellValue("Death Benefit");
		headerSection11.getCell(2).setCellStyle(style);
		headerSection11.createCell(3).setCellValue("Term/Period");
		headerSection11.getCell(3).setCellStyle(style);

		if (section11s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section11 section11 : section11s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section11.getPensionSource());
				userRow.createCell(1).setCellValue(section11.getPensionTerms());
				userRow.createCell(2).setCellValue(section11.getDeathTerms());
				userRow.createCell(3).setCellValue(section11.getTermsOfPeriod());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section12> section12s = (List<Section12>) model.get("section12");
		
		Row headerPage4 = sheet.createRow(rowCount++);
		headerPage4.createCell(0).setCellValue("LOCATION OF IMPORTANT ITEMS");
		headerPage4.getCell(0).setCellStyle(style1);
		Row headerSubHeader12 = sheet.createRow(rowCount++);
		headerSubHeader12.createCell(0).setCellValue("Important Items");
		headerSubHeader12.getCell(0).setCellStyle(style2);
		Row headerSection12 = sheet.createRow(rowCount++);
		headerSection12.createCell(0).setCellValue("Description");
		headerSection12.getCell(0).setCellStyle(style);
		headerSection12.createCell(1).setCellValue("Notes");
		headerSection12.getCell(1).setCellStyle(style);
		headerSection12.createCell(2).setCellValue("Location");
		headerSection12.getCell(2).setCellStyle(style);

		if (section12s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section12 section12 : section12s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section12.getDesc());
				userRow.createCell(1).setCellValue(section12.getNotes());
				userRow.createCell(2).setCellValue(section12.getLocation());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section13> section13s = (List<Section13>) model.get("section13");
		
		Row headerPage5 = sheet.createRow(rowCount++);
		headerPage5.createCell(0).setCellValue("OUR INSURANCE");
		headerPage5.getCell(0).setCellStyle(style1);
		Row headerSubHeader13 = sheet.createRow(rowCount++);
		headerSubHeader13.createCell(0).setCellValue("Insurance Contacts");
		headerSubHeader13.getCell(0).setCellStyle(style2);
		Row headerSection13 = sheet.createRow(rowCount++);
		headerSection13.createCell(0).setCellValue("Policies");
		headerSection13.getCell(0).setCellStyle(style);
		headerSection13.createCell(1).setCellValue("Company Name");
		headerSection13.getCell(1).setCellStyle(style);
		headerSection13.createCell(2).setCellValue("Type of Coverage");
		headerSection13.getCell(2).setCellStyle(style);
		headerSection13.createCell(3).setCellValue("Contact Phone Number");
		headerSection13.getCell(3).setCellStyle(style);

		if (section13s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section13 section13 : section13s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section13.getPolicy());
				userRow.createCell(1).setCellValue(section13.getCname());
				userRow.createCell(2).setCellValue(section13.getTcoverage());
				userRow.createCell(3).setCellValue(section13.getContactp());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section14> section14s = (List<Section14>) model.get("section14");
		
		Row headerPage6 = sheet.createRow(rowCount++);
		headerPage6.createCell(0).setCellValue("ESTIMATED MONTHLY SURVIVAL INCOME");
		headerPage6.getCell(0).setCellStyle(style1);
		Row headerSubHeader14 = sheet.createRow(rowCount++);
		headerSubHeader14.createCell(0).setCellValue("1 - Social Security Income");
		headerSubHeader14.getCell(0).setCellStyle(style2);
		Row headerSection14 = sheet.createRow(rowCount++);
		headerSection14.createCell(0).setCellValue("Survivor");
		headerSection14.getCell(0).setCellStyle(style);
		headerSection14.createCell(1).setCellValue("Benefits cannot exceed...");
		headerSection14.getCell(1).setCellStyle(style);
		headerSection14.createCell(2).setCellValue("Total");
		headerSection14.getCell(2).setCellStyle(style);
		headerSection14.createCell(3).setCellValue("Maximum per Month");
		headerSection14.getCell(3).setCellStyle(style);

		if (section14s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section14 section14 : section14s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section14.getSurvivor());
				userRow.createCell(1).setCellValue(section14.getBenefits());
				userRow.createCell(2).setCellValue(section14.getTotal());
				userRow.createCell(3).setCellValue(section14.getMax());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section15> section15s = (List<Section15>) model.get("section15");
		
		Row headerSubHeader15 = sheet.createRow(rowCount++);
		headerSubHeader15.createCell(0).setCellValue("2 - Pension Income");
		headerSubHeader15.getCell(0).setCellStyle(style2);
		Row headerSection15 = sheet.createRow(rowCount++);
		headerSection15.createCell(0).setCellValue("Survivor");
		headerSection15.getCell(0).setCellStyle(style);
		headerSection15.createCell(1).setCellValue("Benefits cannot exceed...");
		headerSection15.getCell(1).setCellStyle(style);
		headerSection15.createCell(2).setCellValue("Total");
		headerSection15.getCell(2).setCellStyle(style);
		headerSection15.createCell(3).setCellValue("Maximum per Month");
		headerSection15.getCell(3).setCellStyle(style);

		if (section15s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section15 section15 : section15s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section15.getSurvivor());
				userRow.createCell(1).setCellValue(section15.getBenefits());
				userRow.createCell(2).setCellValue(section15.getTotal());
				userRow.createCell(3).setCellValue(section15.getMax());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section16> section16s = (List<Section16>) model.get("section16");
		
		Row headerSubHeader16 = sheet.createRow(rowCount++);
		headerSubHeader16.createCell(0).setCellValue("3 - Investments");
		headerSubHeader16.getCell(0).setCellStyle(style2);
		Row headerSection16 = sheet.createRow(rowCount++);
		headerSection16.createCell(0).setCellValue("Account Type");
		headerSection16.getCell(0).setCellStyle(style);
		headerSection16.createCell(1).setCellValue("Account with");
		headerSection16.getCell(1).setCellStyle(style);
		headerSection16.createCell(2).setCellValue("Total");
		headerSection16.getCell(2).setCellStyle(style);
		headerSection16.createCell(3).setCellValue("Income per Year - 4%");
		headerSection16.getCell(3).setCellStyle(style);

		if (section16s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section16 section16 : section16s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section16.getAccttype());
				userRow.createCell(1).setCellValue(section16.getAcctname());
				userRow.createCell(2).setCellValue(section16.getTotal());
				userRow.createCell(3).setCellValue(section16.getIpy());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section17> section17s = (List<Section17>) model.get("section17");
		
		Row headerSubHeader17 = sheet.createRow(rowCount++);
		headerSubHeader17.createCell(0).setCellValue("4 - Passive Income Sources");
		headerSubHeader17.getCell(0).setCellStyle(style2);
		Row headerSection17 = sheet.createRow(rowCount++);
		headerSection17.createCell(0).setCellValue("Account Type");
		headerSection17.getCell(0).setCellStyle(style);
		headerSection17.createCell(1).setCellValue("Account with");
		headerSection17.getCell(1).setCellStyle(style);
		headerSection17.createCell(2).setCellValue("Value");
		headerSection17.getCell(2).setCellStyle(style);
		headerSection17.createCell(3).setCellValue("Net Monthly Cashflow");
		headerSection17.getCell(3).setCellStyle(style);

		if (section17s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section17 section17 : section17s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section17.getAccttype());
				userRow.createCell(1).setCellValue(section17.getAcctname());
				userRow.createCell(2).setCellValue(section17.getValue());
				userRow.createCell(3).setCellValue(section17.getCashflow());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section18> section18s = (List<Section18>) model.get("section18");
		
		Row headerPage8 = sheet.createRow(rowCount++);
		headerPage8.createCell(0).setCellValue("FINANCIAL OBLIGATIONS");
		headerPage8.getCell(0).setCellStyle(style1);
		Row headerSubHeader18 = sheet.createRow(rowCount++);
		headerSubHeader18.createCell(0).setCellValue("1 - Money Owed");
		headerSubHeader18.getCell(0).setCellStyle(style2);
		Row headerSection18 = sheet.createRow(rowCount++);
		headerSection18.createCell(0).setCellValue("Type");
		headerSection18.getCell(0).setCellStyle(style);
		headerSection18.createCell(1).setCellValue("Creditor");
		headerSection18.getCell(1).setCellStyle(style);
		headerSection18.createCell(2).setCellValue("Total");
		headerSection18.getCell(2).setCellStyle(style);
		headerSection18.createCell(3).setCellValue("Payment");
		headerSection18.getCell(3).setCellStyle(style);
		headerSection18.createCell(4).setCellValue("Frequency");
		headerSection18.getCell(4).setCellStyle(style);

		if (section18s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section18 section18 : section18s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section18.getType());
				userRow.createCell(1).setCellValue(section18.getCreditor());
				userRow.createCell(2).setCellValue(section18.getTotal());
				userRow.createCell(3).setCellValue(section18.getPayment());
				userRow.createCell(4).setCellValue(section18.getFrequency());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section19> section19s = (List<Section19>) model.get("section19");
		
		Row headerSubHeader19 = sheet.createRow(rowCount++);
		headerSubHeader19.createCell(0).setCellValue("2 - Money Owed to me");
		headerSubHeader19.getCell(0).setCellStyle(style2);
		Row headerSection19 = sheet.createRow(rowCount++);
		headerSection19.createCell(0).setCellValue("Type");
		headerSection19.getCell(0).setCellStyle(style);
		headerSection19.createCell(1).setCellValue("Debitor");
		headerSection19.getCell(1).setCellStyle(style);
		headerSection19.createCell(2).setCellValue("Total");
		headerSection19.getCell(2).setCellStyle(style);
		headerSection19.createCell(3).setCellValue("Payment");
		headerSection19.getCell(3).setCellStyle(style);
		headerSection19.createCell(4).setCellValue("Frequency");
		headerSection19.getCell(4).setCellStyle(style);

		if (section19s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section19 section19 : section19s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section19.getType());
				userRow.createCell(1).setCellValue(section19.getDebitor());
				userRow.createCell(2).setCellValue(section19.getTotal());
				userRow.createCell(3).setCellValue(section19.getPayment());
				userRow.createCell(4).setCellValue(section19.getFrequency());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section20> section20s = (List<Section20>) model.get("section20");
		
		Row headerPage9 = sheet.createRow(rowCount++);
		headerPage9.createCell(0).setCellValue("WRITTEN LAST WISHES");
		headerPage9.getCell(0).setCellStyle(style1);
		Row headerSubHeader20 = sheet.createRow(rowCount++);
		headerSubHeader20.createCell(0).setCellValue("My Last Wishes");
		headerSubHeader20.getCell(0).setCellStyle(style2);

		if (section20s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section20 section20 : section20s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section20.getWill());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Section21> section21s = (List<Section21>) model.get("section21");
		
		Row headerPage10 = sheet.createRow(rowCount++);
		headerPage10.createCell(0).setCellValue("ADDITIONAL INSTRUCTIONS");
		headerPage10.getCell(0).setCellStyle(style1);
		Row headerSubHeader21 = sheet.createRow(rowCount++);
		headerSubHeader21.createCell(0).setCellValue("Important Notes");
		headerSubHeader21.getCell(0).setCellStyle(style2);

		if (section21s.size() == 0) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellStyle(style3);
			userRow.getCell(0).setCellValue("You have not provided any information for this section.");
		} else {
			for (Section21 section21 : section21s) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(section21.getAdditionalInstructions());
			}
		}
	}
}

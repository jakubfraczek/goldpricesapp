package nbpapp.UserComunication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import nbpapp.json.NBPGson;

public class FinalFileCreation {
	
	private static File spreadsheet = Paths.get(System.getProperty("user.home"), "Desktop", Messages.FILE_NAME).toFile();
	
	public static void fileCreation(List<NBPGson> listNBP, String recommendation) {
		
		try (Workbook wb = new XSSFWorkbook()) {
			Sheet sheet = wb.createSheet(Messages.GOLD_PRIZES);
			FillSheet(listNBP, recommendation, sheet);
			
			FileOutputStream fileOut = new FileOutputStream(spreadsheet);
			wb.write(fileOut);
			fileOut.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void FillSheet(List<NBPGson> listNBP, String recommendation, Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue(Messages.DATE);
		row.createCell(1).setCellValue(Messages.GOLD_PRIZE);
		row.createCell(3).setCellValue(Messages.AVARAGE_GOLD_PRICE);
		row.createCell(4).setCellValue(Messages.RECOMENDATION);
		
		int i = 1;
		for (NBPGson nbp : listNBP) {
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(nbp.getData());
			row.createCell(1).setCellValue(nbp.getCena());
			i++;
		}

		String formula = "average(" + ("B2:B" + listNBP.size()) + ")";
		sheet.getRow(0).createCell(3).setCellFormula(formula);

		sheet.getRow(1).createCell(4).setCellValue(recommendation);
	}
	
}

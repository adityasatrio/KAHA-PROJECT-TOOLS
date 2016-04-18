package split.csv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CSVReader_KhOnV3 {

/**
 * tabrakain data kaha on v3 yang dari bu devi dengan data all registered data kaha extranet
 * 
 * */

	static void readHeader() throws IOException {
		String globalDate = "14042016";
		 
		Stream<String> completedHotelsInfo = Files.lines(Paths.get("F://AdityaSatrioNugroho//AWS-extranet-Live-Bu Devi request//CSV-completed-half_completed//completed-"+globalDate+".csv"), StandardCharsets.UTF_8);
		List<String[]> completedIds = completedHotelsInfo.map(line -> line.split(",")).collect(Collectors.toList());
		System.out.println("read 'completed csv file' . . . .  ");
		
		Map<String, String> idCompletedMap = new HashMap<>();
		for(String[] id : completedIds){
			idCompletedMap.put(id[0], id[0]);
		}
		
		completedHotelsInfo.close();
		
		Stream<String> halfCompletedHotelsInfo = Files.lines(Paths.get("F://AdityaSatrioNugroho//AWS-extranet-Live-Bu Devi request//CSV-completed-half_completed//completed_half_completed-"+globalDate+".csv"), StandardCharsets.UTF_8);
		List<String[]> halfCompletedIds = halfCompletedHotelsInfo.map(line -> line.split(",")).collect(Collectors.toList());
		System.out.println("read 'completed half completed csv file' . . . .  ");

		halfCompletedHotelsInfo.close();
		
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet sheet = workbook.createSheet("Half Completed");
		
		int rownum = 0;
		String[] headerString = {"Id","Created Time","Chain","Brand","Name","Province","City","Area"};
		halfCompletedIds.add(0, headerString);
		
		for(String[] halfCompletedhotelInfo : halfCompletedIds){
			if(!(idCompletedMap.containsKey(halfCompletedhotelInfo[0]))){
			
				Row row = sheet.createRow(rownum++);
				for(int i = 0; i <= halfCompletedhotelInfo.length-1; i++){
					Cell cell = row.createCell(i);
					cell.setCellValue((halfCompletedhotelInfo[i]).toString());
				}
				
			}
		}
		
		System.out.println("read 'comparing COMPLETED ID and HALF COMPLETED ID' . . . .  ");
		
		try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("F://AdityaSatrioNugroho//AWS-extranet-Live-Bu Devi request//CSV-completed-half_completed//half_completed-"+globalDate+".xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("half_completed-"+globalDate+".xlsx written successfully on disk.");
            workbook.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
		
	}
	
	public static void main(String[] args) throws IOException {
		CSVReader_KhOnV3.readHeader();
	}

}

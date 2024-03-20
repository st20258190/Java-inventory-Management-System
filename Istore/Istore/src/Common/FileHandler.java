package Common;

import Classes.Account;
import Classes.Product;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileHandler {
    private final File xlsxFile = new File("src/Files/Data.xlsx");

    public FileHandler() {
    }

    public void writeAccounts(Account account) {
        try {
            FileInputStream inputStream = new FileInputStream(xlsxFile);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum();
            Row row = sheet.createRow(++rowCount);

            Cell cell0 = row.createCell(0);
            cell0.setCellValue(account.getId());
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(account.getName());
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(account.getAge());
            Cell cell3 = row.createCell(3);
            cell3.setCellValue(account.getEmail());
            Cell cell4 = row.createCell(4);
            cell4.setCellValue(account.getTel());
            Cell cell5 = row.createCell(5);
            cell5.setCellValue(String.valueOf(account.isManager()));
            Cell cell6 = row.createCell(6);
            cell6.setCellValue(String.valueOf(account.isCashier()));

            inputStream.close();

            FileOutputStream os = new FileOutputStream(xlsxFile);
            workbook.write(os);

            workbook.close();
            os.close();

        } catch (EncryptedDocumentException | IOException error) {
            System.err.println("Couldn't update the file!!");
            error.printStackTrace();
        }
    }

    public void writeProducts(Product product) {
        try {
            FileInputStream inputStream = new FileInputStream(xlsxFile);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(1);
            int rowCount = sheet.getLastRowNum();
            Row row = sheet.createRow(++rowCount);

            Cell cell0 = row.createCell(0);
            cell0.setCellValue(product.getId());
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(product.getName());
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(product.getPrice());
            Cell cell3 = row.createCell(3);
            cell3.setCellValue(product.getYear());
            Cell cell4 = row.createCell(4);
            cell4.setCellValue(String.valueOf(product.getQty()));
            Cell cell5 = row.createCell(5);
            cell5.setCellValue(String.valueOf(product.isIphone()));
            Cell cell6 = row.createCell(6);
            cell6.setCellValue(String.valueOf(product.isIwatch()));
            Cell cell7 = row.createCell(7);
            cell7.setCellValue(String.valueOf(product.isIpad()));
            Cell cell8 = row.createCell(8);
            cell8.setCellValue(String.valueOf(product.isAirpods()));
            Cell cell9 = row.createCell(9);
            cell9.setCellValue(String.valueOf(product.isMac()));

            inputStream.close();

            FileOutputStream os = new FileOutputStream(xlsxFile);
            workbook.write(os);

            workbook.close();
            os.close();

        } catch (EncryptedDocumentException | IOException error) {
            System.err.println("Couldn't update the file!!");
            error.printStackTrace();
        }
    }

    public List<Product> readProducts() throws IOException {

        FileInputStream inputStream = new FileInputStream(xlsxFile);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(1);

        Iterator<Row> iterator = sheet.iterator();
        List<Product> productsList = new ArrayList<Product>();

        int k = 0;
        // Iterating all the rows
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            if (k != 0) {
                Product product = new Product();
                int cellNo = 0;
                // Iterating all the columns in a row
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    switch (cellNo) {
                        case 0:
                            product.setId(cell.getStringCellValue());
                            break;
                        case 1:
                            product.setName(cell.getStringCellValue());
                            break;
                        case 2:
                            product.setPrice(cell.getStringCellValue());
                            break;
                        case 3:
                            product.setYear(cell.getStringCellValue());
                            break;
                        case 4:
                            product.setQty(Integer.parseInt(cell.getStringCellValue()));
                            break;
                        case 5:
                            product.setIphone(cell.getStringCellValue().equals("true"));
                            break;
                        case 6:
                            product.setIwatch(cell.getStringCellValue().equals("true"));
                            break;
                        case 7:
                            product.setIpad(cell.getStringCellValue().equals("true"));
                            break;
                        case 8:
                            product.setAirpods(cell.getStringCellValue().equals("true"));
                            break;
                        case 9:
                            product.setMac(cell.getStringCellValue().equals("true"));
                            break;
                        default:
                            break;
                    }
                    cellNo++;

                }
                productsList.add(product);
            }
            k++;

        }
        workbook.close();
        inputStream.close();

        return productsList;
    }
}

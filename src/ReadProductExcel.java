import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadProductExcel {
    public static void main(String[] args) throws ClassNotFoundException {
        InputStream in = Class.forName("Test").getResourceAsStream("Product.xlsx");
        Product[] products = new ReadProductExcel().readExcel(in);

    }
        public Product[] readExcel(InputStream in) {
            Product products[] = null;
        try{
            XSSFWorkbook xw = new XSSFWorkbook(in);
            XSSFSheet xs = xw.getSheetAt(0);
            products = new Product[xs.getLastRowNum()];
            for (int j = 1; j <= xs.getLastRowNum(); j++) {
                XSSFRow row = xs.getRow(j);
                Product  product= new Product();
                for (int k = 0; k <= row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);
                    if (cell == null)
                        continue;
                    if (k == 0) {
                        product.setId(this.getValue(cell));
                    } else if (k == 1) {
                        product.setName(this.getValue(cell));
                    } else if (k == 2) {
                        product.setPrice(Float.valueOf(this.getValue(cell)));
                    } else if (k == 3) {
                        product.setDesc(this.getValue(cell));
                    }
                    products[j - 1] = product;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            return products;
        }
        }
    }


}

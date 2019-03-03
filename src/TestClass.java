import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestClass {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("SalesStatement.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        SalesStatementList salesStatementList = new SalesStatementList();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] position = line.split(";");

            SalesStatement salesStatement = new SalesStatement(position[0], Double.parseDouble(position[1]), Double.parseDouble(position[2]));
            salesStatementList.add(salesStatement);
            System.out.println("Product name: " + salesStatement.getProduct() + ", Gross price: " + salesStatement.getGrossPrice() + ", Vat rate: " + salesStatement.getVatRate());
        }
        bufferedReader.close();

        salesStatementList.sumOfSalesGross();
        System.out.println("Sum of sales gross: " + salesStatementList.sumOfSalesGross());
        salesStatementList.sumOfSalesNett();
        System.out.println("Sum of sales nett: " + salesStatementList.sumOfSalesNett());
        salesStatementList.sumVat();
        System.out.println("Sum vat: " + salesStatementList.sumVat());
    }
}

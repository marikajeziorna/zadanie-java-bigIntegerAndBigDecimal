import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalesStatementList {
    List<SalesStatement> salesStatementsList = new ArrayList<>();

    public void add(SalesStatement salesStatement) {
        salesStatementsList.add(salesStatement);
    }

    public void add(SalesStatementList salesStatementList) {
        salesStatementList.add(salesStatementList);
    }

    public double sumOfSalesGross() {
        double sum = 0;
        for (SalesStatement salesStatement : salesStatementsList) {
            sum += salesStatement.getGrossPrice();
        }
        return sum;
    }

    public BigDecimal sumOfSalesNett() {
        BigDecimal sumBigDecimal = new BigDecimal(0);
        for (SalesStatement salesStatement : salesStatementsList) {
            sumBigDecimal = sumBigDecimal.add(salesStatement.calcNett());
        }
        return sumBigDecimal;
    }

    public BigDecimal sumVat() {
        return new BigDecimal(sumOfSalesGross()).subtract(sumOfSalesNett());
    }
}

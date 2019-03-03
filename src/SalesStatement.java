import java.math.BigDecimal;

public class SalesStatement {
    private String product;
    private double grossPrice;
    private double vatRate;

    public SalesStatement(String product, double grossPrice, double vatRate) {
        this.product = product;
        this.grossPrice = grossPrice;
        this.vatRate = vatRate;
    }

    public String getProduct() {
        return product;
    }

    public double getGrossPrice() {
        return grossPrice;
    }

    public double getVatRate() {
        return vatRate;
    }

   public BigDecimal calcNett(){
     return new BigDecimal (grossPrice / vatRate);
   }
}


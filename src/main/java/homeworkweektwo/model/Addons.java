package homeworkweektwo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@ConfigurationProperties(prefix = "addons")
public class Addons {

    private int vat;
    private BigDecimal discount;
    private static final Double DIVIDER = 100.0;

    public double getVat() {
        return vat / DIVIDER;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}

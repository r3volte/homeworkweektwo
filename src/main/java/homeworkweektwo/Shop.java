package homeworkweektwo;

import java.math.BigDecimal;
import java.util.List;

public interface Shop {

    BigDecimal getCartValue();

    List<Product> addProductToCart(Product product);
}

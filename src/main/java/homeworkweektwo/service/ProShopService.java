package homeworkweektwo.service;

import homeworkweektwo.model.Addons;
import homeworkweektwo.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Profile("Pro")
public class ProShopService extends Addons implements Shop {

    private List<Product> products;

    public ProShopService() {
        products = new ArrayList<>();
    }

    @Override
    public List<Product> addProductToCart(Product product) {
        products.add(product);
        return products;
    }

    @Override
    public BigDecimal getCartValue() {
        BigDecimal cartSum = getBigDecimal();
        BigDecimal priceWithVAT = cartSum
                .add(cartSum.multiply(BigDecimal.valueOf(getVat())));
        return priceWithVAT.subtract(getDiscount());
    }

    private BigDecimal getBigDecimal() {
        return products
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}

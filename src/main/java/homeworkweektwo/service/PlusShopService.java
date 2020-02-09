package homeworkweektwo.service;

import homeworkweektwo.model.Addons;
import homeworkweektwo.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Profile("Plus")
public class PlusShopService extends Addons implements Shop {

    private List<Product> products;

    public PlusShopService() {
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
        return cartSum
                .add(cartSum.multiply(BigDecimal.valueOf(getVat())));
    }

    private BigDecimal getBigDecimal() {
        return products
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
package homeworkweektwo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Profile("Starter")
public class StarterShopService implements Shop {

    private List<Product> products;

    public StarterShopService() {
        products = new ArrayList<>();
    }

    @Override
    public List<Product> addProductToCart(Product product) {
        products.add(product);
        return products;
    }

    @Override
    public BigDecimal getCartValue() {
        return products
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}

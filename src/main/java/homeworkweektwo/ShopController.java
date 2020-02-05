package homeworkweektwo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

@Controller
public class ShopController {

    private static final int UPPERBOUND = 300;
    private static final int LOWERBOUND = 50 - 1;
    private static final String CARTVALUE = "Cena produktów: ";
    @Autowired
    private final Shop shop;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public ShopController(Shop shop) {
        this.shop = shop;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        Product orange = new Product("Orange", randomPrice());
        Product tea = new Product("Tea", randomPrice());
        Product bread = new Product("Bread", randomPrice());
        Product milk = new Product("Milk", randomPrice());
        Product banana = new Product("Banana", randomPrice());
        shop.addProductToCart(orange);
        shop.addProductToCart(tea);
        shop.addProductToCart(bread);
        shop.addProductToCart(milk);
        shop.addProductToCart(banana);
        logger.info(CARTVALUE + shop.getCartValue().toString());

    }

    private BigDecimal randomPrice() {
        return new BigDecimal(BigInteger
                .valueOf(new Random().nextInt(UPPERBOUND - LOWERBOUND)));
    }
}

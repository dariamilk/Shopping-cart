package pro.sky.shoppingcart.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pro.sky.shoppingcart.model.ShoppingCart;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCart shoppingCart;
    private final ObjectMapper objectMapper;
    public ShoppingCartServiceImpl (ShoppingCart shoppingCart, ObjectMapper objectMapper) {
        this.shoppingCart = shoppingCart;
        this.objectMapper = objectMapper;
    }
    @Override
    public String add (int... ID) {
        for (int i = 0; i < ID.length; i++) {
            shoppingCart.addItem(ID[i]);
        }
        if (ID.length == 1) {
            return "Item was added";
        } else {
            return "Items were added";
        }
    }
    @Override
    public String get () {
        try {
          return objectMapper.writeValueAsString(shoppingCart.getItems());
        }
        catch (JsonProcessingException e) {
           return e.getMessage();
        }
    }
}

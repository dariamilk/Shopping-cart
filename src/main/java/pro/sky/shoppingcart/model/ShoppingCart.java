package pro.sky.shoppingcart.model;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;
import java.util.Collections;
import java.util.List;
@Repository
@SessionScope
public class ShoppingCart {
    private final List<Integer> items;

    public ShoppingCart (List<Integer> ID) {
        this.items = ID;
    }
    public void addItem(Integer item) {
        items.add(item);
    }

    public List<Integer> getItems() {
        return Collections.unmodifiableList(items);
    }
}

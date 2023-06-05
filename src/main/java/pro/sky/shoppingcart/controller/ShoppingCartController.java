package pro.sky.shoppingcart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.shoppingcart.service.ShoppingCartService;

@RestController
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController (ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/add")
    public String add (@RequestParam ("ID") int... ID) {
        return shoppingCartService.add(ID);
    }

    @GetMapping("/get")
    public String get () {
       return shoppingCartService.get();
    }
}

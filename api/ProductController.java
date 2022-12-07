package com.isupov.api;


import com.isupov.model.Product;
import com.isupov.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    @GetMapping()
    public List<Product> getAllProducts(@RequestParam(required = false) Integer min, @RequestParam(required = false) Integer max) {
        return service.getAllProductMinMax(min, max);
    }

    @PostMapping("/add")
    public void addProduct(@RequestParam String title, int price){
        service.addProduct(title, price);
    }

    @GetMapping("/delete/{id}")
    private void deleteProductById(@PathVariable Long id){
        service.deleteById(id);
    }
}


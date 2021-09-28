package com.wcm.webcustomermanager.controller;

import com.wcm.webcustomermanager.entity.Product;
import com.wcm.webcustomermanager.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String productList(Model model) {

        List<Product> productList = productService.getProducts();

        model.addAttribute("productList", productList);

        return "product-list";
    }
}

package com.wcm.webcustomermanager.controller;

import com.wcm.webcustomermanager.entity.Customer;
import com.wcm.webcustomermanager.entity.Product;
import com.wcm.webcustomermanager.service.product.ProductService;
import com.wcm.webcustomermanager.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    private final ProductValidator productValidator;

    @Autowired
    public ProductController(ProductService productService, ProductValidator productValidator) {
        this.productService = productService;
        this.productValidator = productValidator;
    }

    @GetMapping("/list")
    public String productList(Model model) {

        List<Product> productList = productService.getProducts();

        model.addAttribute("productList", productList);

        return "product-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Product product = new Product();

        model.addAttribute("product", product);

        return "product-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("productId") int id, Model model) {

        Product product = productService.getProduct(id);

        model.addAttribute("product", product);

        return "product-form";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product,
                              BindingResult bindingResult) {

        productValidator.validate(product, bindingResult);

        if (bindingResult.hasErrors()) {
            return "product-form";
        }

        productService.saveProduct(product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("productId") int id) {

        productService.deleteProduct(id);
        return "redirect:/product/list";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam("searchName") String searchName, Model model) {

        List<Product> productList = productService.searchProducts(searchName);

        model.addAttribute("productList", productList);

        return "product-list";
    }
}

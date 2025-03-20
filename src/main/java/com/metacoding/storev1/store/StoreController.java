package com.metacoding.storev1.store;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller // IoC (제어의 역전) -> HashSet
public class StoreController {

    private StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    // Main Page
    @GetMapping("/")
    public String list(HttpServletRequest request) { // MVC
        List<Store> storeList = storeService.상품목록();
        request.setAttribute("models", storeList);
        return "store/list";
    }

    // Detail Page
    @GetMapping("/store/{id}")
    public String detail(@PathVariable("id") int id, HttpServletRequest request) {
        Store store = storeService.상세보기(id);
        request.setAttribute("model", store);
        return "store/detail";
    }

    // Save Page
    @GetMapping("/store/save-form")
    public String saveForm() {
        return "store/save-form";
    }

    // Save
    @PostMapping("/store/save")
    public String save(@RequestParam("name") String name, @RequestParam("stock") int stock,
            @RequestParam("price") int price) {
        storeService.상품등록(name, stock, price);
        System.out.println(name);
        System.out.println(stock);
        System.out.println(price);
        return "redirect:/";
    }

    // Update Page
    @GetMapping("/store/{id}/update-form")
    public String updateForm(@PathVariable("id") int id) {
        return "store/update-form";
    }

    // Update
    @PostMapping("/store/{id}/update")
    public String update(@PathVariable("id") int id) {
        return "redirect:/store/{id}";
    }

    // Delete
    @PostMapping("/store/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        storeService.상품삭제(id);
        return "redirect:/";
    }

    // Buy
    @PostMapping("/store/buy")
    public String buy() {
        return "redirect:/log";
    }
}

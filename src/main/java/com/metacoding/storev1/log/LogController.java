package com.metacoding.storev1.log;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogController {

    private LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    // Log Page
    @GetMapping("/log")
    public String list(HttpServletRequest request) {
        List<LogResponse.ListPage> listPage = logService.구매목록();
        request.setAttribute("models", listPage);
        return "log/list";
    }

    // Buy
    @PostMapping("/log/save")
    public String save(@RequestParam("storeId") int storeId, @RequestParam("buyer") String buyer,
            @RequestParam("qty") int qty) {
        logService.구매하기(storeId, buyer, qty);

        return "redirect:/log";
    }

}

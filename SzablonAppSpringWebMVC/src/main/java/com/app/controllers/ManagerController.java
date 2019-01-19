package com.app.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("myManager")
public class ManagerController {

    @RequestMapping("/accounts")
    public String accountsForm() {
        return "manager/accounts";
    }

}

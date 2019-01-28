package com.app.controllers;
import com.app.models.Account;
import com.app.models.Client;
import com.app.models.dao.AccountsDao;
import com.app.models.dto.AccountDto;
import com.app.models.dto.ClientDto;
import com.app.models.dto.converters.AccountsConverter;
import com.app.models.dto.converters.ClientConverter;
import com.app.models.enums.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("myManager")
public class ManagerAccountsController {

    private AccountsDao accountsDao;

    public ManagerAccountsController(AccountsDao accountsDao) {
        this.accountsDao = accountsDao;
    }

    @GetMapping("/accounts")
    public String accountsFormGet(Model model) {
        List<Account> accounts = accountsDao.findAll();
        List<AccountDto> accountsDto = new ArrayList<>();
        AccountsConverter accountsConverter = new AccountsConverter();

        for (Account account : accounts) {
            accountsDto.add(accountsConverter.accountToAccountDto(account));
        }

        model.addAttribute("accounts", accountsDto);
        model.addAttribute("roles", Role.values());
        model.addAttribute("accountAdd", new AccountDto());
        return "manager/accounts";
    }

    @PostMapping("/accounts/add")
    public String accountsFormPost(AccountDto accountDto) {
        System.out.println(accountDto);
        Account account = new AccountsConverter().accountDtoToAccount(accountDto);
        accountsDao.insert(account);
        return "redirect:/myManager/accounts";
    }

    @GetMapping("/accounts/delete/{id}")
    public String deleteAccount(@PathVariable Long id){
        try{
            accountsDao.delete(id);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return "redirect:/myManager/accounts";
    }

    @GetMapping("/accounts/update/{id}")
    public String updateAccount(@PathVariable Long id, Model model){
        AccountDto accountDto = new AccountsConverter().accountToAccountDto(accountsDao.findById(id).orElseThrow(NullPointerException::new));
        model.addAttribute("account", accountDto);
        model.addAttribute("roles", Role.values());

        return "/manager/accountsUpdate";
    }

    @PostMapping("/accounts/update/{id}")
    public String updateAccount(@ModelAttribute AccountDto accountDto, @PathVariable Long id){
        AccountsConverter accountsConverter = new AccountsConverter();
        Account account = accountsConverter.accountDtoToAccount(accountDto);
        accountsDao.update(account);
        return "redirect:/myManager/accounts";
    }

}

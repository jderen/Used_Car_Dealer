package com.app.controllers;

import com.app.models.Client;
import com.app.models.dao.ClientDao;
import com.app.models.dto.ClientDto;
import com.app.models.dto.converters.ClientConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("myManager")
public class ManagerClientController {

    private ClientDao clientDao;

    public ManagerClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @GetMapping("/clients")
    public String clientsForm(Model model) {
        List<Client> list = clientDao.findAll();
        List<ClientDto> clientsDto = new ArrayList<>();
        ClientConverter clientConverter = new ClientConverter();
        ClientDto clientDto = new ClientDto();

        for(Client client:list){
            clientsDto.add(clientConverter.clientToClientDto(client));
        }

        model.addAttribute("clients", clientsDto);
        model.addAttribute("clientAdd", clientDto);

        return "manager/clients";

    }

    @PostMapping("/clients/add")
    public String addClient(@ModelAttribute ClientDto clientDto) {
        ClientConverter clientConverter = new ClientConverter();
        Client client = clientConverter.clientDtoToClient(clientDto);
        clientDao.insert(client);
        return "redirect:/myManager/clients";
    }

    @GetMapping("/clients/delete/{id}")
    public String deleteClient(@PathVariable Long id){
        try{
            clientDao.delete(id);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return "redirect:/myManager/clients";
    }

    @GetMapping("/clients/update/{id}")
    public String updateClient(@PathVariable Long id, Model model){
        ClientConverter clientConverter = new ClientConverter();
        ClientDto clientDto = clientConverter.clientToClientDto(clientDao.findById(id).orElseThrow(NullPointerException::new));

        model.addAttribute("client", clientDto);
        return "/manager/updateClient";
    }

    @PostMapping("/clients/update/{id}")
    public String updateClient(@ModelAttribute ClientDto clientDto, @PathVariable Long id){
        ClientConverter clientConverter = new ClientConverter();
        Client client = clientConverter.clientDtoToClient(clientDto);
        clientDao.update(client);
        return "redirect:/myManager/clients";
    }

}

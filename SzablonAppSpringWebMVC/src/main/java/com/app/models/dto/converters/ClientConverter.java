package com.app.models.dto.converters;


import com.app.models.dao.ClientDao;
import com.app.models.dto.ClientDto;
import com.app.models.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientConverter {



    public ClientDto clientToClientDto(Client client){
        return client == null ? null : ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .surname(client.getSurname())
                .phoneNumber(client.getPhoneNumber())
                .build();
    }


    public Client clientDtoToClient(ClientDto clientDto){

        return Client.builder()
                .id(clientDto.getId())
                .name(clientDto.getName())
                .surname(clientDto.getSurname())
                .phoneNumber(clientDto.getPhoneNumber())
                .build();
    }
}

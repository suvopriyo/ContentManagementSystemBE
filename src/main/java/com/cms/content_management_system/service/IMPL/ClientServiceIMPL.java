package com.cms.content_management_system.service.IMPL;

import com.cms.content_management_system.dto.ClientAdvertisementCreateDto;
import com.cms.content_management_system.dto.ClientAdvertisementDto;
import com.cms.content_management_system.dto.ContentTypeDto;
import com.cms.content_management_system.entity.ClientAdvertisement;
import com.cms.content_management_system.entity.ContentType;
import com.cms.content_management_system.repo.ClientRepo;
import com.cms.content_management_system.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClientServiceIMPL implements ClientService {

    @Autowired
    private ClientRepo clientRepo;


    @Override
    public Boolean clientAdvertisementSave(ClientAdvertisementCreateDto clientAdvertisementCreateDto) {


        try{
            ClientAdvertisement clientAdvertisement = new ClientAdvertisement(
                    clientAdvertisementCreateDto.getTitle(),
                    clientAdvertisementCreateDto.getDescription(),
                    clientAdvertisementCreateDto.getSubject(),
                    clientAdvertisementCreateDto.getNumber_of_pages(),
                    clientAdvertisementCreateDto.getContent_type(),
                    clientAdvertisementCreateDto.getE_t_a(),
                    clientAdvertisementCreateDto.getBudget_currency(),
                    clientAdvertisementCreateDto.getBudget(),
                    clientAdvertisementCreateDto.getNumber_of_words(),
                    clientAdvertisementCreateDto.getLanguage()

            );

            clientRepo.save(clientAdvertisement);
            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);

        }

    }

    @Override
    public List<ClientAdvertisementDto> getAllClientAdvertisement() {
        List<ClientAdvertisement> getClientAdv = clientRepo.findAll();
        List<ClientAdvertisementDto> ClientAdvertisementDtoList = new ArrayList<>();

        for(ClientAdvertisement clientAdvertisement : getClientAdv)
        {
            ClientAdvertisementDto clientAdvertisementDto = new ClientAdvertisementDto(
                    clientAdvertisement.getAdvertisement_id(),
                    clientAdvertisement.getTitle(),
                    clientAdvertisement.getDescription(),
                    clientAdvertisement.getSubject(),
                    clientAdvertisement.getNumber_of_pages(),
                    clientAdvertisement.getContent_type(),
                    clientAdvertisement.getE_t_a(),
                    clientAdvertisement.getBudget_currency(),
                    clientAdvertisement.getBudget(),
                    clientAdvertisement.getNumber_of_words(),
                    clientAdvertisement.getLanguage()
            );
            ClientAdvertisementDtoList.add(clientAdvertisementDto);
        }

        return ClientAdvertisementDtoList;
    }

    @Override
    public Boolean updateClientAdvertisement(ClientAdvertisementDto clientAdvertisementDto) {
        if(clientRepo.existsById(clientAdvertisementDto.getAdvertisement_id()))
        {
            ClientAdvertisement clientAdvertisement = clientRepo.getById(clientAdvertisementDto.getAdvertisement_id());

            clientAdvertisement.setTitle(clientAdvertisementDto.getTitle());
            clientAdvertisement.setDescription(clientAdvertisementDto.getDescription());
            clientAdvertisement.setSubject(clientAdvertisementDto.getSubject());
            clientAdvertisement.setNumber_of_pages(clientAdvertisementDto.getNumber_of_pages());
            clientAdvertisement.setContent_type(clientAdvertisementDto.getContent_type());
            clientAdvertisement.setE_t_a(clientAdvertisementDto.getE_t_a());
            clientAdvertisement.setBudget_currency(clientAdvertisementDto.getBudget_currency());
            clientAdvertisement.setBudget(clientAdvertisementDto.getBudget());
            clientAdvertisement.setNumber_of_words(clientAdvertisementDto.getNumber_of_words());
            clientAdvertisement.setLanguage(clientAdvertisementDto.getLanguage());



            clientRepo.save(clientAdvertisement);
            return true;


        }else{
            System.out.println("Advertisement doesn't exists!");
            return false;
        }
    }

    @Override
    public Boolean deleteClientAdvertisement(int advertisementId) {
        if(clientRepo.existsById(advertisementId))
        {
            clientRepo.deleteById(advertisementId);
            return true;
        }else {
            System.out.println("Advertisement doesn't exists!");
            return false;
        }
    }

    @Override
    public ClientAdvertisementDto getClientAdvertisement(int advertisement_id) {
        ClientAdvertisement clientAdvertisement = clientRepo.findById(advertisement_id)
                .orElseThrow(() -> new NoSuchElementException("Advertisement id  not found with ID: " + advertisement_id));

        return new ClientAdvertisementDto(
                clientAdvertisement.getAdvertisement_id(),
                clientAdvertisement.getTitle(),
                clientAdvertisement.getDescription(),
                clientAdvertisement.getSubject(),
                clientAdvertisement.getNumber_of_pages(),
                clientAdvertisement.getContent_type(),
                clientAdvertisement.getE_t_a(),
                clientAdvertisement.getBudget_currency(),
                clientAdvertisement.getBudget(),
                clientAdvertisement.getNumber_of_words(),
                clientAdvertisement.getLanguage()
        );
    }
}

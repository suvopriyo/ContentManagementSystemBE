package com.cms.content_management_system.controller;

import com.cms.content_management_system.dto.ClientAdvertisementCreateDto;
import com.cms.content_management_system.dto.ClientAdvertisementDto;
import com.cms.content_management_system.dto.ContentTypeDto;
import com.cms.content_management_system.dto.UserRegistrationDto;
import com.cms.content_management_system.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @PostMapping(path = "/clientAdvertisementSave")
    public ResponseEntity<String> clientAdvertisementSave(@RequestBody ClientAdvertisementCreateDto clientAdvertisementCreateDto)
    {
        Boolean saveStatus = clientService.clientAdvertisementSave(clientAdvertisementCreateDto);

        if(saveStatus==true)
        {
            return ResponseEntity.ok("Advertisement published!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to publish advertisement!");
        }

    }

    @GetMapping(path = "/getAllClientAdvertisement")
    public ResponseEntity<List<ClientAdvertisementDto>> getAllClientAdvertisement()
    {
        List<ClientAdvertisementDto> allClientAdvertisement = clientService.getAllClientAdvertisement();
        return ResponseEntity.ok(allClientAdvertisement);

    }

    @GetMapping(path = "/getClientAdvertisement/{advertisement_id}")
    public ResponseEntity<ClientAdvertisementDto> getClientAdvertisement(@PathVariable("advertisement_id") int advertisement_id)
    {
        ClientAdvertisementDto clientAdvertisementd = clientService.getClientAdvertisement(advertisement_id);
        return ResponseEntity.ok(clientAdvertisementd);

    }

        @PutMapping(path = "/updateClientAdvertisement")
    public ResponseEntity<String> updateClientAdvertisement(@RequestBody ClientAdvertisementDto clientAdvertisementDto)
    {
        Boolean updateStatus = clientService.updateClientAdvertisement(clientAdvertisementDto);
        if( updateStatus == true)
        {
            return ResponseEntity.ok("Advertisement Update Successful!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Advertisement Updation Failed!");
        }

    }

    @DeleteMapping(path = "/deleteClientAdvertisement/{advertisement_id}")
    public ResponseEntity<String> deleteClientAdvertisement(@PathVariable(value = "advertisement_id")int advertisement_id)
    {
        Boolean deleteStatus = clientService.deleteClientAdvertisement(advertisement_id);
        if( deleteStatus == true)
        {
            return ResponseEntity.ok("Advertisement Deletion Successful!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Advertisement Deletion Failed!");
        }

    }
}

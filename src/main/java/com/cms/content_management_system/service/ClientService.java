package com.cms.content_management_system.service;

import com.cms.content_management_system.dto.ClientAdvertisementCreateDto;
import com.cms.content_management_system.dto.ClientAdvertisementDto;

import java.util.List;

public interface ClientService {
    Boolean clientAdvertisementSave(ClientAdvertisementCreateDto clientAdvertisementDto);

    List<ClientAdvertisementDto> getAllClientAdvertisement();

    Boolean updateClientAdvertisement(ClientAdvertisementDto clientAdvertisementDto);

    Boolean deleteClientAdvertisement(int advertisementId);

    ClientAdvertisementDto getClientAdvertisement(int advertisement_id);
}

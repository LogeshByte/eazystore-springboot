package com.logesh.eazystore.service;

import com.logesh.eazystore.dto.ContactRequestDto;
import com.logesh.eazystore.dto.ContactResponseDto;
import com.logesh.eazystore.dto.ProductDto;

import java.util.List;

public interface IContactService {

    boolean saveContact(ContactRequestDto contactRequestDto);

    List<ContactResponseDto> getAllOpenMessages();

    void updateMessageStatus(Long contactId, String status);
}

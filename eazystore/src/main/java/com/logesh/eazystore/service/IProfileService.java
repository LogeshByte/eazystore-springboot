package com.logesh.eazystore.service;

import com.logesh.eazystore.dto.ProfileRequestDto;
import com.logesh.eazystore.dto.ProfileResponseDto;

public interface IProfileService {

    ProfileResponseDto getProfile();

    ProfileResponseDto updateProfile(ProfileRequestDto profileRequestDto);
}

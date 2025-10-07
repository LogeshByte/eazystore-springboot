package com.logesh.eazystore.controller;

import com.logesh.eazystore.dto.ProfileRequestDto;
import com.logesh.eazystore.dto.ProfileResponseDto;
import com.logesh.eazystore.service.IProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final IProfileService iProfileService;

    @GetMapping
    public ResponseEntity<ProfileResponseDto> getProfile() {
        ProfileResponseDto responseDto = iProfileService.getProfile();
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping
    public ResponseEntity<ProfileResponseDto> updateProfile(
            @Validated @RequestBody ProfileRequestDto profileRequestDto) {
        ProfileResponseDto responseDto = iProfileService.updateProfile(profileRequestDto);
        return ResponseEntity.ok(responseDto);
    }

}

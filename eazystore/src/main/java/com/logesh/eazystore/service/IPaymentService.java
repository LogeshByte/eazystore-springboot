package com.logesh.eazystore.service;

import com.logesh.eazystore.dto.PaymentIntentRequestDto;
import com.logesh.eazystore.dto.PaymentIntentResponseDto;

public interface IPaymentService {

    PaymentIntentResponseDto createPaymentIntent(PaymentIntentRequestDto requestDto);
}

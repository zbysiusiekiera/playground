package org.jakubplayground.testshowcase.usecase;

import org.instancio.junit.InstancioExtension;
import org.instancio.junit.InstancioSource;
import org.jakubplayground.testshowcase.domain.CardDetails;
import org.jakubplayground.testshowcase.domain.Payment;
import org.jakubplayground.testshowcase.domain.PaymentStatus;
import org.jakubplayground.testshowcase.repository.CardRepository;
import org.jakubplayground.testshowcase.repository.PaymentRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith({MockitoExtension.class, InstancioExtension.class})
class PaymentServiceTest {

    @InjectMocks
    PaymentService paymentService;

    @Mock
    CardRepository cardRepository;

    @Mock
    PaymentRepository paymentRepository;

    @ParameterizedTest
    @InstancioSource
    void registerPayment_ShouldSaveCashPaymentWithStatusOK_Test(
            Double givenAmount, UUID givenId
    ) {
        //given
        given(paymentRepository.save(any(Payment.class))).willReturn(givenId);

        //when
        paymentService.registerPayment(givenAmount, Optional.empty());

        //then
        then(paymentRepository).should().save(any(Payment.class));
        then(cardRepository).shouldHaveNoInteractions();
    }

    @ParameterizedTest
    @InstancioSource
    void registerPayment_ShouldSaveCardPaymentWithStatusOK_Test(
            Double givenAmount, CardDetails givenCard, UUID givenId
    ) {
        //given
        given(paymentRepository.save(any(Payment.class))).willReturn(givenId);
        given(cardRepository.validateCard(givenCard)).willReturn(true);
        given(paymentRepository.updateStatus(givenId, PaymentStatus.OK)).willReturn(true);

        //when
        paymentService.registerPayment(givenAmount, Optional.of(givenCard));

        //then
        then(paymentRepository).should().save(any(Payment.class));
        then(cardRepository).should().validateCard(eq(givenCard));
        then(paymentRepository).should().updateStatus(eq(givenId), eq(PaymentStatus.OK));
    }

    @ParameterizedTest
    @InstancioSource
    void registerPayment_ShouldSaveCardPaymentWithStatusERROR_Test(
            Double givenAmount, CardDetails givenCard, UUID givenId
    ) {
        //given
        given(paymentRepository.save(any(Payment.class))).willReturn(givenId);
        given(cardRepository.validateCard(givenCard)).willReturn(false);
        given(paymentRepository.updateStatus(givenId, PaymentStatus.ERROR)).willReturn(true);

        //when
        paymentService.registerPayment(givenAmount, Optional.of(givenCard));

        //then
        then(paymentRepository).should().save(any(Payment.class));
        then(cardRepository).should().validateCard(eq(givenCard));
        then(paymentRepository).should().updateStatus(eq(givenId), eq(PaymentStatus.ERROR));
    }
}
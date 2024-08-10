package org.jakubplayground.testshowcase.repository;

import org.instancio.junit.InstancioExtension;
import org.instancio.junit.InstancioSource;
import org.jakubplayground.testshowcase.domain.Payment;
import org.jakubplayground.testshowcase.domain.PaymentStatus;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(InstancioExtension.class)
class PaymentRepositoryTestInstancio {

    @ParameterizedTest
    @InstancioSource
    void updateStatus_Test(Payment givenPayment, UUID givenId, PaymentStatus givenStatus) {

        ConcurrentMap<UUID, Payment> payments = new ConcurrentHashMap<>();
        PaymentRepository paymentRepository = new PaymentRepository(payments);

        payments.put(givenId, givenPayment);

        boolean updated = paymentRepository.updateStatus(givenId, givenStatus);

        assertThat(updated).isTrue();
        assertThat(payments.get(givenId).status()).isEqualTo(givenStatus);
    }
}
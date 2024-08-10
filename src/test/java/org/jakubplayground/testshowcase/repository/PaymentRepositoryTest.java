package org.jakubplayground.testshowcase.repository;

import org.instancio.Instancio;
import org.jakubplayground.testshowcase.domain.CardDetails;
import org.jakubplayground.testshowcase.domain.Payment;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.field;

class PaymentRepositoryTest {
    @Test
    void save_Test() {

        ConcurrentMap<UUID, Payment> payments = new ConcurrentHashMap<>();
        PaymentRepository paymentRepository = new PaymentRepository(payments);

        Payment givenPayment = Instancio.of(Payment.class)
                .generate(field("amount"), generators ->
                        generators.doubles().range(.5, 10_000.))
                .generate(field(CardDetails.class, "cvc"),
                        generators -> generators.ints().range(1, 999))
                .generate(field(CardDetails.class, "number"),
                        generators -> generators.finance().creditCard().masterCard())
                .set(field(CardDetails.class, "expDate"), "1233")
                .create();

        UUID id = paymentRepository.save(givenPayment);

        assertThat(id).isNotNull();
        assertThat(payments).containsKey(id).containsValue(givenPayment);
    }
}
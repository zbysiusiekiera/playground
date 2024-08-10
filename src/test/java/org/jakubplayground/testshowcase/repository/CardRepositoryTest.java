package org.jakubplayground.testshowcase.repository;

import org.jakubplayground.testshowcase.domain.CardDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.jakubplayground.testshowcase.CardDetailsMockData.*;

/**
 * This class shows a typical use case where the mock data is created manually without instancio.
 */
class CardRepositoryTest {

    @Test
    void validateCardWithManualMockData() {
        CardRepository repository = new CardRepository();
        boolean valid = repository.validateCard(
                new CardDetails(VALID_CN, VALID_ED, VALID_CVC)
        );
        assertThat(valid).isTrue();
    }

    @ParameterizedTest
    @MethodSource
    void validateCard_invalidCard_ParameterizedTest(CardDetails cardDetails) {
        CardRepository repository = new CardRepository();
        boolean valid = repository.validateCard(cardDetails);
        assertThat(valid).isFalse();
    }

    static Stream<CardDetails> validateCard_invalidCard_ParameterizedTest() {
        return Stream.of(
                new CardDetails(INVALID_CN, VALID_ED, VALID_CVC),
                new CardDetails(VALID_CN, INVALID_ED, VALID_CVC),
                new CardDetails(VALID_CN, VALID_ED, INVALID_CVC)
                // Other test cases are ignored for simplicity...
        );
    }
}
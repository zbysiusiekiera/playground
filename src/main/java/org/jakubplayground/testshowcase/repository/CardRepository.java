package org.jakubplayground.testshowcase.repository;

import org.jakubplayground.testshowcase.domain.CardDetails;

import java.time.LocalDate;

public class CardRepository {
    protected static boolean checkCN(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

    protected static boolean checkED(int expDate) {
        LocalDate now = LocalDate.now();

        final int expYear = 2000 + expDate % 100;
        if (expYear > now.getYear()) {
            return true;
        }

        final int expMonth = expDate / 100;
        return (expYear == now.getYear() && expMonth > now.getMonthValue());
    }

    protected static boolean checkCVC(int cvc) {
        return (cvc > 0 && cvc < 1000);
    }

    /**
     * Validates:
     * <ol>
     * <li>Card Number using the Luhn Algorithm. <a href="https://en.wikipedia.org/wiki/Luhn_algorithm">wiki</a></li>
     * <li>Expiration Date checking that it is prior to the current month and year.</li>
     * <li>CVC checking that it is between 0 and 1000. See <a href="https://en.wikipedia.org/wiki/Card_security_code">wiki</a></li>
     * </ol>
     *
     * @param card the card instance of {@link CardDetails}
     * @return {@code true} if the card is valid, or {@code false} otherwise.
     */
    public boolean validateCard(CardDetails card) {
        return checkCN(card.number()) && checkED(card.expDate()) && checkCVC(card.cvc());
    }
}

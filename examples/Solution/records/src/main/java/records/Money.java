package records;

import java.math.BigDecimal;

public record Money(BigDecimal amount, String currency) {

    static Money EUR(String amount){
        return new Money(new BigDecimal(amount), "EUR");
    }

}

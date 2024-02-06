package records;
import java.math.BigDecimal;

public class Money_C {
    private BigDecimal amount;
    private String currency;

    public Money_C(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money_C EUR(String amount) {
        return new Money_C(new BigDecimal(amount), "EUR");
    }
    BigDecimal amount() { return amount;  }
    String currency() {    return currency; }
    void setAmount(BigDecimal amount) { this.amount = amount; }
    void setCurrency(String currency) { this.currency = currency; }

    void checkCompatibility(Money_C otherMoney) {
        try { Thread.sleep(2000); } catch (InterruptedException e) { throw new RuntimeException(e);}
        if (!currency.equals(otherMoney.currency))
            throw new RuntimeException("Money not compatible!");
    }

    Money_C decrement(Money_C otherMoney) {
        checkCompatibility(otherMoney);
        return new Money_C(amount.subtract(otherMoney.amount), currency);
    }

    @Override
    public String toString() {
        return "Money {amount=" + amount + ", currency='" + currency + '\'' + '}';
    }

}
package records;


public class Vault {

    // private Money_C content;
    private Money content;

    public Vault(Money initialContent) {
        this.content = initialContent;
    }

    public Money getContent() {
        return content;
    }

    public void pay(Money money){
        // this.content = this.content.decrement(money);
        this.content = new Money(content.amount().subtract(money.amount()), this.content.currency());
    }

    private void hacker(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        var robbedVaults = Bank.robBank();
        // robbedVaults.forEach(vault -> vault.getContent().setCurrency("FUN"));
    }


        public static void main(String[]args){

            Vault instance = new Vault(Money.EUR("0.0"));
            // new Thread(instance::hacker).start();

            var vault = Bank.createNewVault(Money.EUR("22.33"));
            System.out.println("Initially: " + vault.getContent());

            // pay in first shop
            vault.pay(Money.EUR("1.22"));
            System.out.println("After first payment: " + vault.getContent());

            // go to second shop
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // pay in second shop
            vault.pay(Money.EUR("2.44"));
            System.out.println("After second payment: " + vault.getContent());
        }


}


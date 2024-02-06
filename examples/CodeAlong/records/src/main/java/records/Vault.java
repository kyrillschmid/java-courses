package records;


public class Vault {

    private Money_C content;

    public Vault(Money_C initialContent) {
        this.content = initialContent;
    }

    public Money_C getContent() {
        return content;
    }

    public void pay(Money_C money){
        this.content = this.content.decrement(money);
    }

    private void hacker(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        var robbedVaults = Bank.robBank();
        robbedVaults.forEach(vault -> vault.getContent().setCurrency("FUN"));
    }


    public static void main(String[]args){

        Vault instance = new Vault(Money_C.EUR("0.0"));

        // Hachker attack
        // new Thread(instance::hacker).start();

        var vault = Bank.createNewVault(Money_C.EUR("22.33"));
        System.out.println("Initially: " + vault.getContent());

        // pay in first shop
        vault.pay(Money_C.EUR("1.22"));
        System.out.println("After first payment: " + vault.getContent());

        // go to second shop
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // pay in second shop
        vault.pay(Money_C.EUR("2.44"));
        System.out.println("After second payment: " + vault.getContent());
    }

}


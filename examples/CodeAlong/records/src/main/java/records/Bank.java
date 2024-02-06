package records;

import java.util.ArrayList;
import java.util.List;
 public class Bank {
    private static final List<Vault> vaults = new ArrayList<>();

    public static Vault createNewVault(Money_C money) {
        var vault = new Vault(money);
        vaults.add(vault);
        return vault;
    }

    public static List<Vault> robBank() {
        return vaults;
    }

}

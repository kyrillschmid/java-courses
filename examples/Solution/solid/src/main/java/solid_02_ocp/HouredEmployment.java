package solid_02_ocp;

public class HouredEmployment extends Employment {
    private int billableHours;

    public HouredEmployment(int billableHours) {
        this.billableHours = billableHours;
    }

    @Override
    double calculatePay() {
        return 50.0 * billableHours;
    }

    @Override
    int reportHours() {
        return billableHours;
    }
}

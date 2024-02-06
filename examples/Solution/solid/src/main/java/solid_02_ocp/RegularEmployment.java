package solid_02_ocp;

public class RegularEmployment extends Employment {
    private double salary;
    private int overtime;

    public RegularEmployment(double salary, int overtime) {
        this.salary = salary;
        this.overtime = overtime;
    }

    @Override
    double calculatePay() {
        return salary + 60.0 * overtime;
    }

    @Override
    int reportHours() {
        return 40 + overtime;
    }
}

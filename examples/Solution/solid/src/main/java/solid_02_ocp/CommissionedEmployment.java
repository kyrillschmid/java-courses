package solid_02_ocp;

import project.Project;

public class CommissionedEmployment extends Employment {
    private Project project;

    public CommissionedEmployment(Project project) {
        this.project = project;
    }

    @Override
    double calculatePay() {
        return project.getAssets() * 0.1;
    }

    @Override
    int reportHours() {
        return 40;
    }
}

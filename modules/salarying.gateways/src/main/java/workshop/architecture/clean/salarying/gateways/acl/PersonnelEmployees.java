package workshop.architecture.clean.salarying.gateways.acl;

import org.springframework.stereotype.Component;
import workshop.architecture.clean.personnel.application.GetEmployeeByIdUseCase;
import workshop.architecture.clean.salarying.domain.Salary;

import javax.annotation.Resource;

@Component
public class PersonnelEmployees implements Salary.Employees {

    private @Resource GetEmployeeByIdUseCase getEmployeeByIdUseCase;

    @Override
    public String employeeName(String id) {
        return getEmployeeByIdUseCase.execute(id).name();
    }

}

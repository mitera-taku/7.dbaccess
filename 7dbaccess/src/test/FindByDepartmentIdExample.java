package test;

import java.util.List;

public class FindByDepartmentIdExample {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        List<Employee> list = dao.findByDepartmentId(2);

        for(Employee employee :list){
            System.out.println("name = " + employee.getName());
        }
    }
}

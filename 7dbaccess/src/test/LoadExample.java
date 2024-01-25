package test;

public class LoadExample {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        Employee employee = dao.load(1);//daoのloadクラスを呼び、データベースに接続、結果の処理をし、返却された値が来ている

        System.out.println("id = " + employee.getId());
        System.out.println("name = " + employee.getName());
        System.out.println("age = " + employee.getAge());
        System.out.println("gender = " + employee.getGender());
        System.out.println("department_id = " + employee.getDepartmentId());

    }
}

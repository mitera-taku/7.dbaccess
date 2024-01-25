package test;

public class EX05DELETEExample {
    public static void main(String[] args) {
        DepartmentDao dao = new DepartmentDao();
        dao.delete(1);

        Department department = dao.load(1);

        System.out.println("id = " + department.getId());
    }
}

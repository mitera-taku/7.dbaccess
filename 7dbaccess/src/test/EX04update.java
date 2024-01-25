package test;


public class EX04update {
    public static void main(String[] args) {
        DepartmentDao dao = new DepartmentDao();

        System.out.print("ーーーーーーーー更新ーーーーーーー");
        Department department = dao.load(1);
        System.out.println("id = " + department.getId());
        System.out.println("name = " + department.getName());

        department.setName("営業部");
        System.out.print("ーーーーーーーー更新後ーーーーーーー");
        System.out.println("id = " + department.getId());
        System.out.println("name = " + department.getName());
    }
}

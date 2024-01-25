package test;

import java.util.List;

public class ex03InsertExample {
    public static void main(String[] args) {
        DepartmentDao dao = new DepartmentDao();
        List<Department> list = dao.findById(1);

        for(Department department :list){
            System.out.println("id = " + department.getId());
            System.out.println("name = " + department.getName());
    }
}
}


//演習3のコツ　public staticを警戒する
// "select id,name,age,gender,department_id from "+
//                     TABLE_NAME + " where department_id = ?";
                // の空白を意識する事
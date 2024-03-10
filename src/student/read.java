package student;

import java.io.IOException;
import java.util.ArrayList;

public class read {
    public static void read() throws IOException {
        ArrayList<Student> studentlist = new ArrayList<>();
        StudentScoreManagement in =new StudentScoreManagement();
        in.importfile();
        studentlist=in.studentlist;
        if (in.studentlist.isEmpty() == true){
            System.out.println("暂无数据！");
        }
        else {
            System.out.println("已添加的学生信息：");

            //使用for...each循环语句遍历集合元素
            for (Student stu : in.studentlist) {
                System.out.println(stu);
            }
        }
        in.outportfile(studentlist);
    }
}
//
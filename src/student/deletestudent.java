package student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class deletestudent {
    public static void deletestudent() throws IOException {
        ArrayList<Student> studentlist = new ArrayList<>();
        StudentScoreManagement in =new StudentScoreManagement();
        in.importfile();
        studentlist=in.studentlist;
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入想要删除信息的学生姓名：");
        String dname = sc.next();

        //使用迭代器遍历集合元素
        Iterator<Student> it = in.studentlist.iterator();
        while (it.hasNext()){
            Student st=it.next();
            if(st.getName().equals(dname)){
                it.remove();
                System.out.println("删除成功！");
            }else if (st.getName().equals(dname) == true) {
                System.out.println("暂不存在该学生信息，请重新输入！");
            }
        }
        in.outportfile(studentlist);
    }
}

package student;

import java.util.ArrayList;
import java.util.Scanner;

public class createstudent {
    public  void createstudent() throws Exception{ //声明异常
        ArrayList<Student> studentlist = new ArrayList<>();
    StudentScoreManagement in =new StudentScoreManagement();
    in.importfile();
    studentlist=in.studentlist;
    /*输入成绩*/
    String goon = "Y";
    while ("Y".equals(goon)) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生成绩：");
        int score = sc.nextInt();

        //抛出异常：
        if (score<0 || score>100) {
            throw new Exception("输入的成绩不合理！");

        }

        Student stu = new Student(name,score);
        in.studentlist.add(stu);

        System.out.println("是否继续录入？Y/N");
        goon = sc.next();
    }
        in.outportfile(studentlist);
    }
}
//
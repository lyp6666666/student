package student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class update {
    public static void update() throws IOException {
        ArrayList<Student> studentlist = new ArrayList<>();
        StudentScoreManagement in =new StudentScoreManagement();
        in.importfile();
        studentlist=in.studentlist;

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入想要修改的学生信息(输入 姓名/成绩)： 1、姓名 2、成绩 ");
        String data = sc.next();   //输入想要修改的信息

        if (data.equals("姓名")) {

            System.out.println("请输入将要修改姓名信息的同学：");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();

            //使用迭代器遍历集合元素
            Iterator<Student> it = in.studentlist.iterator();
            while (it.hasNext()){
                Student st = it.next();
                if(st.getName().equals(name)){
                    System.out.println("请输入修改后的姓名：");
                    String newname = scanner.next();
                    st.setName(newname);
                    System.out.println("修改成功！\n已修改的学生信息：");
                    System.out.println(st);
                }else if (st.getName().equals(name) == true) {
                    System.out.println("暂不存在该学生信息，请重新输入！");
                }
            }

        }
        else if (data.equals("成绩")){

            System.out.println("请输入将要修改成绩信息的同学姓名：");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();


            //使用迭代器遍历集合元素
            Iterator<Student> it = in.studentlist.iterator();
            while (it.hasNext()){
                Student st = it.next();
                if(st.getName().equals(name)){
                    System.out.println("请输入修改后的成绩：");
                    int newscore = sc.nextInt(); //修改后的成绩
                    st.setScore(newscore);
                    System.out.println("修改成功！\n已修改的学生信息：");
                    System.out.println(st);
                }else if (st.getName().equals(name) == true) {
                    System.out.println("暂不存在该学生信息，请重新输入！");
                }
            }
        }
        else
            System.out.println("您输入的操作信息有误！请重新输入");
        in.outportfile(studentlist);
    }
}

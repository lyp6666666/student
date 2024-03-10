package student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentScoreManagement {
    ArrayList<Student> studentlist = new ArrayList<>();
    String studentpathname = "C:\\Users\\53256\\IdeaProjects\\new student\\src\\student\\studentlist.txt";
    public  void importfile() throws IOException {            //


        try {
            if(!isempty()){
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(studentpathname));
                 studentlist = (ArrayList<Student>) in.readObject();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isempty(){
        File file=new File(studentpathname);
        return file.length()==0;
    }
    public void outportfile(ArrayList<Student> stu){
        String studentpathname = "C:\\Users\\53256\\IdeaProjects\\new student\\src\\student\\studentlist.txt";
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(studentpathname));
            out.writeObject(stu);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println("欢迎登录学生成绩信息管理系统！");
        createstudent crea=new createstudent();
        read rea=new read();
        deletestudent del =new deletestudent();
        update upd =new update();

        while(true) {

            System.out.println();
            System.out.println("=====================");
            System.out.println("请选择操作：");
            System.out.println("①查询信息\n②添加信息\n③删除信息\n④修改信息\n⑤退出系统");
            System.out.println("=====================");
            Scanner stu = new Scanner(System.in);
            int n = stu.nextInt();//接收控制台输入
            stu.nextLine();
            if (n == 1) {
                //查询
                rea.read();

            } else if (n == 2) {
                //添加
                while (true){

                    //使用 try...catch 捕获异常：
                    try {
                        crea.createstudent();
                        break;
                    } catch (Exception e) {
//                    throw new RuntimeException(e.toString());    //抛出异常，程序结束
                        System.out.println("输入了不合理的成绩，请重新输入！"); //程序继续执行
                    }
                }

            } else if (n == 3) {
                //删除
                del.deletestudent();

            } else if (n == 4) {
                //修改
                upd.update();

            } else if (n == 5) {
                //退出
                System.out.println("已退出学生成绩信息管理系统！");
                break;

            } else {
                System.out.println("暂无该项指令，请重新输入！");
            }
        }
    }

    //使用ArrayList集合存放学生信息数据
 //   static List<Student> studentList = new ArrayList<>();

    /**增*/
 //   public static void create() throws Exception{ //声明异常

        /*输入成绩
        String goon = "Y";
        while ("Y".equals(goon)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入学生姓名：");
            String name = sc.next();
            System.out.println("请输入学生成绩：");
            int score = sc.nextInt();


            if (score<0 || score>100) {
                throw new Exception("输入的成绩不合理！");

            }

            Student stu = new Student(name,score);
            studentList.add(stu);

            System.out.println("是否继续录入？Y/N");
            goon = sc.next();
        }

    }        */

    /**删*/
 /*   public static void delete(){

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入想要删除信息的学生姓名：");
        String dname = sc.next();

        //使用迭代器遍历集合元素
        Iterator<Student> it = studentlist.iterator();
        while (it.hasNext()){
            Student st=it.next();
            if(st.getName().equals(dname)){
                it.remove();
                System.out.println("删除成功！");
            }else if (st.getName().equals(dname) == true) {
                System.out.println("暂不存在该学生信息，请重新输入！");
            }
        }
    }
*/
    /**查*/
 /*   public static void read(){
        if (studentlist.isEmpty() == true){
            System.out.println("暂无数据！");
        }
        else {
            System.out.println("已添加的学生信息：");

            //使用for...each循环语句遍历集合元素
            for (Student stu : studentlist
            ) {
                System.out.println(stu);
            }
        }
    }
*/
    /**改*/
/*    public static void update(){

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入想要修改的学生信息(输入 姓名/成绩)： 1、姓名 2、成绩 ");
        String data = sc.next();   //输入想要修改的信息

        if (data.equals("姓名")) {

            System.out.println("请输入将要修改姓名信息的同学：");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();

            //使用迭代器遍历集合元素
            Iterator<Student> it = studentList.iterator();
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
            Iterator<Student> it = studentList.iterator();
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
    }   */
}
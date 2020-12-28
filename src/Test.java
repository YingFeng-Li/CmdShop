import java.io.File;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        /*
        开始读文件
         */
        File file = new File("E:\\蓝桥学习\\MyCode\\CmdShop\\src\\users.xlsx");//一定要具体到某一个文件名称，而不是目录而已
        ReadExcel readExcel = new ReadExcel();//创建对象  ReadExce为一个类
        User users[] = readExcel.readExcel(file);

        boolean flag = true;
        while(flag){
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你的名字：");
            String username = sc.next();
            System.out.println("请输入你的密码：");
            String password = sc.next();

            for (int i = 0; i < users.length; i++) ;
            {
                int i = 0;
                if (username.equals(users[i].getName()) && password.equals(users[i].getPassword())) {
                    System.out.println("登陆成功!");
                    flag = false;
                } else {
                    System.out.println("登录失败!请重新输入");
                }
            }
        }

    }
}

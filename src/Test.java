import java.io.File;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        /*
        开始读文件
         */
        File file = new File("users.xlsx");//一定要具体到某一个文件名称，而不是目录而已



        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的名字：");
        String username = sc.next();

        System.out.println("请输入你的密码：");
        String password = sc.next();




    }
}

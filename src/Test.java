import java.io.InputStream;
import java.util.Scanner;
import java.io.File;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        boolean bo=true;
        while (bo){
            System.out.println("请输入用户名:");

            Scanner sc=new Scanner(System.in);
            String uername=sc.next();


            System.out.println("请输入你的密码:");
            String password=sc.next();

            InputStream inPro=Class.forName("Test").getResourceAsStream("product.xlsx");
            InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
            //File file=new File("C:\\Users\\151509\\IdeaProjects\\java\\src\\users.xlsx");
            ReadExcel readExcel=new ReadExcel();
            User users[]=readExcel.readExcel(in);
            for (int i=0; i<users.length;i++) {
                if (uername.equals(users[i].getName()) && password.equals(users[i].getPassword())) {
                    System.out.println("登陆成功");
                    ReadProductExcel readProductExcel=new ReadProductExcel();
                    Product products[] =readProductExcel.getAllProductExcel(inPro);
                    for (Product product:products) {
                        System.out.print(product.getId());
                        System.out.print("\t" + product.getName());
                        System.out.print("\t" + product.getPrice());
                        System.out.println("\t" + product.getDesc());
                    }
                    int count =0;
                    Product products1[]=new Product[5];
                    System.out.println("请输入商品ID");
                    String pId=sc.next();
                    ReadProductExcel readProductExcel1=new ReadProductExcel();
                    inPro=null;
                    inPro=Class.forName("Test").getResourceAsStream("/product.xlsx");
                    Product product=readProductExcel1.getProductById(pId,inPro);
                    if(product!=null){
                        products1[count++]=product;//把商品加入购物车
                        System.out.println("找到了该商品");
                        System.out.println("你购买的商品数量为"+count);

                    }

                    System.out.println("你购物车里的商品为：");
                    for(i=0;i<count;i++){

                        System.out.print("+products1[i]");
                    }
                    System.out.println("是否继续购物");
                    for (Product product1:products) {
                        System.out.print(product.getId());
                        System.out.print("\t" + product.getName());
                        System.out.print("\t" + product.getPrice());
                        System.out.println("\t" + product.getDesc());
                    }

                    bo=false;
                    break;
                } else {
                    System.out.println("登陆失败");
                    System.out.println("正确的密码是" + users[i].getPassword());
                }
            }
        }
    }
}

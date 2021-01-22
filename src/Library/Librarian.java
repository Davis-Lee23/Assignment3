package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

//18号晚上回家后开始学的数据库加急写完的，期末考和军训占用了部分时间
//代码过于冗长，连接数据库其实可以单独写成一个工具类，反射机制不是很了解，有很多功能有想法还未实现
//比如一开始建表可以加入价格、出版商，用between查询之类的

public class Librarian {
    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            System.out.println("——————————————————————————————————");
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入1可添加作者或书籍,输入2可删除作者或书籍");
            System.out.println("输入3可查询书本目录,输入4可查看作者与其著作");
            System.out.println("输入5可借出与归还书本");
            System.out.println("输入6可进行首字母查询书籍");
            System.out.println("输入9退出控制台");
            int command = scanner.nextInt();
            //命令①添加书籍与作者
            if (command == 1) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("输入1添加作者，输入2添加书籍（要先有作者才能有书籍哦）");
                int judge = scanner1.nextInt();
                if (judge == 1) {
                    System.out.println("输入作者名称");
                    String name = scanner1.next();
                    System.out.println("请输入作者的ID");
                    int id = scanner1.nextInt();
                    Modify modify = new Modify(name, id);
                    modify.t_insert(modify.name, modify.id);
                } else if (judge == 2) {
                    System.out.println("请输入想添加的书籍id");
                    int bookid = scanner1.nextInt();
                    System.out.println("输入书籍名称");
                    String bookname = scanner1.next();
                    System.out.println("输入作者的id");
                    int id = scanner1.nextInt();
                    Modify modify = new Modify(bookname,bookid,id);
                    modify.t_insertbook(modify.bookid,modify.bookname,modify.id);
                }else {
                    System.out.println("输入有误，请重新操作!!!");
                }
            }
            //命令②删除书籍与作者
            if(command ==2){
                System.out.println("输入1删除作者，输入2删除书籍（要删光作者书籍才能去除作者哦）");
                int judge = scanner.nextInt();
                if(judge==1){
                    System.out.println("请输入要删除的作者的id");
                    int id = scanner.nextInt();
                    Modify modify = new Modify(id);
                    modify.t_delete(modify.id);
                }else if (judge == 2){
                    System.out.println("请输入要删除的书籍的id");
                    int bookid = scanner.nextInt();
                    Modify modify = new Modify(bookid);
                    modify.t_deletebook(bookid);
                }else {
                    System.out.println("输入有误，请重新操作!!!");
                }
            }
            //命令③查询书籍
            if(command == 3){
                Query me = new Query();
                me.querybook();
            }
            //命令④查询作者与其著作
            if(command == 4){
                Query me = new Query();
                me.authorbook();
            }
            //命令⑤借书与还书
            if(command == 5){
                System.out.println("借书请按1，还书请按0");
                int judge = scanner.nextInt();
                if(judge == 1) {
                    System.out.println("输入你要借的书的id");
                    int bookid = scanner.nextInt();
                    IsLend me = new IsLend(bookid);
                    me.lend(bookid);
                }else if(judge == 0){
                    System.out.println("输入你归还的书的id");
                    int bookid = scanner.nextInt();
                    IsLend me = new IsLend(bookid);
                    me.giveback(bookid);
                }else {
                    System.out.println("输入错误，请重新操作");
                }
            }

            //命令⑥模糊查询，like
            if(command == 6){
                System.out.println("请输入首字母");
                String search = scanner.next();
                Query me = new Query();
                me.Fuzzyquery(search);
            }

            //结束控制台操作
            if (command == 9) {
                flag = false;
            }
        }
    }
}

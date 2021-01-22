package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Modify extends Librarian {
    String name;//作者名字
    int id;//作者id
    int bookid;//书籍id
    String bookname;//书籍名称

    Statement st=null;
    Connection conn = null;

    public void t_insert(String a,int b){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","123477");
            st=conn.createStatement();
            String sql = "insert into t_author(authorID,author)values("+"'"+b+"'"+","+"'"+a+"'"+")";
            st.executeUpdate(sql);
            System.out.println("添加作者成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void t_insertbook(int bookid,String bookname,int id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","123477");

            st=conn.createStatement();
            String sql = "insert into book(bookid,bookname,state,authorID)values("+bookid+","+"'"+bookname+"'"+","+0+","+"'"+id+"'"+")";

            st.executeUpdate(sql);
            System.out.println("添加书籍成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void  t_delete(int b){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","123477");
            st=conn.createStatement();
            String sql = "delete from t_author where authorID = "+b;
            st.executeUpdate(sql);
            System.out.println("删除作者成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void t_deletebook(int a){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","123477");
            st=conn.createStatement();
            System.out.println(a);
            String sql = "delete from book where bookid ="+a;
            System.out.println(sql);
            st.execute(sql);
            System.out.println("删除书籍成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                st.close();
            }catch (Exception e){
            }
            try{
                conn.close();
            }catch (Exception e){
            }
        }
    }

//添加作者的构造方法
    public Modify(String name, int id) {
        this.name = name;
        this.id = id;
    }
//添加书籍的构造方法
    public Modify(String bookname, int bookid, int id) {
        this.id = id;
        this.bookid = bookid;
        this.bookname = bookname;
    }
//删除书籍的构造方法
    public  Modify(int id){
        this.id = id;
    }

}

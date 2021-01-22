package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class IsLend {
    int bookid;
    public static void Initialize(){
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library", "root", "123477");
            st = conn.createStatement();
            st.execute("insert into islend (state)values(0)");
            st.execute("insert into islend (state)values(1)");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void lend(int bookid) {
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library", "root", "123477");
            st = conn.createStatement();
            String sql = "update book set state=1 where bookid ="+bookid;
            st.executeUpdate(sql);
            System.out.println("成功借出");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void giveback(int bookid){
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library", "root", "123477");
            st = conn.createStatement();
            String sql = "update book set state=0 where bookid ="+bookid;
            st.executeUpdate(sql);
            System.out.println("成功归还");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public IsLend(int bookid) {
        this.bookid = bookid;
    }
}

package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query {
    public void querybook(){//列出所有书籍
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library", "root", "123477");
            st = conn.createStatement();
            String sql = "select * from book";
            rs = st.executeQuery(sql);
            System.out.println("书本ID 书名 是否借出 作者ID");
            System.out.println("——————0代表还没借出，1代表已经借出——————");
            while (rs.next()){
                String bookid = rs.getString("bookid");
                String bookname = rs.getString("bookname");
                String state = rs.getString("state");
                String authorID = rs.getString("authorID");
                System.out.println(bookid+", "+bookname+", "+state+", "+authorID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
            }catch (Exception e){
            }try{
                if(st != null){
                    st.close();
                }
            }catch (Exception e){
            }try{
                if(conn != null){
                    conn.close();
                }
            }catch (Exception e){
            }
        }
    }

    public void authorbook(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library", "root", "123477");
            st = conn.createStatement();
            String sql = "select t.author,b.authorID,b.bookname from t_author t join book b where t.authorID = b.authorID";
            rs = st.executeQuery(sql);
            System.out.println("作者ID 作者名");
            while (rs.next()){
                String authorID = rs.getString("authorID");
                String author = rs.getString("author");
                String bookname = rs.getString("bookname");
                System.out.println(authorID+", "+author+", "+bookname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
            }catch (Exception e){
            }try{
                if(st != null){
                    st.close();
                }
            }catch (Exception e){
            }try{
                if(conn != null){
                    conn.close();
                }
            }catch (Exception e){
            }
        }
    }

    public void Fuzzyquery(String A){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library", "root", "123477");
            st = conn.createStatement();
            String sql = "select bookid,bookname,authorID from book where bookname like '"+A+"%'";
            rs = st.executeQuery(sql);
            System.out.println("书本id, 书本名称 , 作者ID");
            while (rs.next()){
                String bookid = rs.getString("bookid");
                String bookname = rs.getString("bookname");
                String authorID = rs.getString("authorID");
                System.out.println(bookid+", "+bookname+", "+authorID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if(rs != null){
                    rs.close();
                }
            }catch (Exception e){
            }try{
                if(st != null){
                    st.close();
                }
            }catch (Exception e){
            }try{
                if(conn != null){
                    conn.close();
                }
            }catch (Exception e){
            }
        }
    }
}

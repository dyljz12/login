
import java.sql.*;


public class DBUtil {
    //mysql驱动包名
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //数据库连接地址
    private static final String URL = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=JavaWeb";
    //用户名
    private static final String USER_NAME = ".";
    //密码
    private static final String PASSWORD = "";

    public static Connection getConnection(){
        try {
            //加载mysql的驱动类
            Class.forName(DRIVER_NAME);
            //获取数据库连接
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConn(Connection conn,Statement stm , ResultSet rs ){
        if(stm!=null){
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        System.out.println(getConnection());
    }
}

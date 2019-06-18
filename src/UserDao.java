import java.sql.*;

public class UserDao {
    //根据用户名查找用户
    public User findUserByName(String userName){
        //编写sql语句
        String sql="select * from user where userName=?";
        //获得连接
        Connection conn= DBUtil.getConnection();
        //有返回的结果
        ResultSet rs= null;
        //实例化一个User对象
        User user = new User();
        try {
            //用来发送sql语句的
            PreparedStatement ps = conn.prepareStatement(sql);
            //设置要传入的参数，这里是userN
            ps.setString(1, userName);
            //执行sql语句
            rs=ps.executeQuery();
            //如果能找到结果
            if(rs.next()){
                //则把找到的结果一一set进User对象中
                user.setUserName(rs.getString(1));
                user.setPassWord(rs.getString(2));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {//关闭连接
            DBUtil.closeConn(conn, null, rs);
        }
        //最后要把这个user返回出去
        return user;
    }

//    public static void main(String[] args) {
//        UserDao dao = new UserDao();
//        User i = dao.findUserByName("test");
//        System.out.println(i.getPassWord());
//    }
}

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "LoginServlet",urlPatterns="/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // 在本电脑的D:\java-jdk8\bin路径下放入了sqljdbc_auth.dll文件；解决了登录不成功问题
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获取从页面中提交过来的数据
        String userName = request.getParameter("userName");
        String userPass = request.getParameter("passWord");

        LoginService service = new LoginService();
        //调用service方法 把用户名 密码传入给service
        boolean flag = service.checkUser(userName, userPass);
        String msg = flag?"success":"error";

        request.setAttribute("msg", msg);
        if(msg=="success"){
            request.getRequestDispatcher("login_success.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("login_failure.jsp").forward(request, response);
        }
    }
}

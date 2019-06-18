<%--
  Created by IntelliJ IDEA.
  User: Chinalife
  Date: 2019/6/18
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div id="container" style="width: 300px;margin: 0px auto">
    <div id="box">
      <form action="LoginServlet" methods="post">
        <div class="main">
          <div>
            <label>用户名：</label>
            <input name="userName" value="">
          </div>
          <div>
            <label>密码：</label>
            <input type="passWord" name="passWord" value="">
          </div>
          <div>
            <input type="submit" value="登录">
          </div>
        </div>
      </form>
    </div>
  </div>
  </body>
</html>

public class LoginService {
    public boolean checkUser(String userName, String passWord) {
        UserDao dao = new UserDao();
        User user = dao.findUserByName(userName);
        System.out.println(user);
        return user != null && passWord.equals(user.getPassWord()) ? true : false;
    }
}

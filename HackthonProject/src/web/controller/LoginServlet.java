package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.IUserService;
import service.impl.UserServiceImpl;

/**
 * 澶勭悊鐢ㄦ埛鐧诲綍鐨剆ervlet
 * @author gacl
 *
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//鑾峰彇鐢ㄦ埛濉啓鐨勭櫥褰曠敤鎴峰悕
		String username = request.getParameter("username");
		//鑾峰彇鐢ㄦ埛濉啓鐨勭櫥褰曞瘑鐮�
		String password = request.getParameter("password");
		
		IUserService service = new UserServiceImpl();
		//鐢ㄦ埛鐧诲綍
		User user = service.loginUser(username, password);
		if(user==null){
			String message = String.format(
					"对不起，用户名或密码有误！！请重新登录！2秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='2;url=%s'", 
					request.getContextPath()+"/servlet/LoginUIServlet");
			request.setAttribute("message",message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		//鐧诲綍鎴愬姛鍚庯紝灏卞皢鐢ㄦ埛瀛樺偍鍒皊ession涓�
		request.getSession().setAttribute("user", user);
		String message = String.format(
				"恭喜：%s,登陆成功！本页将在3秒后跳到首页！！<meta http-equiv='refresh' content='3;url=%s'", 
				user.getUserName(),
				request.getContextPath()+"/index.jsp");
		request.setAttribute("message",message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import domain.User;
import exception.UserExistException;
import service.IUserService;
import service.impl.UserServiceImpl;
import util.WebUtils;
import web.formbean.RegisterFormBean;

/**
 * 澶勭悊鐢ㄦ埛娉ㄥ唽鐨凷ervlet
 * @author gacl
 *
 */
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//灏嗗鎴风鎻愪氦鐨勮〃鍗曟暟鎹皝瑁呭埌RegisterFormBean瀵硅薄涓�
		RegisterFormBean formbean = WebUtils.request2Bean(request,RegisterFormBean.class);
		//鏍￠獙鐢ㄦ埛娉ㄥ唽濉啓鐨勮〃鍗曟暟鎹�
		if (formbean.validate() == false) {//濡傛灉鏍￠獙澶辫触
			//灏嗗皝瑁呬簡鐢ㄦ埛濉啓鐨勮〃鍗曟暟鎹殑formbean瀵硅薄鍙戦�佸洖register.jsp椤甸潰鐨刦orm琛ㄥ崟涓繘琛屾樉绀�
			request.setAttribute("formbean", formbean);
			//鏍￠獙澶辫触灏辫鏄庢槸鐢ㄦ埛濉啓鐨勮〃鍗曟暟鎹湁闂锛岄偅涔堝氨璺宠浆鍥瀝egister.jsp
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
			return;
		}

		User user = new User();
		try {
			// 娉ㄥ唽瀛楃涓插埌鏃ユ湡鐨勮浆鎹㈠櫒
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(user, formbean);//鎶婅〃鍗曠殑鏁版嵁濉厖鍒癹avabean涓�
			user.setId(WebUtils.makeId());//璁剧疆鐢ㄦ埛鐨処d灞炴��
			IUserService service = new UserServiceImpl();
			//璋冪敤service灞傛彁渚涚殑娉ㄥ唽鐢ㄦ埛鏈嶅姟瀹炵幇鐢ㄦ埛娉ㄥ唽
			service.registerUser(user);
			String message = String.format(
					"注册成功！！3秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='3;url=%s'/>", 
					request.getContextPath()+"/servlet/LoginUIServlet");
			request.setAttribute("message",message);
			request.getRequestDispatcher("/message.jsp").forward(request,response);

		} catch (UserExistException e) {
			formbean.getErrors().put("userName", "注册用户已存在！！");
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(); // 鍦ㄥ悗鍙拌褰曞紓甯�
			request.setAttribute("message", "对不起，注册失败！！");
			request.getRequestDispatcher("/message.jsp").forward(request,response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

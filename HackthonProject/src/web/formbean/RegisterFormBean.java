package web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

/**
 * 鐏忎浇顥婇惃鍕暏閹撮攱鏁為崘宀冦�冮崡鏄〆an閿涘瞼鏁ら弶銉﹀复閺�绉梕gister.jsp娑擃厾娈戠悰銊ュ礋鏉堟挸鍙嗘い鍦畱閸婏拷
 * RegisterFormBean娑擃厾娈戠仦鐐达拷褌绗宺egister.jsp娑擃厾娈戠悰銊ュ礋鏉堟挸鍙嗘い鍦畱name娑擄拷娑擄拷鐎电懓绨�
 * RegisterFormBean閻ㄥ嫯浜寸拹锝夋珟娴滃棜绀嬬拹锝嗗复閺�绉梕gister.jsp娑擃厾娈戠悰銊ュ礋鏉堟挸鍙嗘い鍦畱閸婇棿绠ｆ径鏍箷閹峰懍鎹㈤惈锟介弽锟犵崣鐞涖劌宕熸潏鎾冲弳妞ゅ湱娈戦崐鑲╂畱閸氬牊纭堕幀锟�
 * @author gacl
 *
 */
public class RegisterFormBean {

	//RegisterFormBean娑擃厾娈戠仦鐐达拷褌绗宺egister.jsp娑擃厾娈戠悰銊ュ礋鏉堟挸鍙嗘い鍦畱name娑擄拷娑擄拷鐎电懓绨�
	//<input type="text" name="userName"/>
	private String userName;
	//<input type="password" name="userPwd"/>
	private String userPwd;
	//<input type="password" name="confirmPwd"/>
	private String confirmPwd;
	//<input type="text" name="email"/>
	private String email;
	//<input type="text" name="birthday"/>
	private String birthday;

	
	/**
	 * 鐎涙ê鍋嶉弽锟犵崣娑撳秹锟芥俺绻冮弮鍓佺舶閻€劍鍩涢惃鍕晩鐠囶垱褰佺粈杞颁繆閹拷
	 */
	private Map<String, String> errors = new HashMap<String, String>();

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	/*
	 * validate閺傝纭剁拹鐔荤煑閺嶏繝鐛欑悰銊ュ礋鏉堟挸鍙嗘い锟�
	 * 鐞涖劌宕熸潏鎾冲弳妞よ鐗庢宀冾潐閸掓瑱绱�
	 * 		private String userName; 閻€劍鍩涢崥宥勭瑝閼虫垝璐熺粚鐚寸礉楠炴湹绗栫憰浣规Ц3-8閻ㄥ嫬鐡уВ锟� abcdABcd 
	 * 		private String userPwd; 鐎靛棛鐖滄稉宥堝厴娑撹櫣鈹栭敍灞借嫙娑撴棁顩﹂弰锟�3-8閻ㄥ嫭鏆熺�涳拷
	 * 		private String confirmPwd; 娑撱倖顐肩�靛棛鐖滅憰浣风閼凤拷
	 * 		private String email; 閸欘垯浜掓稉铏光敄閿涘奔绗夋稉铏光敄鐟曚焦妲告稉锟芥稉顏勬値濞夋洜娈戦柇顔绢唸 
	 * 		private String birthday; 閸欘垯浜掓稉铏光敄閿涘奔绗夋稉铏光敄閺冭绱濈憰浣规Ц娑擄拷娑擃亜鎮庡▔鏇犳畱閺冦儲婀�
	 */
	public boolean validate() {

		boolean isOk = true;

		if (this.userName == null || this.userName.trim().equals("")) {
			isOk = false;
			errors.put("userName", "用户名不能为空！！");
		} else {
			if (!this.userName.matches("[a-zA-Z]{3,8}")) {
				isOk = false;
				errors.put("userName", "用户名必须是3-8位的字母！！");
			}
		}

		if (this.userPwd == null || this.userPwd.trim().equals("")) {
			isOk = false;
			errors.put("userPwd", "密码不能为空！！");
		} else {
			if (!this.userPwd.matches("\\d{3,8}")) {
				isOk = false;
				errors.put("userPwd", "密码必须是3-8位的数字！！");
			}
		}

		// private String password2; 娑撱倖顐肩�靛棛鐖滅憰浣风閼凤拷
		if (this.confirmPwd != null) {
			if (!this.confirmPwd.equals(this.userPwd)) {
				isOk = false;
				errors.put("confirmPwd", "两次密码不一致！！");
			}
		}

		// private String email; 閸欘垯浜掓稉铏光敄閿涘奔绗夋稉铏光敄鐟曚焦妲告稉锟芥稉顏勬値濞夋洜娈戦柇顔绢唸
		if (this.email != null && !this.email.trim().equals("")) {
			if (!this.email.matches("\\w+@\\w+(\\.\\w+)+")) {
				isOk = false;
				errors.put("email", "邮箱不是一个合法邮箱！！");
			}
		}

		// private String birthday; 閸欘垯浜掓稉铏光敄閿涘奔绗夋稉铏光敄閺冭绱濈憰浣规Ц娑擄拷娑擃亜鎮庡▔鏇犳畱閺冦儲婀�
		if (this.birthday != null && !this.birthday.trim().equals("")) {
			try {
				DateLocaleConverter conver = new DateLocaleConverter();
				conver.convert(this.birthday);
			} catch (Exception e) {
				isOk = false;
				errors.put("birthday", "生日必须要是一个日期！！");
			}
		}

		return isOk;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}

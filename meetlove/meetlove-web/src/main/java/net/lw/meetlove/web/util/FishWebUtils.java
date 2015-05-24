package net.lw.meetlove.web.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.lw.meetlove.api.service.ISystemArgsService;

import org.springframework.beans.factory.annotation.Autowired;



/**
 *
 * @author liuwei
 * @version
 * @since
 * @date 2011-4-26
 */
public class FishWebUtils {

	public static String resourceRootPath = "";
	public static String resourceImgPath = "";

	public static final String USER = "SESSION_USER";

	public static boolean isIgnoreRequestName(String name) {
		return "page".equals(name) || "start".equals(name) || "limit".equals(name) || "_dc".equals(name);
	}
	/**
	 * 获得web上下文tmp的实际目录
	 * @param request
	 * @return
	 */
	public static String getRealPathByTmp(HttpServletRequest request){
	    return request.getSession().getServletContext().getRealPath("/tmp");
	}

	public static UserSession getUserSession(HttpServletRequest request){
		return (UserSession)request.getSession().getAttribute(FishWebUtils.USER);
	}

	public static long getSessionUserId(HttpServletRequest request){
		return FishWebUtils.getUserSession(request).getUserId();
	}

	public static String createFileName(String fileName){
		return (new Date()).getTime()+fileName.substring(fileName.lastIndexOf("."));
	}

	public static void main(String[] args) {
		String fileName = "123.jpg";
		System.out.println(createFileName(fileName));
	}

}

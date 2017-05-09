package check.x.com.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class SSOUtil {
    public static final String USER = "jeff";
    public static final String PASSWORD = "abc123_";

    public static boolean checkLogin(String username, String password) {
        if (username.equals(USER) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkCookie(String cookieName, String cookieValue) {
        if (cookieName.equals("ssoCookie") && cookieValue.equals("sso")) {
            return true;
        }
        return false;
    }
}

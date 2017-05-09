package com.sso.project.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class SSOUtil {
    public static final String USER = "jeff";
    public static final String PASSWORD ="abc123_";
    public static boolean checkLogin(String username, String password) {
        if (username.equals(USER) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean checkCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("ssoCookie")
                        &&cookie.getValue().equals("sso")){
                    return true;
                }
            }
        }
        return false;
    }
}

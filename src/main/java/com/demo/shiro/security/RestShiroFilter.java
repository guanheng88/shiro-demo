package com.demo.shiro.security;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.AccessControlFilter;

public class RestShiroFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String sessionId = request.getParameter("token");
        UsernamePasswordToken token2 = new UsernamePasswordToken(sessionId, sessionId);
        try {
            // 委托给Realm进行登录
            if (sessionId != null) {
                getSubject(request, response).login(token2);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            // 登录失败
            onLoginFail(response);
            return false;
        }
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        String sessionId = request.getParameter("token");
        UsernamePasswordToken token2 = new UsernamePasswordToken(sessionId, sessionId);
        try {
            // 委托给Realm进行登录
            if (sessionId != null) {
                getSubject(request, response).login(token2);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            // 登录失败
            onLoginFail(response);
            return false;
        }
        return true;
    }

    // 登录失败时默认返回401状态码
    private void onLoginFail(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.getWriter().write("login error");
    }
}

package com.example.mnm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.util.WebUtils;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.Login;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("[LoginInterceptor INFO] preHandle()");
        Account account = (Account)WebUtils.getSessionAttribute(request, "account");
        if (account == null) {
        	String url = request.getRequestURL().toString(); 
        	String query = request.getQueryString();
        	ModelAndView modelAndView = new ModelAndView();
        	modelAndView.setViewName("LoginForm");
			if (query != null) {
				modelAndView.addObject("login", new Login());
				modelAndView.addObject("signonForwardAction", url+"?"+query);
			}  
			else {
				modelAndView.addObject("login", new Login());
				modelAndView.addObject("signonForwardAction", url);
			}
			throw new ModelAndViewDefiningException(modelAndView);
		}
		else {
			return true;
		}
	}

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("[LoginInterceptor INFO] postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex) throws Exception {
        logger.info("[LoginInterceptor INFO] afterCompletion()");
    }
}
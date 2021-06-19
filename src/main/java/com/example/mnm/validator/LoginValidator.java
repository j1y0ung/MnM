package com.example.mnm.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.Login;

public class LoginValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Account.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		Login login = (Login) target;
		
		ValidationUtils.rejectIfEmpty(errors, "userId", "blank.userId");
		ValidationUtils.rejectIfEmpty(errors, "pwd", "blank.pwd");
		
//		String inputid = login.getUserId();
//		String inputpwd = login.getPwd();
//		
//		if(login.hasAccount(inputid) == false) {
//			errors.rejectValue("userId", "noAccount");
//		}
//		if(login.matchpwd(inputid, inputpwd)) {
//			errors.rejectValue("pwd", "idPasswordNotMatching");
//		}
	}
	
	public void checkAccount(Object target, Errors errors) {
//		Login login = (Login) target;
		errors.rejectValue("userId", "noAccount");
	}
	
	public void checkPwd(Object target, Errors errors) {
		errors.rejectValue("pwd", "idPasswordNotMatching");
	}
}

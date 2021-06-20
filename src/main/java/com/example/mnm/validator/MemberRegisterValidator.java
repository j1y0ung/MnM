package com.example.mnm.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.mnm.domain.Account;

public class MemberRegisterValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Account.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		Account account = (Account) target;
		
		ValidationUtils.rejectIfEmpty(errors, "userid", "NotNull");
		ValidationUtils.rejectIfEmpty(errors, "pwd", "NotNull");
		ValidationUtils.rejectIfEmpty(errors, "pwdconfirm", "NotNull");
		ValidationUtils.rejectIfEmpty(errors, "name", "NotNull");
		ValidationUtils.rejectIfEmpty(errors, "email", "NotNull");
		ValidationUtils.rejectIfEmpty(errors, "addr", "NotNull");
		
		if(!account.isSamePwdConfirmPwd()) {
			errors.rejectValue("pwdconfirm", "nomatch");
		}
		if(account.getPhone2() == "" || account.getPhone3() == "") {
			errors.rejectValue("phone3", "NotNull");
		}
	}
}

package com.hai.util;

import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.hai.iservice.IVerifyAccountTokenService;

@Component
public class SendingEmailUtilImpl implements SendingEmailUtil {

	@Autowired
	public JavaMailSender emailSender;
	@Autowired
	public BCryptPasswordEncoder encoder;
	@Autowired
	public IVerifyAccountTokenService verifyAccount;
	@Autowired
	public ServletContext servletContext;

	Logger LOGGER = Logger.getLogger(SendingEmailUtilImpl.class);

	@Override
	public boolean sendEmailVerifyAccount(String toEmail) {
		LOGGER.info("Call send Email");
		try {
			String link = getVerifyLink(toEmail);
			String token = getToken(toEmail);
			
			// save token
			verifyAccount.saveVerifyToken(token, toEmail);
			
			// Send email
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(toEmail);
			message.setSubject("VERIFICATION USER ACCOUNT");
			message.setText("Hi \n" + toEmail + ": \n Please click link below to verify your account.\n" + link+token
					+ "\n Thank you!");
			emailSender.send(message);
			
			return true;
		} catch (Exception e) {
			LOGGER.error("Can't send email to user");
			return false;
		}

	}

	// Helper function
	public String getVerifyLink(String email) {
		System.out.println("------------------------"+servletContext.getContextPath());
		String link = "http://localhost:8080"+servletContext.getContextPath()+"/verifyAccount?verifyToken=";
		return link;
	}

	public String getToken(String email) {
		return encoder.encode(email + UUID.randomUUID());
	}

}

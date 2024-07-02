package com.files.methods;


import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class OtpGenerate {
	
	
	public String generateOtp() {
		int otplength=4;
		String numbers="0123456789";		
//		StringBuilder otp2=new StringBuilder(otplength);	
		String otp="";		
		Random rd=new Random();
		for (int i=0; i< otplength; i++) {
			int index=rd.nextInt(numbers.length());
//			char digits=numbers.charAt(index);
//			otp2.append(digits);
			otp+=numbers.charAt(index);	
		}
//		return otp2.toString();	
		return otp;
	}
	public boolean sendMail(String otp,String to,String msg) {	
		boolean status=false;
		final String from="akaah2252@gmail.com";
		final String pass="lxlf zybl mwow slhj";
		String subject="OTP verification";	
		Properties prop=new Properties();
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.host","smtp.gmail.com");
		prop.put("mail.smtp.port",587);
		prop.put("mail.transport.protocol", "smtp");
		
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(from, pass);
	            }
	     });
		 
		try {
			
			MimeMessage mm=new MimeMessage(session);
			mm.setFrom(new InternetAddress(from));
			mm.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mm.setSubject(subject);
			mm.setText(msg);
			
			

			Transport.send(mm);
			status=true;
			
			System.out.println("Email sent succesfully");
		}catch (MessagingException e){
			System.out.println(e);
		}
		return status;
	}
}

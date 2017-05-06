package com.hitesh.learn.problemsolving.old;
//package examples;
//
//import java.util.Properties;
//
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//
//public class PostMail {  
//  
//  
// private String SMTP_AUTH_USER;  
// private String SMTP_AUTH_PWD;  
//        public void postMail(String SMTP_AUTH_USER, String SMTP_AUTH_PWD, String SMTP_HOST_NAME, String recipientsTo[], String recipientsCC[], String recipientsBCC[], String subject, String message,  
//    String from) throws MessagingException {  
//    boolean debug = false;  
//    com.sun.net.ssl.internal.ssl.Provider pvd= new com.sun.net.ssl.internal.ssl.Provider();
//    java.security.Security.addProvider(pvd); 
//  
//                this.SMTP_AUTH_USER = SMTP_AUTH_USER;  
//                this.SMTP_AUTH_PWD = SMTP_AUTH_PWD;  
//  
//    //Set the host smtp address  
//    Properties props = new Properties();  
//    props.put("mail.transport.protocol", "smtp");  
//    props.put("mail.smtp.starttls.enable","true");  
//    props.put("mail.smtp.host", SMTP_HOST_NAME);  
//    props.put("mail.smtp.auth", "true");  
//        props.put("mail.smtp.port", "465");  
//        props.put("mail.smtp.ssl.enable", "true");  
//  
//  
//    Authenticator auth = new SMTPAuthenticator();  
//    Session session = Session.getDefaultInstance(props, auth);  
//  
//    session.setDebug(debug);  
//  
//    // create a message  
//    Message msg = new MimeMessage(session);  
//  
//    // set the from and to address  
//    InternetAddress addressFrom = new InternetAddress(from);  
//    msg.setFrom(addressFrom);  
//  
//    InternetAddress[] addressTo = new InternetAddress[recipientsTo.length];  
//    for (int i = 0; i < recipientsTo.length; i++) {  
//    addressTo[i] = new InternetAddress(recipientsTo[i]);  
//    }  
//    msg.setRecipients(Message.RecipientType.TO, addressTo);  
//  
//  
//    // Setting the Subject and Content Type  
//  
//  
//                msg.setSubject(subject);  
//    msg.setContent(message, "text/html");  
//    Transport.send(msg);  
//        System.out.println("successfully sent the mail");  
//    }  
//  
//  
//     public class SMTPAuthenticator extends javax.mail.Authenticator {  
//  
//    public PasswordAuthentication getPasswordAuthentication() {  
//  
//    String username = SMTP_AUTH_USER;  
//    String password = SMTP_AUTH_PWD;  
//    return new PasswordAuthentication(username, password);  
//    }  
//    }  
//}  
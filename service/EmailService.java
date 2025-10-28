package com.deepinsta.service;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.deepinsta.modal.ContactBody;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;


    public void sendHtmlEmail(String to, String subject, String htmlBody) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        helper.setFrom("shoopdeep5@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true); // Enable HTML

        mailSender.send(message);
    }
    
    public void sendCode(String to, String subject, String htmlBody) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        helper.setFrom("shoopdeep5@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody,true); // Enable HTML

        mailSender.send(message);
    }
    
    
    public void sendMessageContact(ContactBody body) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        helper.setFrom(body.getEmail());
        helper.setTo("shoopdeep5@gmail.com");
        helper.setSubject(body.getSubject());
        body.setMessage( "<!DOCTYPE html>" +
        	    "<html>" +
        	    "<body style='font-family: Arial, sans-serif; background-color: #ffffff; padding: 20px;'>" +
        	    "  <table width='100%' cellspacing='0' cellpadding='0' border='0' align='center'>" +
        	    "    <tr>" +
        	    "      <td align='center'>" +
        	    "        <table width='600' cellpadding='0' cellspacing='0' style='background-color: #EDE0D4; border-radius: 20px; padding: 40px;'>" +
        	    "          <tr>" +
        	    "            <td style='font-size: 22px; color: #5a3c28;'>Dear DeepShop,</td>" +
        	    "          </tr>" +
        	    "          <tr>" +
        	    "            <td style='padding: 20px 0; font-size: 16px; color: #333333; line-height: 1.5;'>" +
        	    body.getMessage() +
        	    "            </td>" +
        	    "          </tr>" +
        	    "          <tr>" +
        	    "            <td style='padding-top: 30px; font-size: 16px; color: #5a3c28;'>Sincerely,</td>" +
        	    "          </tr>" +
        	    "          <tr>" +
        	    "            <td style='font-size: 18px; font-weight: bold; color: #5a3c28;'>" +
        	    body.getFirstName() + " " + body.getLastName() +
        	    "            </td>" +
        	    "          </tr>" +
        	    "            <td style='font-size: 18px; font-weight: bold; color: #5a3c28;'>" +
        	    "Email from: "+ body.getEmail()+
        	    "            </td>" +
        	    "        </table>" +
        	    "      </td>" +
        	    "    </tr>" +
        	    "  </table>" +
        	    "</body>" +
        	    "</html>");
        helper.setText(body.getMessage(), true); // Enable HTML
        
         mailSender.send(message);
    }
}
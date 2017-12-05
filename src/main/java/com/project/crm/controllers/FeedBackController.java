package com.project.crm.controllers;

import com.project.crm.model.Email;
import com.project.crm.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Controller
public class FeedBackController {
    @Autowired
    EmailValidator emailValidator;

    @RequestMapping(value="/feedback", method= RequestMethod.GET)
    public String getMethodFeedBack(Model model) {
        return "feedback";
    }

    @RequestMapping(value="/feedback", method= RequestMethod.POST)
    public String sendFeedBack(@ModelAttribute ("Email") Email email,
                               BindingResult bindingResult, Model model) {
        emailValidator.validate(email, bindingResult);
        if (bindingResult.hasErrors()) {
            return "feedback";
        }
        Properties messageProperties = System.getProperties();
        messageProperties.put("mail.smtp.host", "smtp.gmail.com");
        messageProperties.put("mail.smtp.socketFactory.port", "465");
        messageProperties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        messageProperties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(messageProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "netcufar@gmail.com", "nfvu&#h#DGFh2");
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            model.addAttribute("Email", email);
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("netcufar@gmail.com"));
            mimeMessage.setSubject(email.getTitle());
            mimeMessage.setText("User email: " + email.getFrom() + "\nMessage: " + email.getMessage());
            Transport.send(mimeMessage);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return "redirect: /account";
    }
}

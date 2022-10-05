package com.example.springboottut1.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender)
    {
        this.javaMailSender = javaMailSender;
    }


    public void sendEmailToList(String[] emails, String message){
        SimpleMailMessage emailToSend = new SimpleMailMessage();
        emailToSend.setText(message);
        emailToSend.setReplyTo("no-reply@course-management-system.com");
        emailToSend.setFrom("no-reply@course-management-system.com");
        emailToSend.setSubject("Message from Course Instructor");
        emailToSend.setTo(emails);
        javaMailSender.send(emailToSend);
    }

}

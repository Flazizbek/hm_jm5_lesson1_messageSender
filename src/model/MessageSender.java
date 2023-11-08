package model;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Properties;

public class MessageSender {
    public void senderOneToOne(String recipientsAcc, String message) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable","true");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication
                        ("lazizbek.fayzullayev.17@gmail.com",
                                "sfmzoetglljqdnkd");
            }
        };
        Session session = Session.getInstance(props, authenticator);
        MimeMessage message1 = new MimeMessage(session);
        message1.setFrom(new InternetAddress("d0d70794c9fda4"));
        message1.setRecipient(Message.RecipientType.TO,new InternetAddress(recipientsAcc));
        message1.setSubject("Testing project");
        message1.setText(message);
        Transport.send(message1);
    }

    public void senderOneToMany(ArrayList<String> recipientsAcc, String message) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable","true");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication
                        ("lazizbek.fayzullayev.17@gmail.com",
                                "sfmzoetglljqdnkd");
            }
        };
            Session session = Session.getInstance(props, authenticator);
            MimeMessage message1 = new MimeMessage(session);
            message1.setFrom(new InternetAddress("lazizbek.fayzullayev.17@gmail.com"));
        for (int i = 0; i < recipientsAcc.size(); i++) {
            message1.setRecipient(Message.RecipientType.TO,new InternetAddress(recipientsAcc.get(i)));
            message1.setSubject("Testing project");
            message1.setText(message);
            Transport.send(message1);
        }

    }
}

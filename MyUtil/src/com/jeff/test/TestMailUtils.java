package com.jeff.test;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;

import org.junit.Test;

import com.jeff.mail.util.Mail;
import com.jeff.mail.util.MailUtils;

public class TestMailUtils {

    @Test
    public void testSend() throws AddressException, MessagingException, IOException{
        Mail mail = new Mail("mywr1026@163.com", "mywr1026@163.com","test","test");
        Session session = MailUtils.createSession("smtp.163.com", "mywr1026@163.com", "921013mywr");
        MailUtils.send(session, mail);
    }
}

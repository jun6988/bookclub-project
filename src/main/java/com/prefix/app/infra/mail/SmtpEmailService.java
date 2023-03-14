package com.prefix.app.infra.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SmtpEmailService implements EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public SmtpEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

//    @Override
//    public void sendEmail(Email email) throws MessagingException {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//        helper.setFrom(email.getFrom());
//
//        for (EmailRecipient recipient : email.getRecipients()) {
//            helper.addTo(recipient.getEmailAddress());
//        }
//
//        helper.setSubject(email.getSubject());
//        helper.setText(email.getContent().getBody(), true);
//
//        for (EmailContent attachment : email.getContent().getAttachments()) {
//            helper.addAttachment(attachment.getFilename(), attachment.getFile());
//        }
//
//        mailSender.send(mimeMessage);
//    }

	@Override
	public void sendEmail(EmailMessage emailMessage) {
		// TODO Auto-generated method stub
		
	}
}
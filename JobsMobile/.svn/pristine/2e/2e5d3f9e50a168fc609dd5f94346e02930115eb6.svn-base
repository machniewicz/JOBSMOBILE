package br.com.jobs.mail;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import android.util.Log;
import br.com.jobs.modelo.Curriculo;

public class MailSender {
	

	// cria as propriedades necessárias para o envio de email
	public void senderMail(final Mail mail, Curriculo curriculo)
			throws UnsupportedEncodingException, MessagingException {

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", mail.getSmtpHostMail());
		props.setProperty("mail.smtp.auth", mail.getSmtpAuth());
		props.setProperty("mail.smtp.starttls.enable", mail.getSmtpStarttls());
		props.setProperty("mail.smtp.port", mail.getSmtpPortMail());
		props.setProperty("mail.mime.charset", mail.getCharsetMail());

		// classe anonima que realiza a autenticação
		// do usuario no servidor de email.
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mail.getUserMail(),
						mail.getPassMail());
				}
		
		};

		// Cria a sessao passando as propriedades e a autenticação
		Session session = Session.getDefaultInstance(props, auth);
		// Gera um log no console referente ao processo de envio
		session.setDebug(true);

		// cria a mensagem setando o remetente e seus destinatários
		Message msg = new MimeMessage(session);
		// aqui seta o remetente
		msg.setFrom(new InternetAddress(mail.getUserMail(), mail
				.getFromNameMail()));
		boolean first = true;
		for (Map.Entry<String, String> map : mail.getToMailsUsers().entrySet()) {
			if (first) {
				// setamos o 1° destinatario
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
						map.getKey(), map.getValue()));
				first = false;
			} else {
				// setamos os demais destinatarios
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(
						map.getKey(), map.getValue()));
			}
		}

		// Adiciona um Assunto a Mensagem
		msg.setSubject(mail.getSubjectMail());

		// Cria o objeto que recebe o texto do corpo do email
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent(mail.getBodyMail(), mail.getTypeTextMail());

		MailcapCommandMap mailmap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
		mailmap.addMailcap("multipart/mixed;;x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		
		// Monta a mensagem SMTP inserindo o conteudo, texto e anexos
		Multipart mps = new MimeMultipart();

		// Cria um novo objeto para cada arquivo, e anexa o arquivo
		
		MimeBodyPart attachFilePart = new MimeBodyPart();
		attachFilePart.setDataHandler(new DataHandler(new ByteArrayDataSource(curriculo.getCurriculo_arquivo(), "application/octet-stream")));  
		attachFilePart.setFileName("arquivo.doc");
			
		// adiciona o anexo da mensagem
		mps.addBodyPart(attachFilePart);

		// adiciona o corpo texto da mensagem
		mps.addBodyPart(textPart);

		// adiciona a mensagem o conte�do texto e anexo
		msg.setContent(mps);

		// Envia a Mensagem
		Transport.send(msg);
	}

	public void EnviarMail(Curriculo curriculo) {
		Mail mj = new Mail();
		/*
		 * Configuracoes de envio
		 * 
		 * Arquivo Properties de configuração de e-mail
		 */
		mj.setSmtpHostMail("smtp.gmail.com");
		mj.setSmtpPortMail("587");
		mj.setSmtpAuth("true");
		mj.setSmtpStarttls("true");
		mj.setUserMail("nilson.andre@gmail.com");
		mj.setFromNameMail("Nilson");
		mj.setPassMail("senha2795584730");
		mj.setCharsetMail("ISO-8859-1");

		/*
		 * Arquivo properties de internacionalização
		 */

		mj.setSubjectMail("Teste Jobs Mobile");
		mj.setBodyMail(htmlMessage());
		mj.setTypeTextMail(Mail.TYPE_TEXT_HTML);

		// sete quantos destinatarios desejar
		Map<String, String> map = new HashMap<String, String>();
		map.put("nilson@4usolucoes.com.br", "Nilson 4U");
		mj.setToMailsUsers(map);

		// seta quatos anexos desejar
	//	List<String> files = new ArrayList<String>();
	//	mj.setFileMails(files);

		try {
			new MailSender().senderMail(mj, curriculo);
			Log.i("E-mail", "Sucesso");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			Log.i("E-mail", "Falha 1");
		} catch (MessagingException e) {
			e.printStackTrace();
			Log.i("E-mail", "Falha 2");
		}
	}

	private String htmlMessage() {
		String htmlMessage = null;
		htmlMessage = "<html>" + "<head>" + "<title>"
				+ "</title>"
				+ "</head>"
				+ "<body>"
				+ "<div align=center style='background-color:#FFD700; width:100%; height:20px; font-size: medium; font-family: Arial;'>"
				+ "<b>"
				+ "</b>"
				+ "</div><div align=center style='background-color:#E8E8E8; width:100%; height:300px;'>"
				+ "<br>"
				+ "<br>"
				+ "<br><b>"
				+ "</b>"
				+ "<br>"+"Nilson André"+"<b>"
				+ "</b>"
				+ "<br>"
				+ "</br>"
				+ "</div><div align=center style='background-color:#FFD700; width:100%; height:20px; font-size:xx-small; font-family: Arial;'>"
				+ "</div></body></html>";
		return htmlMessage;
	}

}

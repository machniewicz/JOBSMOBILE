package br.com.jobs.mail;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

//import javax.activation.DataHandler;
//import javax.activation.FileDataSource;
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

import br.com.jobs.modelo.cadastro.Cadastro;
import br.com.jobs.modelo.usuario.Usuario;
import br.com.jobs.web.util.FacesUtil;

public class MailSender {
	private FacesUtil faces = new FacesUtil();
	private static ResourceBundle b = ResourceBundle
			.getBundle("br.com.jobs.mail.mail_conf");
	public ResourceBundle bundle = ResourceBundle.getBundle(
			"br.com.jobs.idioma.messages", faces.carregaLocale());

	// cria as propriedades necessárias para o envio de email
	public void senderMail(final Mail mail)
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

		// Monta a mensagem SMTP inserindo o conteudo, texto e anexos
		Multipart mps = new MimeMultipart();
		for (int index = 0; index < mail.getFileMails().size(); index++) {

			// Cria um novo objeto para cada arquivo, e anexa o arquivo
			MimeBodyPart attachFilePart = new MimeBodyPart();
		//	FileDataSource fds = new FileDataSource(mail.getFileMails().get(
		//			index));
		//	attachFilePart.setDataHandler(new DataHandler(fds));
		//	attachFilePart.setFileName(fds.getName());

			// adiciona os anexos da mensagem
			mps.addBodyPart(attachFilePart, index);

		}

		// adiciona o corpo texto da mensagem
		mps.addBodyPart(textPart);

		// adiciona a mensagem o conte�do texto e anexo
		msg.setContent(mps);

		// Envia a Mensagem
		Transport.send(msg);
	}

	public void EnviarMail(Usuario usuario) {
		Mail mj = new Mail();
		/*
		 * Configuracoes de envio
		 * 
		 * Arquivo Properties de configuração de e-mail
		 */
		mj.setSmtpHostMail(b.getString("mail_server_smtp"));
		mj.setSmtpPortMail(b.getString("mail_porta_smtp"));
		mj.setSmtpAuth(b.getString("mail_auth_smtp"));
		mj.setSmtpStarttls(b.getString("mail_ttls_smtp"));
		mj.setUserMail(b.getString("mail_user_smtp"));
		mj.setFromNameMail(b.getString("mail_remetente_smtp"));
		mj.setPassMail(b.getString("mail_password_smtp"));
		mj.setCharsetMail(b.getString("mail_formato_smtp"));

		/*
		 * Arquivo properties de internacionalização
		 */

		mj.setSubjectMail(bundle.getString("mail_subject_smtp_recuperacao"));
		mj.setBodyMail(htmlMessage(usuario));
		mj.setTypeTextMail(Mail.TYPE_TEXT_HTML);

		// sete quantos destinatarios desejar
		Map<String, String> map = new HashMap<String, String>();
		map.put(usuario.getUsuario_email(), usuario.getUsuario_descricao());
		map.put(bundle.getString("mail_cc_smtp"),
				bundle.getString("mail_descricao_cc_smtp"));
		mj.setToMailsUsers(map);

		// seta quatos anexos desejar
		List<String> files = new ArrayList<String>();
		mj.setFileMails(files);

		try {
			new MailSender().senderMail(mj);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_usuario_email_sucesso"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			FacesUtil.exibirMensagemErro(bundle.getString("msg_usuario_email_falha"));
		} catch (MessagingException e) {
			e.printStackTrace();
			FacesUtil.exibirMensagemErro(bundle.getString("msg_usuario_email_falha"));
		}
	}

	private String htmlMessage(Usuario usuario) {
		String htmlMessage = null;
		htmlMessage = "<html>" + "<head>" + "<title>"
				+ bundle.getString("mail_title_smtp")
				+ "</title>"
				+ "</head>"
				+ "<body>"
				+ "<div align=center style='background-color:#FFD700; width:100%; height:20px; font-size: medium; font-family: Arial;'>"
				+ "<b>"
				+ bundle.getString("mail_subject_smtp_recuperacao")
				+ "</b>"
				+ "</div><div align=center style='background-color:#E8E8E8; width:100%; height:300px;'>"
				+ bundle.getString("mail_msg_comentario1_smtp")
				+ usuario.getUsuario_descricao()
				+ "<br>"
				+ bundle.getString("mail_msg_comentario2_smtp")
				+ "<br>"
				+ bundle.getString("mail_msg_comentario3_smtp")
				+ "<br><b>"
				+ bundle.getString("mail_msg_comentario4_smtp")
				+ usuario.getUsuario_login()
				+ "</b>"
				+ "<br><b>"
				+ bundle.getString("mail_msg_comentario5_smtp")
				+ usuario.getUsuario_senha()
				+ "</b>"
				+ "<br>"
				+ bundle.getString("mail_msg_comentatio6_smtp")
				+ "</br>"
				+ "</div><div align=center style='background-color:#FFD700; width:100%; height:20px; font-size:xx-small; font-family: Arial;'>"
				+ "<b>" + bundle.getString("mail_msg_rodape_smtp") + "</b>"
				+ "</div></body></html>";
		return htmlMessage;
	}

	public void EnviarMailCadastro(Cadastro cadastro) {
		Mail mj = new Mail();
		/*
		 * Configuracoes de envio
		 * 
		 * Arquivo Properties de configuração de e-mail
		 */
		mj.setSmtpHostMail(b.getString("mail_server_smtp"));
		mj.setSmtpPortMail(b.getString("mail_porta_smtp"));
		mj.setSmtpAuth(b.getString("mail_auth_smtp"));
		mj.setSmtpStarttls(b.getString("mail_ttls_smtp"));
		mj.setUserMail(b.getString("mail_user_smtp"));
		mj.setFromNameMail(b.getString("mail_remetente_smtp"));
		mj.setPassMail(b.getString("mail_password_smtp"));
		mj.setCharsetMail(b.getString("mail_formato_smtp"));

		/*
		 * Arquivo properties de internacionalização
		 */

		mj.setSubjectMail(bundle.getString("mail_subject_smtp_recuperacao"));
		mj.setBodyMail(htmlMessageCadastro(cadastro));
		mj.setTypeTextMail(Mail.TYPE_TEXT_HTML);

		// sete quantos destinatarios desejar
		Map<String, String> map = new HashMap<String, String>();
		map.put(cadastro.getCadastro_email(), cadastro.getCadastro_nome());
		map.put(bundle.getString("mail_cc_smtp"),
				bundle.getString("mail_descricao_cc_smtp"));
		mj.setToMailsUsers(map);

		// seta quatos anexos desejar
		List<String> files = new ArrayList<String>();
		mj.setFileMails(files);

		try {
			new MailSender().senderMail(mj);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_cadastro_email_sucesso"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			FacesUtil.exibirMensagemErro(bundle.getString("msg_cadastro_email_falha"));
		} catch (MessagingException e) {
			e.printStackTrace();
			FacesUtil.exibirMensagemErro(bundle.getString("msg_cadastro_email_falha"));
		}
	}

	private String htmlMessageCadastro(Cadastro cadastro) {
		String htmlMessage = null;
		htmlMessage = "<html>" + "<head>" + "<title>"
				+ bundle.getString("mail_title_smtp")
				+ "</title>"
				+ "</head>"
				+ "<body>"
				+ "<div align=center style='background-color:#FFD700; width:100%; height:20px; font-size: medium; font-family: Arial;'>"
				+ "<b>"
				+ bundle.getString("mail_subject_smtp_recuperacao")
				+ "</b>"
				+ "</div><div align=center style='background-color:#E8E8E8; width:100%; height:300px;'>"
				+ bundle.getString("mail_msg_comentario1_smtp")
				+ cadastro.getCadastro_nome()
				+ "<br>"
				+ bundle.getString("mail_msg_comentario2_smtp")
				+ "<br>"
				+ bundle.getString("mail_msg_comentario3_smtp")
				+ "<br><b>"
				+ bundle.getString("mail_msg_comentario4_smtp")
				+ cadastro.getCadastro_cpf()
				+ "</b>"
				+ "<br><b>"
				+ bundle.getString("mail_msg_comentario5_smtp")
				+ cadastro.getCadastro_senha()
				+ "</b>"
				+ "<br>"
				+ bundle.getString("mail_msg_comentatio6_smtp")
				+ "</br>"
				+ "</div><div align=center style='background-color:#FFD700; width:100%; height:20px; font-size:xx-small; font-family: Arial;'>"
				+ "<b>" + bundle.getString("mail_msg_rodape_smtp") + "</b>"
				+ "</div></body></html>";
		return htmlMessage;
	}


}

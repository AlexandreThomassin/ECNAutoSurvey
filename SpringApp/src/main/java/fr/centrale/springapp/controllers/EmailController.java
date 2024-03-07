/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.springapp.controllers;

/**
 *
 * @author arthu
 */
import java.util.Properties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.mail.*;
import javax.mail.internet.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmailController {

    @RequestMapping(value = "sendMail.do", method = RequestMethod.POST)
    public String sendEmail(@RequestParam("destinataire") String destinataire, @RequestParam("username") String username, @RequestParam("password") String password) {
        // Définir les propriétés SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtps.nomade.ec-nantes.fr");
        properties.put("mail.smtp.port", "587"); // Port SMTP standard
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Activer le protocole TLS

        // Créer une session avec l'authentification
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Créer un message email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); // Adresse expéditeur
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire)); // Adresse destinataire
            message.setSubject("Sujet de l'email");
            message.setText("Corps de l'email");

            // Envoyer le message
            Transport.send(message);

            return "successmail"; // Si ca marche -> Vue de succès

        } catch (MessagingException e) {
            e.printStackTrace();
            return "failmail"; // Si ca échoue -> Vue d'échec
        }
    }
}

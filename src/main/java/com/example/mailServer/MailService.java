package com.example.mailServer;

import org.apache.logging.log4j.message.Message;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class MailService {
    public static boolean sendEmail(Order order){
        String to=order.getUser().getEmail();
        String from="fortanpireva99@gmail.com";



        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("spicegios@gmail.com","jdbnvhmuahqafzxa\n");
                    }
                });

        try {
            MimeMessage message= new MimeMessage(session);
            message.setFrom(new InternetAddress("spicegios@gmail.com"));
            message.setRecipients(MimeMessage.RecipientType.TO,InternetAddress.parse(order.getUser().getEmail()));
            message.setSubject("Porosia në Spicegios Restaurant");
            message.setContent(renderHtml(order),"text/html");
Transport.send(message);
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String renderHtml(Order order){
        double total=0;
        String content="";

        for (Product p:
             order.getProducts()) {
            var subtotal=p.getProductInfo().getPrice()*p.getQuantity();
            total+=(p.getProductInfo().getPrice()*p.getQuantity());
            content+="<tr><td>"+p.getProductInfo().getImageUrl()+"</td>"
                    +"<td>"+p.getProductInfo().getTitle()+"</td>"
                    +"<td>"+p.getProductInfo().getPrice()+"€</td>"
                    +"<td>"+p.getQuantity()+"</td>"
                    +"<td>"+subtotal+"€</td></tr>";


        }


        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <title>Email</title>\n" +
                "    <style>\n" +
                "      #order {\n" +
                "        font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
                "        border-collapse: collapse;\n" +
                "        width: 100%;\n" +
                "      }\n" +
                "\n" +
                "      #order td,\n" +
                "      #order th {\n" +
                "        border: 1px solid #ddd;\n" +
                "        padding: 8px;\n" +
                "      }\n" +
                "\n" +
                "      #order tr:nth-child(even) {\n" +
                "        background-color: #f2f2f2;\n" +
                "      }\n" +
                "\n" +
                "      #order tr:hover {\n" +
                "        background-color: #ddd;\n" +
                "      }\n" +
                "\n" +
                "      #order th {\n" +
                "        padding-top: 12px;\n" +
                "        padding-bottom: 12px;\n" +
                "        text-align: left;\n" +
                "        background-color: #4caf50;\n" +
                "        color: white;\n" +
                "      }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <h1>I dashur konsumator</h1>\n" +
                "    <p>Më poshtë gjeni përmbledhjen e porosisë suaj</p>\n" +
                "    <table id=\"order\">\n" +
                "      <th style=\"width: 100px;\"></th>\n" +
                "      <th>Emri</th>\n" +
                "      <th>Çmimi</th>\n" +
                "      <th>Sasia</th>\n" +
                "      <th>Total</th>\n" + content+
                "      <tr>\n" +
                "        <td colspan=\"5\" style=\"text-align: center; font-size: 30px;\">Total:"+total+"</td>\n" +
                "      </tr>\n" +
                "    </table>\n" +
                "  </body>\n" +
                "</html>\n";
    }
}

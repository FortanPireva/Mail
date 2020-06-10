package com.example.mailServer;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/sendmail")
public class MailController {


    @PostMapping
    public boolean sendEmail(@JsonProperty("body") Order order){
        System.out.println(order);
        boolean rezultati=MailService.sendEmail(order);
        return rezultati;
    }
}

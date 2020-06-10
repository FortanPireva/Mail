package com.example.mailServer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/sendmail")
public class MailController {


    @PostMapping
    public boolean sendEmail(@RequestBody Body body){
        System.out.println(body);
        boolean rezultati=MailService.sendEmail(body.getOrder());
        return rezultati;
    }
}

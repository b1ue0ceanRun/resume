package com.run.resume.controller;


import com.run.resume.mapper.MailMapper;
import com.run.resume.service.AsyncService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;


@Api(description = "发送邮件的接口")
@RestController
public class SendMailController {
    @Autowired
    private MailMapper mailMapper;

    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    AsyncService asyncService;

    @ApiOperation("有人报名后 给小组管理员发送邮件提醒  directionID:方向id")
    @GetMapping("/user/sendMailTOAdmin")
    public int sendMailTOAdmin(@RequestParam("directionID") Integer did) throws MessagingException {

        List<String> mailList = mailMapper.findAdminMail(did);
        MimeMessage mailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage,true);

        helper.setSubject("报名提醒");
        helper.setText("<b style='color:red'>有同学报名啦，快去看吧</b>",true);

        for (String mail:mailList
             ) {
            helper.setTo(mail);
            helper.setFrom("1019076587@qq.com");

            mailSender.send(mailMessage);

        }
        asyncService.hello();

        return 1;
    }


    @ApiOperation("mail:发送给谁  result：发送内容")
    @GetMapping("/admin/sendResult")
    public int sendMail(@RequestParam("mail") String mail ,
                        @RequestParam("result") String result){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("1019076587@qq.com");
        simpleMailMessage.setTo(mail);
        simpleMailMessage.setSubject("审核结果");
        simpleMailMessage.setText(result);
        mailSender.send(simpleMailMessage);

        asyncService.hello();

        return 1;


    }
}

package com.run.resume.service;

import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("邮件发送中。。。");
    }

}

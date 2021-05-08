package com.run.resume.service;

import com.run.resume.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;



public class UpdateUploadTimeService {
    @Autowired
    private UserMapper userMapper;

    @Scheduled(cron = "（7）0 0 24 * * ?")
    public void UpdateUploadTime(){
        userMapper.updateAllUploadTime();
    }

}

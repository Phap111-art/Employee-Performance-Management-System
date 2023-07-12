package com.example.springemployee;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.springemployee.entity.Account;
import com.example.springemployee.service.AccountService;
import org.hibernate.mapping.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class SpringEmployeeApplicationTests {
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private AccountService accountService;
    @Test
    void contextLoads() throws IOException {

            Account account =  accountService.findByIdAccount(2);
            if (account.getPhoto() != "no-avatar_htjbfw"  && !account.getPhoto().equals("no-avatar_htjbfw")){
                String fileName = "avatar-employee/hxchkjij1m3wssd84u3t";
                cloudinary.uploader().destroy(fileName, ObjectUtils.emptyMap());
                System.out.println( account.getPhoto() + " no match");
            }else{
                System.out.println( account.getPhoto() + "  match");
            }
    }

}

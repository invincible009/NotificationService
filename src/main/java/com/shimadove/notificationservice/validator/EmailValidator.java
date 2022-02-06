package com.shimadove.notificationservice.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


@Component
@Scope("Singleton")
public class EmailValidator {

    public boolean isValid(String email, String domainName){
        try{
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
            String domainPart = StringUtils.substringAfter(email, "@");
            if(domainPart.equalsIgnoreCase(domainName)){
                return true;
            }
        }catch (AddressException exception){
            return false;
        }
        return false;
    }
}

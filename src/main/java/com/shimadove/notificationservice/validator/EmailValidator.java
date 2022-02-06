package com.shimadove.notificationservice.validator;

import org.apache.commons.lang3.StringUtils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

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

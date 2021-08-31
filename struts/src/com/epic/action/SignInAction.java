package com.epic.action;

import com.epic.model.User;
import com.epic.security.PasswordConveter;
import com.epic.service.Service;
import com.opensymphony.xwork2.ModelDriven;

public class SignInAction implements ModelDriven {

    private User user= new User();
    private Service service =  new Service();
    private PasswordConveter conveter = new PasswordConveter();


    public String execute() throws Exception {
        String password = user.getPassword();

        String encdata = conveter.convertPassword(password);
        user.setPassword(encdata);
        if (service.SignIn(user)) {
            return "success";
        }else{
            return "error";
        }

    }


    @Override
    public Object getModel() {
        return user;
    }
}

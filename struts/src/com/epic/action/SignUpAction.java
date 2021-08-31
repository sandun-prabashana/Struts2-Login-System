package com.epic.action;

import com.epic.model.User;
import com.epic.security.PasswordConveter;
import com.epic.service.Service;
import com.opensymphony.xwork2.ModelDriven;

public class SignUpAction implements ModelDriven {

    private User user= new User();
    private Service service =  new Service();
    private PasswordConveter conveter = new PasswordConveter();

    private String massage = "";


    public String execute() throws Exception {
        boolean b = false;

        String name = user.getUser_name();
        String email = user.getEmail_address();
        String password = user.getPassword();



        String encdata = conveter.convertPassword(password);
        user.setPassword(encdata);

        if (service.userValidateByName(user)) {
            setMassage("Username Already Taken");

        }else{
            if (service.userValidateByEmail(user)) {
                setMassage("Email Already Taken");

            }else{
                b = service.registerUser(user);
            }
        }


        if (b){
           return "success";
        }else {
            return "success";
        }

    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    @Override
    public Object getModel() {
        return user;
    }
}

package com.epic.action;



import com.epic.model.User;
import com.epic.security.PasswordConveter;
import com.epic.service.Service;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateAction extends ActionSupport implements ModelDriven {

    PasswordConveter  conveter = new PasswordConveter();
    User user=new User();
    private String msg;
    Service service = null;

    @Override
    public String execute() throws Exception {
        System.out.println("update ekata awa");
        service = new Service();
        System.out.println(user.getId());
        System.out.println(user.getUser_name());

        String password = user.getPassword();



        String encdata = conveter.convertPassword(password);
        user.setPassword(encdata);
        msg = service.updateUser(user);
        return "UPDATE";
    }

    @Override
    public Object getModel() {
        return user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

package com.epic.action;


import com.epic.model.User;
import com.epic.service.Service;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeleteAction extends ActionSupport {

    private int id;
    private String msg;
    Service service = null;

    @Override
    public String execute() throws Exception {
        System.out.println("delete ekata awa");
        service = new Service();
        msg = service.deleteUser(id);
        return "DELETE";
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}

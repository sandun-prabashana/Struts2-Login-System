package com.epic.action;


import com.epic.model.User;
import com.epic.service.Service;
import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;


public class ReportAction {

    private User user;
    Service service=new Service();

    public String execute() {

        return "success";
    }

    public void loadData(){
        String s = null;
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        ArrayList<User> registrations = service.getData();
        s = new Gson().toJson(registrations);
        System.out.println(s);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    protected void deleteUser() throws IOException {
//        HttpServletResponse response = ServletActionContext.getResponse();
//        HttpServletRequest request = ServletActionContext.getRequest();
//        System.out.println("delete");
//        PrintWriter writer = response.getWriter();
//        JsonReader reader = Json.createReader(request.getReader());
//        JsonObject reg = reader.readObject();
//        System.out.println("jasonobject");
//        int id = Integer.parseInt(reg.getString("id"));
//        System.out.println(id);
//        int x = 0;
//        try {
//            x = service.deleteUser(id);
//
//            response.setContentType("application/json");
//            if(x>0){
//                JsonObjectBuilder res = Json.createObjectBuilder();
//                res.add("operation","success");
//                writer.print(res.build());
//            }
//            writer.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
package com.action;
import DBUtil.Util;
import com.opensymphony.xwork2.ActionContext;
import dao.AuthDao;
import dao.UserDao;
import mapper.NewsuserMapper;
import model.User;
import org.apache.ibatis.session.SqlSession;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class UserAction extends BaseAction {
    private User user;
    private String username;
    private String password;
    private String auth;
    private ArrayList<User> users;

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String add() {
            try {
                new UserDao().saveUser(user);
                new AuthDao().setAuth(user.getUsername(),user.getAuth());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "addsuccess";
    }
    public String query() {
       users=new UserDao().query();
        for (User u:users) {
            u.setAuth(new AuthDao().queryAuth(u.getUsername()));
        }
        return "query";
    }

    public String del() {
        try {
            new UserDao().delete(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "delsuccess";
    }

    public String login() {
        if(new UserDao().login(username,password)){
            ActionContext context = ActionContext.getContext();
            Map<String, Object> cs = context.getSession();//获得session
            cs.put("username", username);
            return "loginsuccess";
        }

        else
            return "loginfail";
    }

    public String edit() {
        users=new UserDao().query(username);
        for (User u:users) {
            u.setAuth(new AuthDao().queryAuth(u.getUsername()));
        }
        //显示修改前内容
            return "edit";
        }

    public String edited() {
        try {
            new UserDao().update(user,user.getUsername());
            new AuthDao().updateAuth(user.getUsername(),user.getAuth());
            //执行修改操作
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "edited";
    }
    public String querydetail() {
        try {
            new UserDao().update(user,user.getUsername());
            new AuthDao().updateAuth(user.getUsername(),user.getAuth());
            //执行修改操作
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "querydetail";
    }

    public String logout() {
        request.getSession().removeAttribute("username");
        return "logout";
    }

    public String selectquery() {
        try {
            SqlSession ss = Util.getSqlSession();
            NewsuserMapper nm = ss.getMapper(NewsuserMapper.class);
            users=nm.selectSelective(user);
            System.out.println(users.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "selectquery";
    }
}

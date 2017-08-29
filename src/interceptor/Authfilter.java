package interceptor;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import dao.AuthDao;

public class Authfilter implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("权限过滤器");
        if("UserAction_login".equals(actionInvocation.getProxy().getActionName()))
            return actionInvocation.invoke();

        String username= (String)actionInvocation.getInvocationContext().getSession().get("username");
        String auth=new AuthDao().queryAuth(username);
        System.out.println(auth);
        if("管理".equals(auth)){
            return actionInvocation.invoke();
        }else{
            System.out.println("没有管理者权限");
            return "noauth";
        }
    }
}

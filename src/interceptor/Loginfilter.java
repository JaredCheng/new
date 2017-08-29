package interceptor;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
public class Loginfilter implements Interceptor {

    @Override
    public void destroy() {

    }
    @Override
    public void init() {

    }
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("登陆过滤器");
        if("UserAction_login".equals(actionInvocation.getProxy().getActionName()))
        return actionInvocation.invoke();

        String username= (String)actionInvocation.getInvocationContext().getSession().get("username");
        if(username==null){
            System.out.println("未登陆");
            return "nologin";
        }
        return actionInvocation.invoke();
    }
}

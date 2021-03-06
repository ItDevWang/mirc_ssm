package com.mirc.ssm.controller;

import com.mirc.ssm.domain.SysLog;
import com.mirc.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime; // 开始访问的时间
    private Class clazz;    // 访问的类
    private Method method;  // 访问的方法

    /**
     * 前置通知：获取开始时间，执行的类，执行的方法
     * @param jp
     */
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {

        visitTime = new Date();

        // 具体要访问的类
        clazz = jp.getTarget().getClass();

        // 获取访问的方法的名称
        String methodName = jp.getSignature().getName();

        // 获取访问的方法的参数
        Object[] args = jp.getArgs(); // 访问切面时，数据类型已经做了装箱

        // 获取具体执行的方法的Method对象
        if (args == null || args.length == 0){
            method = clazz.getMethod(methodName); //只能获取无参数的方法
        }else {

            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }

            method = clazz.getMethod(methodName, classArgs);
        }
    }


    /**
     * 后置通知
     * @param jp
     */
    public void doAfter(JoinPoint jp) throws Exception {
        // 方法访问时长
        long time =  new Date().getTime() - visitTime.getTime();

        // 获取URL
        String url = "";
        if (clazz != null && method != null && clazz != LogAop.class){
            // 1.获取类上的@RequestMapping("/orders")
            RequestMapping classAnnotation = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null){
                String[] classValue = classAnnotation.value();

                // 2.获取方法上的@RequestMapping(xxx)
                RequestMapping  methodAnnotation = (RequestMapping)method.getAnnotation(RequestMapping.class);

                String[] methodValue = methodAnnotation.value();

                url = classValue[0] + methodValue[0];

                // 获取访问的ip
                String ip = request.getRemoteAddr();

                // 从上下文中获得了当前登录的用户
                SecurityContext context = SecurityContextHolder.getContext();
                User user = (User)context.getAuthentication().getPrincipal();
                String username = user.getUsername();

                // 将日志相关信息封装到SysLog对象
                SysLog syslog = new SysLog();
                syslog.setExecutionTime(time); // 执行时长
                syslog.setIp(ip);
                syslog.setMethod("[类名]" + clazz.getName() + "[方法名]" + method.getName());
                syslog.setUrl(url);
                syslog.setUsername(username);
                syslog.setVisitTime(visitTime);

                // 传入Service完成操作
                sysLogService.save(syslog);
            }

        }


    }

}

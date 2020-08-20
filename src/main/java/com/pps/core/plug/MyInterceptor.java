package com.pps.core.plug;

import com.pps.core.annotion.AutoGenegrateId;
import com.pps.core.generate.IdStrategy;
import com.pps.core.generate.MyIdStrategy;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.util.Properties;
import java.util.Random;

/**
 * @author
 * @discription;
 * @time 2020/8/18 17:08
 */
@Intercepts({@Signature(
        type=  Executor.class,
        method = "update",
        args = {MappedStatement.class,Object.class})})
public class MyInterceptor implements Interceptor {

    private IdStrategy idStrategy=new MyIdStrategy();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {


        Object[] args = invocation.getArgs();
        if(args.length==2&&args[1]!=null){

            Object paramObject = args[1];
            Class<?> aClass = paramObject.getClass();
            AutoGenegrateId annotation = aClass.getAnnotation(AutoGenegrateId.class);
            if(annotation!=null){

                String name = annotation.name();
                Field declaredField = aClass.getDeclaredField(name);
                if(declaredField!=null){

                    declaredField.setAccessible(true);
                    declaredField.set(paramObject, idStrategy.product());

                    args[1]=paramObject;
                }else {
                    throw  new RuntimeException("注解["+name+"] 的域在实体类中不存在");
                }

            }

        }

        Object proceed = invocation.proceed();
        return proceed;

    }

    @Override
    public Object plugin(Object o) {

     return   Plugin.wrap(o,this);

    }

    @Override
    public void setProperties(Properties properties) {

        System.out.println("进入到我的拦截器配置了：----配置如下");
        properties.entrySet().forEach(p->{

            System.out.println(p.getKey()+":"+p.getValue());

        });

    }
}

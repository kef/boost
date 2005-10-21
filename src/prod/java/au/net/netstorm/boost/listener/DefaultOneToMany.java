package au.net.netstorm.boost.listener;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import au.net.netstorm.boost.util.type.Interface;


public final class DefaultOneToMany implements OneToMany, InvocationHandler
{
    private final Interface type;
    private final List many = new ArrayList();

    public DefaultOneToMany(Interface type)
    {
        noNulls(type);
        this.type = type;
    }

    public synchronized void add(Object oneOfMany)
    {
        noNulls(oneOfMany);
        many.add(oneOfMany);
    }

    public synchronized Object getOne()
    {
        ClassLoader loader = type.getClass().getClassLoader();
        Class[] types = {type.getType()};
        return Proxy.newProxyInstance(loader, types, this);
    }

    public synchronized Object invoke(Object proxyRef, Method method, Object[] parameters)
            throws Throwable
    {
        Object[] listeners = many.toArray(new Object[]{});
        invoke(listeners, method, parameters);
        return null;
    }

    private void invoke(Object[] listeners, Method method, Object[] parameters)
            throws IllegalAccessException, InvocationTargetException
    {
        for (int i = 0; i < listeners.length; i++)
        {
            method.invoke(listeners[i], parameters);
        }
    }

    private void noNulls(Object ref) {
        if (ref == null) throw new IllegalArgumentException();
    }
}

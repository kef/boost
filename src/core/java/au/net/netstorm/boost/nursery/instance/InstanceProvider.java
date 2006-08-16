package au.net.netstorm.boost.nursery.instance;

// FIX SC600 Mr Davis to write Roadmap on IOC, atoms et al.

public interface InstanceProvider {
    Object newInstance(Class cls);

//    Object newInstance(Class cls, Object argument, Class argumentType);

//    Object newInstance(Class aClass, Object[] arguments, Class[] argumentTypes);
}

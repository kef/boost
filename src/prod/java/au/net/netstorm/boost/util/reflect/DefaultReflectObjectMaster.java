package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import au.net.netstorm.boost.ioc.ConstructorNotPrivateException;
import au.net.netstorm.boost.ioc.MultipleConstructorsNotSupportedException;

class DefaultReflectObjectMaster implements ReflectObjectMaster {
    public Object create(Class cls) {
        Constructor constructor = getConstructor(cls);
        checkPrivateConstructor(constructor, cls);
        constructor.setAccessible(true);
        return ReflectEdge.INSTANCE.newInstance(constructor, new Object[]{});
    }

    public Constructor getConstructor(Class cls) {
        checkIsNotInterface(cls);
        Constructor[] constructors = cls.getDeclaredConstructors();
        checkSingleConstructor(constructors);
        return constructors[0];
    }

    // FIXME: SC501 Pretty sure the message is not tested.  Test it.
    private void checkIsNotInterface(Class cls) {
        if (cls.isInterface())
            throw new UnsupportedOperationException(getName(cls) + " is an interface and cannot be instantiated");
    }

    private void checkPrivateConstructor(Constructor constructor, Class cls) {
        if (!hasPrivateConstructor(constructor, cls)) throw new ConstructorNotPrivateException(cls);
    }

    private void checkSingleConstructor(Constructor[] constructors) {
        Constructor constructor = constructors[0];
        if (constructors.length != 1) {
            throw new MultipleConstructorsNotSupportedException(constructor.getDeclaringClass());
        }
    }

    private boolean hasPrivateConstructor(Constructor constructor, Class cls) {
        return Modifier.isPrivate(constructor.getModifiers());
        // FIXME: SC501 Exclusion list might go here.
    }

    private String getName(Class cls) {
        return new DefaultClassMaster().getShortName(cls);
    }
}

package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.ioc.MultipleConstructorsNotSupportedException;

class DefaultReflectObjectMaster implements ReflectObjectMaster {

    public Constructor getConstructor(Class cls) {
        checkIsNotInterface(cls);
        Constructor[] constructors = cls.getDeclaredConstructors();
        checkSingleConstructor(constructors);
        return constructors[0];
    }

    // FIXME: SC510 Pretty sure the message is not tested.  Test it.
    private void checkIsNotInterface(Class cls) {
        if (cls.isInterface())
            throw new UnsupportedOperationException(getName(cls) + " is an interface and cannot be instantiated");
    }

    private void checkSingleConstructor(Constructor[] constructors) {
        Constructor constructor = constructors[0];
        if (constructors.length != 1) {
            throw new MultipleConstructorsNotSupportedException(constructor.getDeclaringClass());
        }
    }

    private String getName(Class cls) {
        return new DefaultClassMaster().getShortName(cls);
    }
}

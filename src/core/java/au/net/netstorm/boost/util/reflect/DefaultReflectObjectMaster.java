package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Constructor;

class DefaultReflectObjectMaster implements ReflectObjectMaster {
    public Constructor getConstructor(Class cls) {
        checkIsNotInterface(cls);
        Constructor[] constructors = cls.getDeclaredConstructors();
        checkSingleConstructor(constructors, cls);
        return constructors[0];
    }

    private void checkIsNotInterface(Class cls) {
        if (cls.isInterface()) throw new InterfaceNotClassException(cls);
    }

    private void checkSingleConstructor(Constructor[] constructors, Class cls) {
        if (constructors.length != 1) throw new MultipleConstructorsNotSupportedException(cls);
    }
}

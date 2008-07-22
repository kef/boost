package au.net.netstorm.boost.bullet.mirror;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.gunge.type.Implementation;

class DefaultReflectObjectMaster implements ReflectObjectMaster {
    public Constructor getConstructor(Class cls) {
        checkIsNotInterface(cls);
        Constructor[] constructors = cls.getDeclaredConstructors();
        checkSingleConstructor(constructors, cls);
        return constructors[0];
    }

    public Constructor getConstructor(Implementation impl) {
        Class cls = impl.getImpl();
        return getConstructor(cls);
    }

    private void checkIsNotInterface(Class cls) {
        if (cls.isInterface()) throw new InterfaceNotClassException(cls);
    }

    private void checkSingleConstructor(Constructor[] constructors, Class cls) {
        if (constructors.length != 1) throw new IllegalStateException("We only support single constructors. " + cls);
    }
}

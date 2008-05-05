package au.net.netstorm.boost.gunge.reflect;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public class DefaultConstructorFixture implements ConstructorFixture {
    private final EdgeClass classer = new DefaultEdgeClass();
    private final List<?> vector = new Vector<Object>();
    private final List<?> stack = new Stack<Object>();
    private final Constructor<DualOverloadCtor> vectorctor = classer.getConstructor(DualOverloadCtor.class, Vector.class);
    private final Constructor<DualOverloadCtor> stackctor = classer.getConstructor(DualOverloadCtor.class, Stack.class);
    private final Constructor<?>[] constructors = {vectorctor, stackctor};

    public List<?> vector() {
        return vector;
    }

    public List<?> stack() {
        return stack;
    }

    public Constructor<DualOverloadCtor> vectorctor() {
        return vectorctor;
    }

    public Constructor<DualOverloadCtor> stackctor() {
        return stackctor;
    }

    public Constructor<?>[] constructors() {
        return constructors;
    }

    public Class<?>[] vectortype() {
        return vectorctor.getParameterTypes();
    }

    public Class<?>[] stacktype() {
        return stackctor.getParameterTypes();
    }
}

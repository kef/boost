package au.net.netstorm.boost.gunge.reflect;

import java.util.Stack;
import java.util.Vector;

// FIX 2328 Can we reduce a bunch of fixture stuff to package private?
public class DualOverloadCtor {
    public DualOverloadCtor(Vector<?> v) {
    }

    public DualOverloadCtor(Stack<?> s) {
    }
}

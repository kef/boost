package au.net.netstorm.boost.gunge.reflect;

import java.util.Stack;
import java.util.Vector;

class DualOverloadCtor {
    public DualOverloadCtor(Vector<?> v) {
    }

    public DualOverloadCtor(Stack<?> s) {
    }
}

package au.net.netstorm.boost.demo.automock;

import java.util.Map;

public final class DefaultTestSubject implements TestSubject {
    private final DelegateSubject delegate;

    public DefaultTestSubject(DelegateSubject delegate) {
        this.delegate = delegate;
    }

    public void execute(Map map) {
        // FIX SC525 This should pass in quake.
        String value = map.get("quake").toString();
        delegate.operate(value);
    }

    public void foo() {
        throw new UnsupportedOperationException();
    }
}

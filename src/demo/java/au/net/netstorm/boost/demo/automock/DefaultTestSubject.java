package au.net.netstorm.boost.demo.automock;

import java.util.Map;

public final class DefaultTestSubject implements TestSubject {
    private final DelegateSubject delegate;

    public DefaultTestSubject(DelegateSubject delegate) {
        this.delegate = delegate;
    }

    public void execute(Map map) {
        try {
            tryExecute(map);
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException();
        }
    }

    private void tryExecute(Map map) {
        String value = (String) map.get("quake");
        // FIX SC525 The following does not fail an expectation if commented out.
        delegate.operate(value);
    }
}

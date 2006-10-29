package au.net.netstorm.boost.demo.automock;

import java.util.Map;

public final class WorkingTestSubject implements TestSubject {
    private final DelegateSubject delegate;

    public WorkingTestSubject(DelegateSubject delegate) {
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
        delegate.operate(value);
    }
}

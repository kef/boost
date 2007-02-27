package au.net.netstorm.boost.demo.automock;

import java.io.DataInput;
import java.util.Map;

public final class WorkingTestSubject implements TestSubject {
    private final DelegateSubject delegate;

    public WorkingTestSubject(DelegateSubject delegate) {
        this.delegate = delegate;
    }

    public void executeGet(Map map) {
        try {
            tryExecuteGet(map);
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException();
        }
    }

    public void executePut(Map map, DataInput[] dataInputs) {
        map.put("streetfighter", dataInputs);
    }

    private void tryExecuteGet(Map map) {
        String value = (String) map.get("quake");
        delegate.operate(value);
    }
}

package au.net.netstorm.boost.demo.automock;

import java.util.List;
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

    public void executePut(Map map, List[] lists) {
        map.put("streetfighter", lists);
        for (int i = 0; i < lists.length; i++) {
            lists[i].size();
        }
    }

    private void tryExecuteGet(Map map) {
        String value = (String) map.get("quake");
        delegate.operate(value);
    }
}

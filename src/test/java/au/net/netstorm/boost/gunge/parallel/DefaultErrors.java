package au.net.netstorm.boost.gunge.parallel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.retire.reflect.AssertTestChecker;
import au.net.netstorm.boost.retire.reflect.DefaultAssertTestChecker;

public class DefaultErrors extends Primordial implements Errors {
    private static final AssertTestChecker CHECKER = new DefaultAssertTestChecker();
    private List throwables = Collections.synchronizedList(new ArrayList());

    public void thrown(Throwable t) {
        throwables.add(t);
    }

    public Iterator<Throwable> iterator() {
        List list = Collections.unmodifiableList(throwables);
        return list.iterator();
    }

    public Boolean isEmpty() {
        return throwables.isEmpty();
    }

    public void assertOk() {
        if (!isEmpty()) CHECKER.fail("" + throwables);
    }
}

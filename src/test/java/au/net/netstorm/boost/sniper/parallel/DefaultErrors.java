package au.net.netstorm.boost.sniper.parallel;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.sniper.check.AssertTestChecker;
import au.net.netstorm.boost.sniper.check.DefaultAssertTestChecker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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

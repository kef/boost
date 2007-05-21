package au.net.netstorm.boost.test.cases;

import au.net.netstorm.boost.spider.core.Destroyable;
import au.net.netstorm.boost.spider.core.Initialisable;

public interface TestLifecycle extends Initialisable, Destroyable {
    void verify();
}

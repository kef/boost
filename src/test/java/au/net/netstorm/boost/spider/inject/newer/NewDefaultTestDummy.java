package au.net.netstorm.boost.spider.inject.newer;

import au.net.netstorm.boost.spider.inject.newer.core.Newer;

public interface NewDefaultTestDummy extends Newer {
    Class CLASS_TO_NU = DefaultTestDummy.class;

    TestDummy nu();
}
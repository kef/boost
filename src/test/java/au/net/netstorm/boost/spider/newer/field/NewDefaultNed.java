package au.net.netstorm.boost.spider.newer.field;

import au.net.netstorm.boost.spider.newer.core.Newer;

interface NewDefaultNed extends Newer {
    Class CLASS_TO_NU = DefaultNed.class;

    Ned create();
}

package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.spider.inject.newer.core.Newer;

interface NewDefaultBob extends Newer {
    Class CLASS_TO_NU = DefaultBob.class;

    Bob nu(String comment);
}

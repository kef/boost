package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.pebble.inject.newer.core.Newer;

interface NewHeadJob extends Newer {
    Class IMPLEMENTATION = HeadJob.class;

    Job nu();
}

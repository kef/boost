package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.pebble.newer.core.Newer;

interface NewHeadJob extends Newer {
    Class IMPLEMENTATION = HeadJob.class;

    Job create();
}

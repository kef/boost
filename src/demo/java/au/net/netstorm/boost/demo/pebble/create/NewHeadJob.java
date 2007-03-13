package au.net.netstorm.boost.demo.pebble.create;

import au.net.netstorm.boost.pebble.create.core.Newer;

interface NewHeadJob extends Newer {
    Class IMPLEMENTATION = HeadJob.class;

    Job create();
}

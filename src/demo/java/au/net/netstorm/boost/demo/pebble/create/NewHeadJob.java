package au.net.netstorm.boost.demo.pebble.create;

import au.net.netstorm.boost.pebble.create.Creator;

interface NewHeadJob extends Creator {
    Class IMPLEMENTATION = HeadJob.class;

    Job create();
}

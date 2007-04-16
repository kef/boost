package au.net.netstorm.boost.demo.spider.newer;

import au.net.netstorm.boost.spider.inject.newer.core.Newer;

interface NewHeadJob extends Newer {
    Class CLASS_TO_NU = HeadJob.class;

    Job nu();
}

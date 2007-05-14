package au.net.netstorm.boost.demo.spider.newer;

import au.net.netstorm.boost.spider.core.GoodCitizen;

final class HeadJob implements Job, GoodCitizen {
    public String sayHi() {
        return "Hi";
    }
}

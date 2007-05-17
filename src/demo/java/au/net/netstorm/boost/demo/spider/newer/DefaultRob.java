package au.net.netstorm.boost.demo.spider.newer;

import au.net.netstorm.boost.spider.core.GoodCitizen;

final class DefaultRob implements Rob, GoodCitizen {
    NewDefaultBob newDefaultBob;

    public Bob getBob() {
        return newDefaultBob.nu("I am your friend.");
    }
}
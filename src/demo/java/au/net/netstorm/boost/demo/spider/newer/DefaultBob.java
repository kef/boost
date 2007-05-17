package au.net.netstorm.boost.demo.spider.newer;

final class DefaultBob implements Bob {
    NewHeadJob newHeadJob;

    public DefaultBob(String comment) {
    }

    public NewHeadJob getNewHeadJob() {
        return newHeadJob;
    }
}

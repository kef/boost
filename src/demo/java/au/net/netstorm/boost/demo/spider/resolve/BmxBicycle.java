package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.GoodCitizen;

public final class BmxBicycle implements Bicycle, GoodCitizen {
    Wheel rearWheel;
    Wheel frontWheel;

    public Wheel getFrontWheel() {
        return frontWheel;
    }

    public Wheel getRearWheel() {
        return rearWheel;
    }
}

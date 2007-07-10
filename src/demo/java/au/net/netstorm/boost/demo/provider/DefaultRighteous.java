package au.net.netstorm.boost.demo.provider;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultRighteous extends Primordial implements Righteous {
    private HappyDay[] happyDays;

    public DefaultRighteous(HappyDay[] happyDays) {
        this.happyDays = happyDays;
    }

    public HappyDay[] getHappyDays() {
        return happyDays;
    }
}

package au.net.netstorm.boost.demo.provider;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class DefaultFunkyData extends Primordial implements FunkyData {
    private Righteous righteous;
    private String funkyString;

    public DefaultFunkyData(Righteous righteous, String funkyString) {
        this.righteous = righteous;
        this.funkyString = funkyString;
    }

    public Righteous getRighteous() {
        return righteous;
    }

    public String getFunkyString() {
        return funkyString;
    }
}

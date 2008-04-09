package au.net.netstorm.boost.bullet.mirror;

public final class DefaultRattysSwissCheese implements RattysSwissCheese {
    public int getWheels() {
        return 1;
    }

    public String[] getWings() {
        return getWingNames();
    }

    public int getSpeed() {
        return 2;
    }

    private String[] getWingNames() {
        return new String[]{"Ratty's Wings"};
    }
}

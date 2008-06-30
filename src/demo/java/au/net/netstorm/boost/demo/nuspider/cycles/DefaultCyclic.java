package au.net.netstorm.boost.demo.nuspider.cycles;

public final class DefaultCyclic implements Cyclic {
    BackReference link;

    public BackReference get() {
        return link;
    }
}

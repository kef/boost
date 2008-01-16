package au.net.netstorm.boost.nursery.proxy;

public interface Proxifier {
    // FIX 2248 Rename?
    <T> T closure(T ref);
}

package au.net.netstorm.boost.gunge.type;

public interface ReferenceMaster {
    // FIX 2328 should this be generic - Reference is, but not sure that it actually should be
//    <T> T[] resolve(Reference<T>[] references);
    Object[] resolve(Reference<?>[] references);
}

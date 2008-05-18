package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.linkage.Linkage;

// FIX 2328 change name
public interface Factory {
    // FIX 2328 this smells bad

    // FIX 2328 1. bad name, it is not vending anything -
    // FIX 2328 really just a lookup and should be implemented as such, i.e. 1 method find with taked next link in chain

    // FIX 2328 2. there does need to be a real factory abstraction here somewhere, this interface (with BluePrint)
    // FIX 2328 leaks like a sieve. The abstraction can't expose the implementation as there may not be one
    Blueprint get(Linkage linkage);

    boolean canHandle(Linkage linkage);
}

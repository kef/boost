package au.net.netstorm.boost.nursery.type.map.supa;

import au.net.netstorm.boost.nursery.type.map.holder.DefaultHolderMap;
import au.net.netstorm.boost.nursery.type.map.holder.HolderMap;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.util.typed.BoomTypedMapWrite;
import au.net.netstorm.boost.util.typed.DefaultTypedMap;
import au.net.netstorm.boost.util.typed.TypedMap;
import au.net.netstorm.boost.util.typed.TypedMapRead;
import au.net.netstorm.boost.util.typed.TypedMapWrite;

public final class DefaultSuperMapAssembler implements SuperMapAssembler {
    Nu nu;

    public SuperMap assemble(TypedMapRead read) {
        TypedMapWrite write = new BoomTypedMapWrite();
        TypedMap readwrite = nu.nu(DefaultTypedMap.class, read, write);
        return assemble(readwrite);
    }

    public SuperMap assemble(TypedMapWrite write) {
        throw new UnsupportedOperationException();
    }

    public SuperMap assemble(TypedMap typed) {
        HolderMap holder = nu.nu(DefaultHolderMap.class, typed);
        return nu.nu(DefaultSuperMap.class, typed, holder);
    }
}

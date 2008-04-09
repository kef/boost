package au.net.netstorm.boost.nursery.type.map.supa;

import au.net.netstorm.boost.gunge.typed.BoomTypedMapWrite;
import au.net.netstorm.boost.gunge.typed.DefaultTypedMap;
import au.net.netstorm.boost.gunge.typed.TypedMap;
import au.net.netstorm.boost.gunge.typed.TypedMapRead;
import au.net.netstorm.boost.gunge.typed.TypedMapWrite;
import au.net.netstorm.boost.nursery.type.map.holder.DefaultHolderMap;
import au.net.netstorm.boost.nursery.type.map.holder.HolderMap;
import au.net.netstorm.boost.spider.instantiate.Nu;

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

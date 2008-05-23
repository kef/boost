package au.net.netstorm.boost.nursery.type.map.supa;

import au.net.netstorm.boost.gunge.typed.BoomTypedMapWrite;
import au.net.netstorm.boost.gunge.typed.TypedMap;
import au.net.netstorm.boost.gunge.typed.TypedMapRead;
import au.net.netstorm.boost.gunge.typed.TypedMapWrite;
import au.net.netstorm.boost.nursery.type.map.holder.HolderMap;
import au.net.netstorm.boost.spider.core.Nu;

public final class DefaultSuperMapAssembler implements SuperMapAssembler {
    Nu nu;

    public SuperMap assemble(TypedMapRead read) {
        TypedMapWrite write = new BoomTypedMapWrite();
        TypedMap readwrite = nu.nu(TypedMap.class, read, write);
        return assemble(readwrite);
    }

    public SuperMap assemble(TypedMapWrite write) {
        throw new UnsupportedOperationException();
    }

    public SuperMap assemble(TypedMap typed) {
        HolderMap holder = nu.nu(HolderMap.class, typed);
        return nu.nu(SuperMap.class, typed, holder);
    }
}

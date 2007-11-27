package au.net.netstorm.boost.nursery.type.supa;

import au.net.netstorm.boost.nursery.type.holder.HolderMap;
import au.net.netstorm.boost.nursery.type.holder.NewDefaultHolderMap;
import au.net.netstorm.boost.util.typed.BoomTypedMapWrite;
import au.net.netstorm.boost.util.typed.NewDefaultTypedMap;
import au.net.netstorm.boost.util.typed.TypedMap;
import au.net.netstorm.boost.util.typed.TypedMapRead;
import au.net.netstorm.boost.util.typed.TypedMapWrite;

public final class DefaultSuperMapAssembler implements SuperMapAssembler {
    NewDefaultTypedMap newDefaultTypedMap;
    NewDefaultHolderMap newDefaultHolderMap;
    NewDefaultSuperMap newDefaultSuperMap;

    public SuperMap assemble(TypedMapRead read) {
        TypedMapWrite write = new BoomTypedMapWrite();
        TypedMap readwrite = newDefaultTypedMap.nu(read, write);
        return assemble(readwrite);
    }

    public SuperMap assemble(TypedMapWrite write) {
        throw new UnsupportedOperationException();
    }

    public SuperMap assemble(TypedMap typed) {
        HolderMap holder = newDefaultHolderMap.nu(typed);
        return newDefaultSuperMap.nu(typed, holder);
    }
}

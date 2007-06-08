package au.net.netstorm.boost.type.map.core;

public final class DefaultSuperMapAssembler implements SuperMapAssembler {
    NewDefaultHolderMap newDefaultHolderMap;
    NewDefaultTypedMap newDefaultTypedMap;
    NewDefaultSuperMap newDefaultSuperMap;
    NewBoomTypedMapWrite newBoomTypedMapWrite;

    public SuperMap assemble(TypedMapRead read) {
        TypedMapWrite write = newBoomTypedMapWrite.nu();
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

package au.net.netstorm.boost.type.map.core;

public interface SuperMapAssembler {
    SuperMap assemble(TypedMapRead read);

    SuperMap assemble(TypedMapWrite write);

    SuperMap assemble(TypedMap typed);
}

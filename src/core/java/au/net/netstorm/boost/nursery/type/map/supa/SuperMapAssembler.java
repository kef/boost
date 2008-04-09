package au.net.netstorm.boost.nursery.type.map.supa;

import au.net.netstorm.boost.gunge.typed.TypedMap;
import au.net.netstorm.boost.gunge.typed.TypedMapRead;
import au.net.netstorm.boost.gunge.typed.TypedMapWrite;

public interface SuperMapAssembler {
    SuperMap assemble(TypedMapRead read);

    SuperMap assemble(TypedMapWrite write);

    SuperMap assemble(TypedMap typed);
}

package au.net.netstorm.boost.nursery.type.map.holder;

import au.net.netstorm.boost.nursery.type.primitive.StringHolder;

public interface StringHolderUtility {
    <T extends StringHolder> StringHolder replaceAll(T holder, String regex, String replacement);
}

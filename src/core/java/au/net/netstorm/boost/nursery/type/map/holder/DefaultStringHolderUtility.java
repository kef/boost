package au.net.netstorm.boost.nursery.type.map.holder;

import au.net.netstorm.boost.nursery.type.primitive.StringHolder;
import au.net.netstorm.boost.spider.instantiate.Nu;

public class DefaultStringHolderUtility implements StringHolderUtility {
    Nu nu;

    public <T extends StringHolder> StringHolder replaceAll(T holder, String regex, String replacement) {
        String s = holder.getValue();
        String result = s.replaceAll(regex, replacement);
        Class<? extends StringHolder> holderClass = holder.getClass();
        return nu.nu(holderClass, result);
    }
}

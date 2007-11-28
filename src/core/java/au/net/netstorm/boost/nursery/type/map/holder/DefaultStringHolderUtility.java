package au.net.netstorm.boost.nursery.type.map.holder;

import au.net.netstorm.boost.nursery.type.primitive.StringHolder;
import au.net.netstorm.boost.spider.instantiate.Nu;

public class DefaultStringHolderUtility implements StringHolderUtility {
    Nu nu;

    public <T extends StringHolder> T replaceAll(T holder, String regex, String replacement) {
        String s = holder.getValue();
        String result = s.replaceAll(regex, replacement);
        Class holderClass = holder.getClass();
        return (T) nu.nu(holderClass, result);
    }
}

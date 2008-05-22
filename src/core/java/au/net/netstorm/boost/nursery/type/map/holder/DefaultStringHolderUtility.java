package au.net.netstorm.boost.nursery.type.map.holder;

import au.net.netstorm.boost.nursery.type.primitive.StringHolder;
import au.net.netstorm.boost.spider.instantiate.NuImpl;

public class DefaultStringHolderUtility implements StringHolderUtility {
    NuImpl nuImpl;

    public <T extends StringHolder> T replaceAll(T holder, String regex, String replacement) {
        String s = holder.getValue();
        String result = s.replaceAll(regex, replacement);
        Class<T> holderClass = (Class<T>) holder.getClass();
        return nuImpl.nu(holderClass, result);
    }
}

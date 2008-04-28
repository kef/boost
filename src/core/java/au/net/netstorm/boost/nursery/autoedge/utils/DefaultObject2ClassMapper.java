package au.net.netstorm.boost.nursery.autoedge.utils;


public class DefaultObject2ClassMapper implements Object2ClassMapper {
    public Class<?> map(Object src) { return src.getClass(); }
}

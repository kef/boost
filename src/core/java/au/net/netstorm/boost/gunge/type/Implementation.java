package au.net.netstorm.boost.gunge.type;

public interface Implementation<T> extends Data {
    Class<T> getImpl();
}

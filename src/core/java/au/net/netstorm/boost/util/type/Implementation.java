package au.net.netstorm.boost.util.type;

public interface Implementation<T> extends Data {
    Class<T> getImpl();
}

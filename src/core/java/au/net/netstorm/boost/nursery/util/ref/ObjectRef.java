package au.net.netstorm.boost.nursery.util.ref;

public interface ObjectRef extends Ref {
    ObjectRef EMPTY = new DefaultObjectRef(null);

    Object get();
}

package au.net.netstorm.boost.nursery.gunge.ref;

public interface ObjectRef extends Ref {
    ObjectRef EMPTY = new DefaultObjectRef(null);

    Object get();
}

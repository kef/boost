package au.net.netstorm.boost.nursery.autoedge;

public interface AutoEdger {
    <E,T> E edge(Class<E> edge, T target);
    <E, T> T unedge(E candidate);
}

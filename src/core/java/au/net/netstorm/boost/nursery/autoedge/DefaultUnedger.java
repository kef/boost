package au.net.netstorm.boost.nursery.autoedge;

public class DefaultUnedger implements Unedger {
    public Object[] unedge(Object[] edge) {
        if (edge == null) return edge;
        Object[] real = new Object[edge.length];
        for (int i = 0; i < edge.length; ++i) {
            real[i] = unedge(edge[i]);
        }
        return real;
    }

    private Object unedge(Object candidate) {
        if (!(candidate instanceof Edge)) return candidate;
        Edge<?> edge = (Edge<?>) candidate;
        return edge.unedge();
    }
}

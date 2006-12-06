package au.net.netstorm.boost.edgifier;

public interface EdgifierMapper {
    boolean isEdge(Class type);
    Class getReal(Class edgeType);
    Class getEdge(Class realType);
}

package au.net.netstorm.boost.spider.layer;

public interface PassThroughLayer extends Layer {
    void setDelegate(Object delegate);
}

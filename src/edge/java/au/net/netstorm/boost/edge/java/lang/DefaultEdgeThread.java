package au.net.netstorm.boost.edge.java.lang;

import au.net.netstorm.boost.edge.EdgeException;

public final class DefaultEdgeThread implements EdgeThread {
    public void start(Thread thread) {
        thread.start();
    }

    public void join(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new EdgeException(e);
        }
    }
}

package au.net.netstorm.boost.sledge.java.lang;

import au.net.netstorm.boost.sledge.support.EdgeException;

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

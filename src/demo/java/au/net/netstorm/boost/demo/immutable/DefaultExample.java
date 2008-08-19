package au.net.netstorm.boost.demo.immutable;

public final class DefaultExample implements Example {
    Worker worker;

    public void example() {
        Work work = worker.work();
        Host host = work.host();
        Port port = work.port();
        System.out.println("work = " + work);
    }
}

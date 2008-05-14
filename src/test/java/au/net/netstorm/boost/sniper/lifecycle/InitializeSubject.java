package au.net.netstorm.boost.sniper.lifecycle;

import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.inject.SubjectInitializer;

public final class InitializeSubject implements TestLifecycleBlock {
    SubjectInitializer injector;
    Marker marker;
    Test test;

    public void execute() {
        if (marker.is(test, InjectSubject.class)) injector.inject(test);
    }
}

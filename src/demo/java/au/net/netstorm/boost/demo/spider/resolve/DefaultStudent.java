package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.GoodCitizen;

public final class DefaultStudent implements Student, GoodCitizen {
    Homework homework;
    Exam exam;
    Family family;

    public Family getFamily() {
        return family;
    }
}

package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.GoodCitizen;

public final class DefaultTeacher implements Teacher, GoodCitizen {
    Student student;
    Family family;

    public Student getStudent() {
        return student;
    }

    public Family getFamily() {
        return family;
    }
}

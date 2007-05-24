package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.GoodCitizen;

public final class DefaultTeacher implements Teacher, GoodCitizen {
    Student student;
    int years = 0;

    public void setAge(int years) {
        this.years = years;
    }

    public int getAge() {
        return years;
    }
}

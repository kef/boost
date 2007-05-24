package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.newer.DefaultSpiderAssembler;
import au.net.netstorm.boost.demo.spider.newer.SpiderAssembler;
import au.net.netstorm.boost.spider.core.GoodCitizen;
import au.net.netstorm.boost.spider.resolve.Registry;
import au.net.netstorm.boost.test.cases.BoooostCase;

// FIX 1971 Consider a single object referencing itself.
public final class ComplexCyclicDependenciesDemoTest extends BoooostCase {
    private final SpiderAssembler spiderAssembler = new DefaultSpiderAssembler(GoodCitizen.class);
    private final Spider spider = spiderAssembler.assemble();
    private final Registry web = spider;

    {
        web.prototype(Teacher.class, DefaultTeacher.class);
        web.prototype(Student.class, DefaultStudent.class);
        web.prototype(Homework.class, DefaultHomework.class);
        web.prototype(Exam.class, DefaultExam.class);
    }

    public void testResolve() {
        Teacher teacher1 = resolveTeacher(25);
        Teacher teacher2 = resolveTeacher(55);
        // FIX BREADCRUMB 1971 Re-instate.
/*
        assertNotEquals(teacher1, teacher2);
        checkResolve(teacher1, teacher2, 25, 55);
*/
    }

    private void checkResolve(Teacher teacher1, Teacher teacher2, int teacher1Age, int teacher2Age) {
        int actualAge1 = teacher1.getAge();
        int actualAge2 = teacher2.getAge();
        assertEquals(teacher1Age, actualAge1);
        assertEquals(teacher2Age, actualAge2);
    }

    private Teacher resolveTeacher(int age) {
        Teacher teacher1 = (Teacher) spider.resolve(Teacher.class);
        teacher1.setAge(age);
        return teacher1;
    }
}

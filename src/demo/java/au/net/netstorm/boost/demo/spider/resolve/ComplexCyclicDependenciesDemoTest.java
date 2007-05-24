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

    // FIX BREADCRUMB 1971 Rename.
    // FIX 1971 Do field assertions.
    // FIX 1971 Rename.
    public void testSomething() {
        // FIX 1971 Reinstate.
        Teacher teacher = (Teacher) spider.resolve(Teacher.class);
    }
}

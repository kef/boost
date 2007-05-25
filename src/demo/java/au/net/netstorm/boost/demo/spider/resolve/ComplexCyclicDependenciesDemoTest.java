package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderAssembler;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderAssembler;
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
        web.prototype(Family.class, DefaultFamily.class);
        web.prototype(Exam.class, DefaultExam.class);
    }

    public void testResolveAndTeacherNotSame() {
        Teacher teacher1 = resolveTeacher();
        Teacher teacher2 = resolveTeacher();
        assertNotEquals(teacher1, teacher2);
    }

    public void testResolveAndFamilyNotSame() {
        // FIX BREADCRUMB 1971 Re-instate.
//        Teacher teacher = resolveTeacher();
//        Family teacher1Family = teacher.getFamily();
//        Student student1 = teacher.getStudent();
//        Family student1Family = student1.getFamily();
//        assertNotEquals(teacher1Family, student1Family);
    }

    private Teacher resolveTeacher() {
        return (Teacher) spider.resolve(Teacher.class);
    }
}

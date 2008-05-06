package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.DefaultGraphUtil;
import au.net.netstorm.boost.spider.core.GraphUtil;

// FIX 2318 This entire package needs splitting into sub packages.
public final class ComplexCyclicDependenciesDemoTest extends ResolverDemooooTest {
    GraphUtil grapher = new DefaultGraphUtil();

    {
        registry.multiple(Teacher.class, DefaultTeacher.class);
        registry.multiple(Student.class, DefaultStudent.class);
        registry.multiple(Homework.class, DefaultHomework.class);
        registry.multiple(Exam.class, DefaultExam.class);
    }

    public void testResolve() {
        Teacher teacher1 = resolveTeacher();
        Teacher teacher2 = resolveTeacher();
        assertNotEquals(teacher1, teacher2);
        Object result = grapher.get(teacher1, "student.homework.teacher");
        assertEquals(DefaultTeacher.class, result.getClass());
        assertSame(teacher1, result);
    }

    private Teacher resolveTeacher() {
        return resolver.resolve(Teacher.class);
    }
}
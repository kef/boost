package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.DefaultGraphUtil;
import au.net.netstorm.boost.spider.core.GraphUtil;

public final class ComplexCyclicDependenciesDemoTest extends ResolverDemooooTest {
    private final GraphUtil grapher = new DefaultGraphUtil();

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
        return (Teacher) resolver.resolve(Teacher.class);
    }
}
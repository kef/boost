package au.net.netstorm.boost.demo.spider.resolve;

public final class ComplexCyclicDependenciesDemoTest extends ResolverDemooooTest {

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
    }

    private Teacher resolveTeacher() {
        return (Teacher) resolver.resolve(Teacher.class);
    }
}

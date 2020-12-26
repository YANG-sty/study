package com.sys.yang.standard2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yangLongFei 2020-12-24-16:15
 */
public class StudentTest {

    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-service.xml");
//        Student student = (Student) ac.getBean("student");
//        Student studentParam = (Student) ac.getBean("studentParam");
        StudentDto studentDto = (StudentDto) ac.getBean("studentDto");
        System.out.println(studentDto.toString());
    }

    /**
     * 依赖注入
     */
    @Test
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("di-service.xml");
        Student student = (Student) ac.getBean("student");
        System.out.println(student.toString());
    }
}

package com.atguigu.impl;

import com.atguigu.StudnetService;
import com.atguigu.dao.StudentDao;
import com.atguigu.dao.impl.StudentDaoImpl;
import com.atguigu.pojo.Student;

public class StudnetServiceImpl implements StudnetService {
    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public void registerStudent(Student student) {
        studentDao.saveStudent(student);
    }

    @Override
    public Student login(Student Student) {
        return studentDao.queryStudentByNameAndId(Student.getName(),Student.getId());
    }

    @Override
    public boolean existsName(String name) {
        //==null表示用户名不存在，可用，所以返回false
        if (studentDao.queryStudentByName(name) == null) {
            return false;
        }
        return true;
    }
}

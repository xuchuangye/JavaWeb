package com.atguigu.dao.impl;

import com.atguigu.dao.StudentDao;
import com.atguigu.pojo.Student;

public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public Student queryStudentByName(String name) {
        String sql = "select id,name,age,phone from t_student where name = ? ";
        return selectForOne(Student.class, sql,name);
    }

    @Override
    public Student queryStudentByNameAndId(String name, Integer id) {
        String sql = "select id,name,age,phone from t_student where name = ? and id = ?";
        return selectForOne(Student.class, sql,name,id);
    }

    @Override
    public int saveStudent(Student student) {
        String sql = "insert into t_user(name,age,phone) values(?,?,?)";
        return update(sql,student.getName(),student.getAge(),student.getPhone());
    }
}

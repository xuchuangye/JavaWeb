package com.atguigu.dao;

import com.atguigu.pojo.Student;

public interface StudentDao {

    /**
     * 根据学生名查询学生信息
     * @param name 学生名
     * @return 返回null表示该学生名不存在，返回stu对象表示该学生存在
     */
    public Student queryStudentByName(String name);

    /**
     * 根据学生名和编码查询学生信息
     * @param name 学生名
     * @param id 学生编码
     * @return 返回null表示该学生名或者编码错误，返回stu对象表示该学生信息真实
     */
    public Student queryStudentByNameAndId(String name,Integer id);

    /**
     * 保存学生信息
     * @param student Student的实例
     * @return 返回-1表示失败，返回其他表示成功
     */
    public int saveStudent(Student student);
}

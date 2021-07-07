package com.atguigu;

import com.atguigu.pojo.Student;

public interface StudnetService {

    /**
     * 注册学生信息
     * @param student 学生对象
     */
    public void registerStudent(Student student);

    /**
     * 学生输入学生名和学生id进行登录
     * @param student 学生名
     * @return 返回null，登录失败。返回其他，登录成功。
     */
    public Student login(Student student);

    /**
     *
     * @param name 学生名
     * @return 返回true，表示学生已存在，返回false，表示学生名可用
     */
    public boolean existsName(String name);
}

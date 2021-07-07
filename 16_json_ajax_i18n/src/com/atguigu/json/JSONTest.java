package com.atguigu.json;

import com.atguigu.pojo.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONTest {
	//JavaBean和json的转换
	@Test
	public void test1() {
		Student student = new Student(1,"赵丽颖",18,new BigDecimal(90));

		//创建Gson对象
		Gson gson = new Gson();
		//toJson()将Java对象转换成Json字符串
		String studentJsonString = gson.toJson(student);
		System.out.println(studentJsonString);//{"id":1,"name":"赵丽颖","age":18,"score":90}
		//fromJson()将json字符串转换成原来的Java对象
		//参数1，json字符串
		//参数2，Java对象的类型
		Student stu = gson.fromJson(studentJsonString, Student.class);
		System.out.println(stu);//Student{id=1, name='赵丽颖', age=18, score=90}
	}
	//List和json的转换
	@Test
	public void test2() {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1,"杨幂",20,new BigDecimal(95)));
		list.add(new Student(2,"迪丽热巴",22,new BigDecimal(96)));
		//创建Gson实例
		Gson gson = new Gson();
		//将list集合转换成json字符串
		String listJsonString = gson.toJson(list);
		System.out.println(listJsonString);//[{"id":1,"name":"杨幂","age":20,"score":95},{"id":2,"name":"迪丽热巴","age":22,"score":96}]

		//将json字符串转换成list集合，创建继承TypeToken的子类，使用该子类的getType()
		List<Student> studentList = gson.fromJson(listJsonString, new StudentListType().getType());
		System.out.println(studentList);//[Student{id=1, name='杨幂', age=20, score=95}, Student{id=2, name='迪丽热巴', age=22, score=96}]


		//java.lang.ClassCastException: class com.google.gson.internal.LinkedTreeMap cannot be cast to class com.atguigu.pojo.Student
		Student student = studentList.get(0);
		System.out.println(student);//Student{id=1, name='杨幂', age=20, score=95}
	}
	//Map和json之间的转换
	@Test
	public void test3() {
		Map<Integer,Student> map = new HashMap<Integer,Student>();
		map.put(1,new Student(1,"古力娜扎",22,new BigDecimal(80)));
		map.put(2,new Student(2,"江疏影",23,new BigDecimal(85)));

		//创建Gson实例
		Gson gson = new Gson();
		//将Map集合转换成json字符串
		String mapJsonString = gson.toJson(map);
		System.out.println(mapJsonString);//{"1":{"id":1,"name":"古力娜扎","age":22,"score":80},"2":{"id":2,"name":"江疏影","age":23,"score":85}}
		//将json字符串转换成Map集合
		//Map<Integer,Student> studentMap = gson.fromJson(mapJsonString, new StudentMapType().getType());


		//创建匿名内部类的方式，根据需要直接创建使用
		Map<Integer,Student> studentMap = gson.fromJson(mapJsonString, new TypeToken<HashMap<Integer,Student>>() {

		}.getType());
		System.out.println(studentMap);//{1=Student{id=1, name='古力娜扎', age=22, score=80}, 2=Student{id=2, name='江疏影', age=23, score=85}}

		Student student = studentMap.get(1);
		System.out.println(student);//Student{id=1, name='古力娜扎', age=22, score=80}
	}
}

package com.atguigu.pojo;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
	public static List<Student> getStudentList() {
		List<Student> list = new ArrayList<Student>();
		Student[] arr = new Student[10];
		arr[0] = new Student(1, "赵丽颖", 18, "18538324235");
		arr[1] = new Student(2, "迪丽热巴", 18, "18538432452");
		arr[2] = new Student(3, "唐嫣", 18, "18538244580");
		arr[3] = new Student(4, "江疏影", 18, "18538234380");
		arr[4] = new Student(5, "古力娜扎", 18, "18538235340");
		arr[5] = new Student(6, "刘嘉玲", 18, "18538253380");
		arr[6] = new Student(7, "周迅", 18, "18538435580");
		arr[7] = new Student(8, "张曼玉", 18, "18538234280");
		arr[8] = new Student(9, "张敏", 18, "18534323580");
		arr[9] = new Student(10, "鞠静娴", 18, "18538432380");

		for (Student s : arr) {
			list.add(s);
		}
		return list;
	}
}

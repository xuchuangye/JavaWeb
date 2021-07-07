package com.atguigu.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Person {
	private int id = 10;
	private String[] arr;
	private List<Integer> list;
	private Map<String,Integer> map;
	private int age = 18;
	public int getAge() {
		return age;
	}

	public Person() {
	}

	public Person(int id, String[] arr, List<Integer> list, Map<String, Integer> map) {
		this.id = id;
		this.arr = arr;
		this.list = list;
		this.map = map;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String[] getArr() {
		return arr;
	}

	public void setArr(String[] arr) {
		this.arr = arr;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", arr=" + Arrays.toString(arr) +
				", list=" + list +
				", map=" + map +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Person person = (Person) o;

		if (id != person.id) return false;
		if (age != person.age) return false;
		// Probably incorrect - comparing Object[] arrays with Arrays.equals
		if (!Arrays.equals(arr, person.arr)) return false;
		if (list != null ? !list.equals(person.list) : person.list != null) return false;
		return map != null ? map.equals(person.map) : person.map == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + Arrays.hashCode(arr);
		result = 31 * result + (list != null ? list.hashCode() : 0);
		result = 31 * result + (map != null ? map.hashCode() : 0);
		result = 31 * result + age;
		return result;
	}
}

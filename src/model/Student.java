package model;

public class Student {
	private String name;
	private String code;
	private Student next;
	private Student prev;
	
	public Student(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Student getNext() {
		return next;
	}

	public void setNext(Student next) {
		this.next = next;
	}

	public Student getPrev() {
		return prev;
	}

	public void setPrev(Student prev) {
		this.prev = prev;
	}

	public String toString() {
		return code + " - " + name;
	}
}

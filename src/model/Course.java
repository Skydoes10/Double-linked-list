package model;

public class Course {
	private String name;
	private int numStudents;
	private Student first;
	private Student last;
	
	public Course(String name, int numStudents) {
		this.name = name;
		this.numStudents = numStudents;
	}
	
	public void addStudent(Student newStudent) {
		if(first == null) {
			first = newStudent;
			last = newStudent;
		}else {
			addStudentSorted(first, newStudent);
		}
	}
	
	public void addStudentSorted(Student current, Student newStudent) {
		if(current.getNext() == null) {
			current.setNext(newStudent);
			newStudent.setPrev(current);
			last = newStudent;
		}else {
			addStudentSorted(current.getNext(), newStudent);
		}
	}

	public int deleteStudent(String name) {
		int cont = 0;
		if(first != null) {
			Student current = first.getNext();
			if(first.getName().equalsIgnoreCase(name)) {
				first = first.getNext();
				first.setPrev(null);
				cont++;
			}
			while(current != null && current.getName().equalsIgnoreCase(name)) {
				current.getPrev().setNext(current.getNext());
				current.getNext().setPrev(current.getPrev());
				current.setPrev(null);
				current.setNext(null);
				current = current.getNext();
				cont++;
			}
//				if(first.getNext().getName().equalsIgnoreCase(name)) {
//					current = first.getNext();
//					current.setPrev(null);
//					first.setNext(current.getNext());
//					current.getNext().setPrev(null);
//					current.setNext(null);
//					cont++;
//				}
			
		}else {
			return -1;
		}
		return cont;
	}
	
	public String showStudent() {
		String out = "";
		Student aux = first;
		if(first != null) {
			while(aux != null) {
				out += aux.toString() + "\n";
				aux = aux.getNext();
			}
		}else {
			out += "Empty student list";
		}
		return out;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumStudents() {
		return numStudents;
	}

	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}

	public Student getFirst() {
		return first;
	}

	public void setFirst(Student first) {
		this.first = first;
	}

	public Student getLast() {
		return last;
	}

	public void setLast(Student last) {
		this.last = last;
	}
	
}

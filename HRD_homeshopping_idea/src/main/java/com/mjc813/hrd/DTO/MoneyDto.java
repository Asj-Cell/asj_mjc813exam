package com.mjc813.hrd.DTO;

/*
 * Lombok 이 없으니까 모든 멤버변수에 대해서 getter, setter 메소드를 모두 만들어야 한다.
 */
public class MoneyDto {
	
	int custno;
	String custname;
	String grade;
	int price;

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
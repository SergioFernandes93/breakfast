package Entities;

import java.util.List;

public class Employee {
	private String name;
	private String cpf;
	private List<String> foods;

	public Employee() {
	}

	public Employee(String name, String cpf, List<String> foods) {
		this.name = name;
		this.cpf = cpf;
		this.foods = foods;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<String> getFoods() {
		return foods;
	}

	public void setFoods(List<String> foods) {
		this.foods = foods;
	}
	public String toString() {
		return name + " - " + cpf + " - " + foods + "\n";  
		}
}

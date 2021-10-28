package service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import Entities.Employee;

public class BreakfastService {
	public List<Employee>  addBreakFast() {
		Scanner sc = new Scanner(System.in);
		List<String> foods = new ArrayList<String>();
		List<Employee> emps = new ArrayList<Employee>();

		Employee emp = new Employee();

		String option = "1";
		while (option.equals("1") || option.equals("2") || option.equals("0") || option.equals("3")) {

			if (option.equals("0")) {
				emp.setFoods(foods);
				emps.add(emp);
				emp = new Employee();
				foods = new ArrayList<String>();
			}
			if (option.equals("4") || option.equals("1") || option.equals("0") || option.equals("2")) {
				System.out.println("Selecione uma opção abaixo:");
				System.out.println("(1)Cadastrar empregado \n(2)Ver lista do café da manhã \n(9)Sair");
				option = sc.nextLine();
			}
			String food = null;
			if (option.equals("1")) {

				System.out.println("Nome:");
				String name = sc.nextLine();
				emp.setName(name);

				System.out.println("CPF:");
				String cpf = sc.nextLine().toLowerCase();

				while (emps.toString().contains(cpf)) {
					System.out.println("CPF já existe");
					System.out.println("Digite um CPF válido:");
					cpf = sc.nextLine().toLowerCase();
				}
				emp.setCpf(cpf);
			}

			if (option.equals("3") || option.equals("1")) {
				System.out.println("O que irá trazer para o café da manhã?");
				food = sc.nextLine().toLowerCase();
				food = removerAcentos(food);

				while (emps.toString().contains(food) || foods.toString().contains(food)) {
					System.out.println("O item já existe");
					System.out.println("Digite um item válido:");
					food = sc.nextLine().toLowerCase();
					food = removerAcentos(food);
				}

				foods.add(food);
				System.out.println("Selecione uma opção abaixo:");
				System.out.println("(3)Adicionar outro item \n(0)Voltar");
				option = sc.nextLine();
			}

			if (option.equals("2")) {
				System.out.println("Lista de itens:\n" + emps);
			}
		}		
		
		sc.close();

		return emps;
	}
	
	public static String deAccent(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
	public static String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
}

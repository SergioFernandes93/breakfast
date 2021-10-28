package application;
import service.BreakfastService;

public class Main {

	public static void main(String[] args) {
		System.out.println("Bem vindo ao café da manhã!");
		BreakfastService breakfastService = new BreakfastService();
		breakfastService.addBreakFast();
		System.out.println("Obrigado");

	}

}

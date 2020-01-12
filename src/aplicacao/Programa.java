package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entidade.Logs;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com o caminho do arquivo: ");
		String url = sc.next();
		
		try (BufferedReader leitor = new BufferedReader(new FileReader(url))) {
			
			Set<Logs> set = new HashSet<>();
			
			String linha = leitor.readLine();
			while (linha != null) {
				
				String [] campos = linha.split(" ");
				String nome = campos[0];
				Date momento = Date.from(Instant.parse(campos[1]));
				set.add(new Logs(nome, momento));
				linha = leitor.readLine();
				
			}
			
			System.out.println("Total " + set.size());
			
		}catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		sc.close();
	}
}

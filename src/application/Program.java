package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		Map<String, Integer> votes = new LinkedHashMap<>();
		
		// lendo caminho do arquivo csv
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		// iniciando arquivo
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			//lendo linhas do arquivo
			String line = br.readLine();
			while (line != null) {
				//separando chave de valor
				String[] fields = line.split(",");
				String name = fields[0];
				int count= Integer.parseInt(fields[1]);
				
				// pegando quantidade de votos de cada candidato
				if(votes.containsKey(name)) {
					int votesSoFar = votes.get(name);
					votes.put(name, count + votesSoFar);
				} else {
					votes.put(name, count);
				}
				
				line = br.readLine();
			}
			
			// imprimindo 
			for (String key : votes.keySet()) {
				System.out.println(key + ": " + votes.get(key));
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}

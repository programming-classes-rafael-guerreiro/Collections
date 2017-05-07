package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		// Map<String, Collection<Pessoa>> pessoas = new HashMap<>();
		//
		// put(pessoas, new PessoaFisica("Rafael", 24));
		// put(pessoas, new PessoaFisica("Rafael", 25));
		// put(pessoas, new PessoaFisica("Gabriel", 25));
		// put(pessoas, new PessoaFisica("Rafael", 26));

		Set<String> set = new HashSet<>();
		String[] nomes = { "Rafael", "Rafael", "Gabriel", "Rafael" };

		for (String nome : nomes) {
			if (set.add(nome))
				System.out.println("Adicionei " + nome);
			else
				System.out.println("Ignorei " + nome);
		}

		// System.out.println(pessoas);

		// for (Collection<Pessoa> collection : pessoas.values()) {
		// for (Pessoa pessoa : collection) {
		// System.out.println(pessoa);
		// }
		// }
	}

	private static void put(Map<String, Collection<Pessoa>> pessoas, Pessoa pessoa) {
		final String key = pessoa.getNome();
		Collection<Pessoa> collection = pessoas.get(key);

		if (collection == null) {
			collection = new LinkedList<>();
			Collection<Pessoa> old = pessoas.put(key, collection);

		}

		collection.add(pessoa);
	}

	private static abstract class Pessoa {
		private final String nome;

		public Pessoa(String nome) {
			this.nome = nome;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pessoa other = (Pessoa) obj;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			return true;
		}



		public String getNome() {
			return nome;
		}
	}

	private static class PessoaFisica extends Pessoa {
		private final int idade;

		public PessoaFisica(String nome, int idade) {
			super(nome);
			this.idade = idade;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + idade;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			PessoaFisica other = (PessoaFisica) obj;
			if (idade != other.idade)
				return false;
			return true;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("PessoaFisica [nome=").append(getNome()).append(", idade=").append(idade).append("]");
			return builder.toString();
		}

	}
}


public class Pessoa {

	private final String nome;
	private final int idade;

	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	@Override
	public int hashCode() {
		int result = 0;

		result += 59 * (nome == null ? 0 : nome.hashCode());  
		result += 59 * (idade);  

		return result;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [nome=").append(nome).append(", idade=").append(idade).append("]");
		return builder.toString();
	}

	public String getNome() {
		return nome;
	}
}

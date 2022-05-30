package DIOProjetoDesignPattern.Spring.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@ManyToOne
	private Endereco endereco;
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}

	@PostLoad
	public void postLoad() {

	}

	@PostPersist
	public void postPersist() {

	}
}

package DIOProjetoDesignPattern.Spring.service;

import DIOProjetoDesignPattern.Spring.model.Cliente;

/**
 * Interface que define a Strategy no domínio de cliente.
 * Caso necessário, podemos ter multiplas implementações nessa Interface.
 */
public interface ClienteServiceInterface {

	Iterable<Cliente> buscarTodos();

	Cliente buscarPorId(Long id);

	void inserir(Cliente cliente);

	void atualizar(Long id, Cliente cliente);

	void deletar(Long id);

}

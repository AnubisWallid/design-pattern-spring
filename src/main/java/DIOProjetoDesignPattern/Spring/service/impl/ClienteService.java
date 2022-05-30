package DIOProjetoDesignPattern.Spring.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import DIOProjetoDesignPattern.Spring.model.ClienteRepository;
import DIOProjetoDesignPattern.Spring.model.EnderecoRepository;
import DIOProjetoDesignPattern.Spring.service.ClienteServiceInterface;
import DIOProjetoDesignPattern.Spring.service.ViaCepServiceInterface;
import DIOProjetoDesignPattern.Spring.model.Cliente;
import DIOProjetoDesignPattern.Spring.model.Endereco;

/**
 * Implementação da Strategy {@link ClienteServiceInterface}
 * injetada pelo Spring {@link Autowired}.
 * Como essa classe é um {@link Service}, ela será tratada como um Singleton
 */

@Service
public class ClienteService implements ClienteServiceInterface {

    // Singleton: Injeta os componentes do Spring com @Autowired.
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepServiceInterface viaCepService;

    // Strategy: Implementa os métodos definidos na interface.
    // Facade: Abstrai integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {
        // Busca todos os Clientes.
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // Busca Cliente por ID.
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // Busca o Cliente por ID, caso exista:
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteCep(Cliente cliente) {
        // Verifica se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integra com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // Insere o Cliente, vinculando o Endereco (novo ou existente).
        clienteRepository.save(cliente);
    }

}

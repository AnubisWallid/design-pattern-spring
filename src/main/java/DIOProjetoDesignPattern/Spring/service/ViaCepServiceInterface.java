package DIOProjetoDesignPattern.Spring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import DIOProjetoDesignPattern.Spring.model.Endereco;

/**
 * Client HTTP, criado via OpenFeign, para o consumo da API do ViaCEP.
 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepServiceInterface {

	@GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
}

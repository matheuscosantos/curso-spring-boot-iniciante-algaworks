package com.mcos.algaworks.domain.service;

import com.mcos.algaworks.domain.exception.NegocioException;
import com.mcos.algaworks.domain.model.Cliente;
import com.mcos.algaworks.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) throws Exception {
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());

        if(clienteExistente != null && !clienteExistente.equals(cliente)){
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
        }
        return clienteRepository.save(cliente);
    }

    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
}

package com.br.simonsen.cheguei.service;

import com.br.simonsen.cheguei.converter.ClienteConverter;
import com.br.simonsen.cheguei.entity.Cliente;
import com.br.simonsen.cheguei.model.ClienteVO;
import com.br.simonsen.cheguei.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private  final ClienteConverter clienteConverter;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, ClienteConverter clienteConverter) {
        this.clienteRepository = clienteRepository;
        this.clienteConverter = clienteConverter;
    }

    public List<Cliente> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public Cliente createCliente(ClienteVO clienteVO) {
        Cliente cliente = clienteConverter.convertToEntity(clienteVO);
        Cliente savedCliente = clienteRepository.save(cliente);
        return savedCliente;
    }
}

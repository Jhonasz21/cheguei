package com.br.simonsen.cheguei.controller;

import com.br.simonsen.cheguei.converter.ClienteConverter;
import com.br.simonsen.cheguei.entity.Cliente;
import com.br.simonsen.cheguei.model.ClienteResponse;
import com.br.simonsen.cheguei.model.ClienteVO;
import com.br.simonsen.cheguei.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private ClienteConverter clienteConverter;


    @Autowired
    public ClienteController(ClienteService clienteService, ClienteConverter clienteConverter) {
        this.clienteService = clienteService;
        this.clienteConverter = clienteConverter;
    }


    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findAllClientes() {

        final List<Cliente> allClientes = clienteService.findAll();

        List<ClienteResponse> clientes = allClientes.stream()
                .map(log -> clienteConverter.convertToResponse(log))
                .collect(Collectors.toList());
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> createCliente(@RequestBody ClienteVO clienteVO){
       Cliente cliente = clienteService.createCliente(clienteVO);

        ClienteResponse response = clienteConverter.convertToResponse(cliente);
        return ResponseEntity.ok(response);
    }
}

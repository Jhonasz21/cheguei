package com.br.simonsen.cheguei.converter;

import com.br.simonsen.cheguei.entity.Cliente;
import com.br.simonsen.cheguei.entity.Endereco;
import com.br.simonsen.cheguei.entity.Login;
import com.br.simonsen.cheguei.model.ClienteResponse;
import com.br.simonsen.cheguei.model.ClienteVO;
import com.br.simonsen.cheguei.model.EnderecoVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter {
    private ModelMapper modelMapper = new ModelMapper();
    private final EnderecoConverter enderecoConverter;

    private final  LoginConverter loginConverter;

    @Autowired
    public ClienteConverter(EnderecoConverter enderecoConverter, LoginConverter loginConverter) {
        this.enderecoConverter = enderecoConverter;
        this.loginConverter = loginConverter;
    }

    public ClienteResponse convertToResponse(Cliente cliente) {
        ClienteResponse clienteResponse = modelMapper.map(cliente, ClienteResponse.class);
        clienteResponse.setCpf(cliente.getCpf());
        clienteResponse.setNascimento(cliente.getNascimento());
        clienteResponse.setNome(cliente.getNome());
        clienteResponse.setTelefone(cliente.getTelefone());
        clienteResponse.setEmail(cliente.getLogin().getUsuario());
        EnderecoVO enderecoVO = enderecoConverter.convertToVO(cliente.getEndereco());
        clienteResponse.setEndereco(enderecoVO);

        return clienteResponse;
    }

    public Cliente convertToEntity(ClienteVO vo) {

        Cliente cliente = modelMapper.map(vo, Cliente.class);
        cliente.setCpf(vo.getCpf());
        cliente.setNascimento(vo.getNascimento());
        cliente.setNome(vo.getNome());
        cliente.setTelefone(vo.getTelefone());

        Endereco endereco = enderecoConverter.convertToEntity(vo.getEndereco());
        cliente.setEndereco(endereco);

        Login login = loginConverter.convertToEntity(vo.getLogin());
        cliente.setLogin(login);

        return cliente;
    }
}

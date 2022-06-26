package com.br.simonsen.cheguei.converter;

import com.br.simonsen.cheguei.entity.Endereco;
import com.br.simonsen.cheguei.entity.Login;
import com.br.simonsen.cheguei.model.LoginVO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LoginConverter {

    private ModelMapper modelMapper = new ModelMapper();

    public Login convertToEntity(LoginVO vo){
        Login login = modelMapper.map(vo, Login.class);
        login.setUsuario(vo.getUsuario());
        login.setSenha(vo.getSenha());
        return login;
    }
}

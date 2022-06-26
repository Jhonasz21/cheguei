package com.br.simonsen.cheguei.converter;

import com.br.simonsen.cheguei.entity.Endereco;
import com.br.simonsen.cheguei.model.EnderecoVO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EnderecoConverter {

    private ModelMapper modelMapper = new ModelMapper();

    public EnderecoVO convertToVO(Endereco endereco) {
        EnderecoVO vo = modelMapper.map(endereco, EnderecoVO.class);
        vo.setCep(endereco.getCep());
        vo.setCidade(endereco.getCidade());
        vo.setId(endereco.getId());
        vo.setLogradouro(endereco.getLogradouro());
        vo.setNumero(endereco.getNumero());
        vo.setReferencia(endereco.getReferencia());
        vo.setComplemento(endereco.getComplemento());
        return vo;
    }

    public Endereco convertToEntity(EnderecoVO vo) {
        Endereco endereco = modelMapper.map(vo, Endereco.class);

        endereco.setCep(vo.getCep());
        endereco.setCidade(vo.getCidade());
        endereco.setEstado(vo.getEstado());
        endereco.setLogradouro(vo.getLogradouro());
        endereco.setNumero(vo.getNumero());
        endereco.setReferencia(vo.getReferencia());
        endereco.setComplemento(vo.getComplemento());
        return endereco;
    }

}

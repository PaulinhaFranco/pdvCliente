package com.example.pdvCliente.service;

import com.example.pdvCliente.interfaces.IService;
import com.example.pdvCliente.model.Endereco;
import com.example.pdvCliente.repository.EnderecoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service

public class EnderecoService implements IService<Endereco, Integer> {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Endereco create(Endereco entity) {
        return enderecoRepository.save(entity);
    }

    @Override
    public Endereco get(Integer id) {
        Optional<Endereco> enderecoEncontrado = enderecoRepository.findById(id);
        if (enderecoEncontrado.isPresent()) {
            return enderecoEncontrado.get();
        } else {
            return new Endereco();
        }
    }

    @Override
    public List<Endereco> get() {
        return enderecoRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Endereco update(Integer id, Endereco entity) {
        Endereco enderecoEncontrado = this.get(id);

        if (enderecoEncontrado.getId() != 0 || enderecoEncontrado.getId() != null) {
            return enderecoRepository.save(entity);
        } else {
            //return null;
            return new Endereco();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        enderecoRepository.deleteById(id);
    }
}


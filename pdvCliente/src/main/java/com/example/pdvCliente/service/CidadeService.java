package com.example.pdvCliente.service;

import com.example.pdvCliente.interfaces.IService;
import com.example.pdvCliente.model.Cidade;
import com.example.pdvCliente.repository.CidadeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service

public class CidadeService implements IService<Cidade, Integer> {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Cidade create(Cidade entity) {
        return cidadeRepository.save(entity);
    }

    @Override
    public Cidade get(Integer id) {
        Optional<Cidade> cidadeEncontrada = cidadeRepository.findById(id);
        if(cidadeEncontrada.isPresent()){
            return cidadeEncontrada.get();
        }
        else {
            return new Cidade();
        }
    }

    @Override
    public List<Cidade> get() {
        return cidadeRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Cidade update(Integer id, Cidade entity) {
        Cidade cidadeEncontrada = this.get(id);

        if(cidadeEncontrada.getId()!=0 || cidadeEncontrada.getId()!=null){
            return cidadeRepository.save(entity);
        }
        else{
            //return null;
            return new Cidade();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        cidadeRepository.deleteById(id);
    }
}


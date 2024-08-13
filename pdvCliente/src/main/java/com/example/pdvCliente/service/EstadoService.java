package com.example.pdvCliente.service;

import com.example.pdvCliente.interfaces.IService;
import com.example.pdvCliente.model.Estado;
import com.example.pdvCliente.repository.EstadoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service

public class EstadoService implements IService<Estado, Integer> {

    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Estado create(Estado entity) {
        return estadoRepository.save(entity);
    }

    @Override
    public Estado get(Integer id) {
        Optional<Estado> estadoEncontrado = estadoRepository.findById(id);
        if(estadoEncontrado.isPresent()){
            return estadoEncontrado.get();
        }
        else {
            return new Estado();
        }
    }

    @Override
    public List<Estado> get() {
        return estadoRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Estado update(Integer id, Estado entity) {
        Estado estadoEncontrado = this.get(id);

        if(estadoEncontrado.getId()!=0 || estadoEncontrado.getId()!=null){
            return estadoRepository.save(entity);
        }
        else{
            //return null;
            return new Estado();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        estadoRepository.deleteById(id);
    }
}




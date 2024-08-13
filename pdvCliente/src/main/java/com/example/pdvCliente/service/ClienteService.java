package com.example.pdvCliente.service;

import com.example.pdvCliente.interfaces.IService;
import com.example.pdvCliente.model.Cliente;
import com.example.pdvCliente.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service

public class ClienteService implements IService<Cliente, Integer> {
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Cliente create(Cliente entity) {
        return clienteRepository.save(entity);
    }

    @Override
    public Cliente get(Integer id) {
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(id);
        if(clienteEncontrado.isPresent()){
            return clienteEncontrado.get();
        }
        else {
            return new Cliente();
        }
    }

    @Override
    public List<Cliente> get() {
        return clienteRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Cliente update(Integer id, Cliente entity) {
        Cliente clienteEncontrado = this.get(id);

        if(clienteEncontrado.getId()!=0 || clienteEncontrado.getId()!=null){
            return clienteRepository.save(entity);
        }
        else{
            //return null;
            return new Cliente();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
         clienteRepository.deleteById(id);
    }
}

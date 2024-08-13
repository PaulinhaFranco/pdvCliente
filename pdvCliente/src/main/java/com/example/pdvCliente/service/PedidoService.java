package com.example.pdvCliente.service;

import com.example.pdvCliente.interfaces.IService;
import com.example.pdvCliente.model.Pedido;
import com.example.pdvCliente.repository.PedidoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service

public class PedidoService implements IService<Pedido, Integer> {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Pedido create(Pedido entity) {
        return pedidoRepository.save(entity);
    }

    @Override
    public Pedido get(Integer id) {
        Optional<Pedido> pedidoEncontrado = pedidoRepository.findById(id);
        if(pedidoEncontrado.isPresent()){
            return pedidoEncontrado.get();
        }
        else {
            return new Pedido();
        }
    }

    @Override
    public List<Pedido> get() {
        return pedidoRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Pedido update(Integer id, Pedido entity) {
        Pedido pedidoEncontrado = this.get(id);

        if(pedidoEncontrado.getId()!=0 || pedidoEncontrado.getId()!=null){
            return pedidoRepository.save(entity);
        }
        else{
            //return null;
            return new Pedido();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        pedidoRepository.deleteById(id);
    }
}



package com.example.pdvCliente.service;

import com.example.pdvCliente.interfaces.IService;
import com.example.pdvCliente.model.ItemPedido;
import com.example.pdvCliente.repository.ItemPedidoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service

public class ItemPedidoService implements IService<ItemPedido, Integer> {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ItemPedido create(ItemPedido entity) {
        return itemPedidoRepository.save(entity);
    }

    @Override
    public ItemPedido get(Integer id) {
        Optional<ItemPedido> itemPedidoEncontrado = itemPedidoRepository.findById(id);
        if(itemPedidoEncontrado.isPresent()){
            return itemPedidoEncontrado.get();
        }
        else {
            return new ItemPedido();
        }
    }

    @Override
    public List<ItemPedido> get() {
        return itemPedidoRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ItemPedido update(Integer id, ItemPedido entity) {
        ItemPedido itemPedidoEncontrado = this.get(id);

        if(itemPedidoEncontrado.getId()!=0 || itemPedidoEncontrado.getId()!=null){
            return itemPedidoRepository.save(entity);
        }
        else{
            //return null;
            return new ItemPedido();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        itemPedidoRepository.deleteById(id);
    }
}




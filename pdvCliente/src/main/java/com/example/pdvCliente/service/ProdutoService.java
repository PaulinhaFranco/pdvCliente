package com.example.pdvCliente.service;

import com.example.pdvCliente.interfaces.IService;
import com.example.pdvCliente.model.Produto;
import com.example.pdvCliente.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service

public class ProdutoService implements IService<Produto, Integer> {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Produto create(Produto entity) {
        return produtoRepository.save(entity);
    }

    @Override
    public Produto get(Integer id) {
        Optional<Produto> produtoEncontrado = produtoRepository.findById(id);
        if(produtoEncontrado.isPresent()){
            return produtoEncontrado.get();
        }
        else {
            return new Produto();
        }
    }

    @Override
    public List<Produto> get() {
        return produtoRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Produto update(Integer id, Produto entity) {
        Produto produtoEncntrado = this.get(id);

        if(produtoEncntrado.getId()!=0 || produtoEncntrado.getId()!=null){
            return produtoRepository.save(entity);
        }
        else{

            return new Produto();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        produtoRepository.deleteById(id);
    }
}

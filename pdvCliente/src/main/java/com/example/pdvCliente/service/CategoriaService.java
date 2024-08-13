package com.example.pdvCliente.service;

import com.example.pdvCliente.interfaces.IService;
import com.example.pdvCliente.model.Categoria;
import com.example.pdvCliente.model.Produto;
import com.example.pdvCliente.repository.CategoriaRepository;
import com.example.pdvCliente.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service

public class CategoriaService implements IService<Categoria, Integer> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Categoria create(Categoria entity) {
        return categoriaRepository.save(entity);
    }

    @Override
    public Categoria get(Integer id) {
        Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(id);
        if(categoriaEncontrada.isPresent()){
            return categoriaEncontrada.get();
        }
        else {
            return new Categoria();
        }
    }

    @Override
    public List<Categoria> get() {
        return categoriaRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Categoria update(Integer id, Categoria entity) {
        Categoria categoriaEncntrada = this.get(id);

        if(categoriaEncntrada.getId()!=0 || categoriaEncntrada.getId()!=null){
            return categoriaRepository.save(entity);
        }
        else{

            return new Categoria();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        categoriaRepository.deleteById(id);
    }
}


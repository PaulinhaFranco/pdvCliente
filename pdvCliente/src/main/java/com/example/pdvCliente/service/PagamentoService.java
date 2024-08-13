package com.example.pdvCliente.service;

import com.example.pdvCliente.interfaces.IService;
import com.example.pdvCliente.model.Pagamento;
import com.example.pdvCliente.repository.PagamentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service

public class PagamentoService implements IService<Pagamento, Integer> {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Pagamento create(Pagamento entity) {
        return pagamentoRepository.save(entity);
    }

    @Override
    public Pagamento get(Integer id) {
        Optional<Pagamento> pagamentoEncontrado = pagamentoRepository.findById(id);
        if(pagamentoEncontrado.isPresent()){
            return pagamentoEncontrado.get();
        }
        else {
            return new Pagamento();
        }
    }

    @Override
    public List<Pagamento> get() {
        return pagamentoRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Pagamento update(Integer id, Pagamento entity) {
        Pagamento pagamentoEncontrado = this.get(id);

        if(pagamentoEncontrado.getId()!=0 || pagamentoEncontrado.getId()!=null){
            return pagamentoRepository.save(entity);
        }
        else{
            //return null;
            return new Pagamento();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        pagamentoRepository.deleteById(id);
    }
}




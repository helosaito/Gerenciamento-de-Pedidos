package com.lachimia.saito.services;

import com.lachimia.saito.models.PedidoModel;
import com.lachimia.saito.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public List<PedidoModel> findall(){
        return pedidoRepository.findAll();
    }

    public PedidoModel criarPedido(PedidoModel livroModel){
        return pedidoRepository.save(livroModel);
    }

    public PedidoModel listarPedido(Long id){
        return pedidoRepository.findById(id).get();
    }

    public Optional<PedidoModel> buscarPedido(Long id){
        return pedidoRepository.findById(id);
    }

    public void deltarPedido(Long id){
        pedidoRepository.deleteById(id);
    }
}

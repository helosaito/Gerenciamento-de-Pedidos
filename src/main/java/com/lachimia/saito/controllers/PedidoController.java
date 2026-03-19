package com.lachimia.saito.controllers;

import com.lachimia.saito.models.PedidoModel;
import com.lachimia.saito.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoModel>>findAll(){
        List<PedidoModel> requeste = pedidoService.findall();
        return ResponseEntity.ok(requeste);
    }

    @PostMapping
    public ResponseEntity<PedidoModel>criarPedido(@RequestBody PedidoModel pedidoModel){
        PedidoModel pedido = pedidoService.criarPedido(pedidoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(pedido);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?>deletarPedido(Long id){
        pedidoService.deltarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<PedidoModel> buscarpedido(Long id){
        return pedidoService.buscarPedido(id);
    }

    @GetMapping("/{id}")
    public PedidoModel listarPedido(Long id){
        return pedidoService.listarPedido(id);
    }
}

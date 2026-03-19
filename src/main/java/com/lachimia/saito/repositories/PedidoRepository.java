package com.lachimia.saito.repositories;

import com.lachimia.saito.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}

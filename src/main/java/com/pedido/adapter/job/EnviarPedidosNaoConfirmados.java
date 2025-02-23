package com.pedido.adapter.job;

import org.springframework.scheduling.annotation.Scheduled;

public class EnviarPedidosNaoConfirmados {
    @Scheduled(fixedRate = 5000)
    public void enviarPedidosNaoConfirmados() {

    }

}

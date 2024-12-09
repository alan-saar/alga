package com.alga.tdd.pedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.alga.tdd.pedidos.email.NotificadorEmail;
import com.alga.tdd.pedidos.repository.PedidosRepository;
import com.alga.tdd.pedidos.service.PedidoService;
import com.alga.tdd.pedidos.sms.NotificadorSms;

public class PedidoServiceTest {

    private PedidoService pedidoService;

    @Mock
    private PedidosRepository pedidos;

    @Mock
    private NotificadorEmail notificadorEmail;

    @Mock
    private NotificadorSms notificadorSms;

    private Pedido pedido;

    @BeforeEach
    public void setup() {
        // ou usa @Mock ou faz o mock direto assim
        // PedidosRepository pedidos = Mockito.mock(PedidosRepository.class);
        MockitoAnnotations.openMocks(this);
        pedidoService = new PedidoService(pedidos, notificadorEmail, notificadorSms);

        pedido = new PedidoBuilder()
                .comValor(100.0)
                .para("João", "joao@joao.com", "999-000")
                .construir();
    }

    @Test
    public void deveCalcularOImposto() {
        double imposto = pedidoService.lancar(pedido);
        assertEquals(10.0, imposto);
    }

    @Test
    public void deveSalvarPedidoNoBancoDeDados() {
        pedidoService.lancar(pedido);
        Mockito.verify(pedidos).guardar(pedido);
    }

    @Test
    public void deveNotificarPorEmail() {
        pedidoService.lancar(pedido);
        Mockito.verify(notificadorEmail).enviar(pedido);

    }

    @Test
    public void deveNotificarPorSMS() {
        pedidoService.lancar(pedido);
        Mockito.verify(notificadorSms).notificar(pedido);
    }
}

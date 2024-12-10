package com.alga.tdd.pedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import com.alga.tdd.exceptions.StatusPedidoInvalidoException;
import com.alga.tdd.pedidos.email.NotificadorEmail;
import com.alga.tdd.pedidos.repository.PedidosRepository;
import com.alga.tdd.pedidos.service.AcaoLancamentoPedido;
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
        List<AcaoLancamentoPedido> acoes = List.of(notificadorEmail, notificadorSms);

        pedidoService = new PedidoService(pedidos, acoes);

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
        verify(pedidos).guardar(pedido);
    }

    @Test
    public void deveNotificarPorEmail() {
        pedidoService.lancar(pedido);
        verify(notificadorEmail).executar(pedido);

    }

    @Test
    public void deveNotificarPorSMS() {
        pedidoService.lancar(pedido);
        verify(notificadorSms).executar(pedido);
    }

    @Test
    public void devePagarPedidoPendente() {
        Long codigoPedido = 135L;

        Pedido pedidoPendente = new Pedido();
        pedidoPendente.setStatus(StatusPedido.PENDENTE);
        when(pedidos.buscarPeloCodigo(codigoPedido)).thenReturn(pedidoPendente);

        Pedido pedidoPago = pedidoService.pagar(codigoPedido);

        assertEquals(StatusPedido.PAGO, pedidoPago.getStatus());
    }

    @Test
    public void deveNegarPagamento() {
        Long codigoPedido = 135L;

        Pedido pedidoPendente = new Pedido();
        pedidoPendente.setStatus(StatusPedido.PAGO);
        when(pedidos.buscarPeloCodigo(codigoPedido)).thenReturn(pedidoPendente);

        assertThrows(StatusPedidoInvalidoException.class, () -> {
            pedidoService.pagar(codigoPedido);
        });

    }
}

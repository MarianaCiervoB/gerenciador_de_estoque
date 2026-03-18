package com.estoque;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GerenciadorEstoqueTest {
    GerenciadorEstoque estoque;

    @BeforeEach
    void setup() { estoque = new GerenciadorEstoque(); }

    @Test
    void testeVendaSucesso() {
        estoque.adicionar(new Produto("Teclado", 10));
        estoque.vender("Teclado", 3);
        assertEquals(7, estoque.buscar("Teclado").getQuantidade());
    }

    @Test
    void testeEstoqueInsuficiente() {
        estoque.adicionar(new Produto("Mouse", 2));
        assertThrows(IllegalArgumentException.class, () -> estoque.vender("Mouse", 5));
    }
}

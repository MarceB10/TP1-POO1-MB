package ar.edu.unrn.Restaurante;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ItemMenuTest {

    @Test
    void testItemMenuInvalido(){
        assertThrows(RuntimeException.class, () -> new ItemMenu(100, ItemMenu.Tipo.BEBIDA, ""));
    }



}
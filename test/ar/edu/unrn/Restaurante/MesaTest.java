package ar.edu.unrn.Restaurante;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MesaTest {
    //Datos comunes
    private final ItemMenu gaseosa = new ItemMenu(100, ItemMenu.Tipo.BEBIDA,"Gaseosa");
    private final ItemMenu pizza = new ItemMenu(200, ItemMenu.Tipo.PLATO,"Pizza" );
    private final LocalDate fechaValida = LocalDate.now().plusDays(1);

    @Test
    void testCalculoConVisa(){
        var mesa = new Mesa("Mesa 1");
        mesa.agregarItem(gaseosa);
        mesa.agregarItem(pizza);
        var visa = new Visa("111111111111", "Messi", fechaValida);

        float total = mesa.calcularTotal(visa, Propina.MEDIO); //3% descuento en bebidas y 3% + en bebidas
        assertEquals(305.91f, total);                 //(97+200) * 1.03 = 305.91

    }

    @Test
    void testCalculoConMastercard(){
        var mesa = new Mesa("Mesa 2");
        mesa.agregarItem(gaseosa);
        mesa.agregarItem(pizza);
        var mastercard = new Mastercard("11111111111", "Messi", fechaValida);

        float total = mesa.calcularTotal(mastercard, Propina.MEDIO); //2% descuento en platos y 3% en propina
        assertEquals(304.88f, total);                 //(100 + 196) * 1.03
    }

    @Test
    void testCalculoComarcaPlus(){
        var mesa = new Mesa("Mesa 3");
        mesa.agregarItem(gaseosa);
        mesa.agregarItem(pizza);
        var comarcaPlus = new ComarcaPlus("11111111111", "Messi", fechaValida);

        float total = mesa.calcularTotal(comarcaPlus,Propina.ALTO);// 2% descuento al total + 5% propina
        assertEquals(308.69f,total, 0.01f);                                  // (300 - 2%) + 5%

    }

    @Test
    void testCalculoTarjetaViedma(){
        var mesa = new Mesa("Mesa 4");
        mesa.agregarItem(gaseosa);
        mesa.agregarItem(pizza);
        var tarjetaViedma = new TarjetaSinDescuento("11111111111", "Messi", fechaValida);

        float total = mesa.calcularTotal(tarjetaViedma, Propina.BAJO);//+2% de propina
        assertEquals(306.0f,total);                                               //300 * 1.02 = 306
    }

    @Test
    void testValidacionTarjetaVacia(){
        //var visa = new Visa("111111111111", "Messi", LocalDate.now().minusMonths(1));
        assertThrows(RuntimeException.class, () ->
                new Visa("11111111111111", "Messi", LocalDate.now().minusMonths(1)));
    }
}

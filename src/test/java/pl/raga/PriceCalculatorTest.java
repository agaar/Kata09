package pl.raga;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

    private static Shop shop ;

    @org.junit.jupiter.api.BeforeEach
    public void beforeClass(){
        shop = new Shop();
    }

    @org.junit.jupiter.api.Test
    void testEmpty() throws Exception {
        assertEquals(0.00, shop.price(""), 0);
    }

    @org.junit.jupiter.api.Test
    void testTotalsA() throws Exception {
        assertEquals(50.00, shop.price("A"), 0);
    }

    @org.junit.jupiter.api.Test
    void testTotalsAB() throws Exception {
        assertEquals(80.00, shop.price("AB"), 0);
    }

    @org.junit.jupiter.api.Test
    void testTotalsCDBA() throws Exception {
        assertEquals(115.00, shop.price("CDBA"), 0);
    }

    @org.junit.jupiter.api.Test
    void testTotalsAA() throws Exception {
        assertEquals(100.00, shop.price("AA"), 0);
    }

    @org.junit.jupiter.api.Test
    void testTotalsAAA() throws Exception {
        assertEquals(130.00, shop.price("AAA"), 0);
    }

    @org.junit.jupiter.api.Test
    void testTotalsAAAA() throws Exception {
        assertEquals(180.00, shop.price("AAAA"), 0);
    }

    @org.junit.jupiter.api.Test
    void testTotalsAAAAA() throws Exception {
        assertEquals(230.00, shop.price("AAAAA"), 0);
    }

    @org.junit.jupiter.api.Test
    void testTotalsAAAAAA() throws Exception {
        assertEquals(260.00, shop.price("AAAAAA"), 0);
    }

    @org.junit.jupiter.api.Test
    void testTotalsAAAB() throws Exception {
        assertEquals(160.00, shop.price("AAAB"), 0);
    }

    @org.junit.jupiter.api.Test
    void testTotalsAAABB() throws Exception {
        assertEquals(175.00, shop.price("AAABB"), 0);
    }

    @org.junit.jupiter.api.Test
    void testTotalsAAABBD() throws Exception {
        assertEquals(190.00, shop.price("AAABBD"), 0);
    }

    @org.junit.jupiter.api.Test
    void testTotalsDABABA() throws Exception {
        assertEquals(190.00, shop.price("DABABA"), 0);
    }

    @org.junit.jupiter.api.Test
    void testNotExistingPromotion() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            shop.price("H");
        });
        String expectedMessage = "Not existing promotion code";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @org.junit.jupiter.api.Test
    void testIncremental() throws Exception {
        shop.scan("A");
        assertEquals(50.00, shop.total(), 0);
        shop.scan("B");
        assertEquals(80.00, shop.total(), 0);
        shop.scan("A");
        assertEquals(130.00, shop.total(), 0);
        shop.scan("A");
        assertEquals(160.00, shop.total(), 0);
        shop.scan("B");
        assertEquals(175.00, shop.total(), 0);
    }
}
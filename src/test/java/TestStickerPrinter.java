import org.junit.Test;
import static org.junit.Assert.*;

public class TestStickerPrinter {
    @Test
    public void createStickerTest() {
//        Test1
        String[][] array = {{"Oreo", "abc", "0.05"}, {"Kit-kat", "14", "0.1"}};
        StickerPrinter tmp = new StickerPrinter(array);
        String result = tmp.createSticker("kit");
        assertEquals("INVALID_PRODUCT_NAME", result);
//        Test2
        array = new String[][]{{"Oreo", "103", "0.05"}, {"Kit-kat", "14", "0.1"}};
        tmp = new StickerPrinter(array);
        result = tmp.createSticker("Kit-kat");
        assertEquals("Kit-kat 15.40", result);
//        Tast3
        array = new String[][]{{"Oreo", "103", "0.05"}, {"Kit-kat", "14", "0.1"},{"Snickers", "15", "0"}};
        tmp = new StickerPrinter(array);
        result = tmp.createSticker("Snickers");
        assertEquals("Snickers 15.00", result);
//        Test4
        array = new String[][]{{"Oreo", "103", "0.05"}, {"Kit-kat", "14", "0.1"},{"Snickers", "15", "0"}, {"Nike", "-6", "0.42"}};
        tmp = new StickerPrinter(array);
        result = tmp.createSticker("Nike");
        assertEquals("Nike INVALID_PRICE", result);
//        Test5
        array = new String[][]{{"Oreo", "103", "0.05"}, {"Kit-kat", "14", "0.1"},{"Snickers", "15", "0"}, {"Nike", "1000", "-0.42"}};
        tmp = new StickerPrinter(array);
        result = tmp.createSticker("Nike");
        assertEquals("Nike INVALID_PRICE", result);
    }
}

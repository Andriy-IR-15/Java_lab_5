package ua.lviv.iot;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreLocationsTest {
    @Test
    void testFindLocations() throws IOException {
        StoreLocations storeLocations = new StoreLocations();
        ArrayList<String> locations = storeLocations.findLocations();
        assertEquals(locations.size(), 3);
        assertEquals(locations.get(0), "\"Еко-Продукт\" N 50.44'58\" E 30.52'36\"");
        assertEquals(locations.get(1), "\"Дім і Сад\" N 50.45'55\" E 30.51'83\"");
        assertEquals(locations.get(2), "\"Сільпо\" N 50.44'71\" E 30.52'29\"");
    }

    public static void main(String[] args) {
        StoreLocations storeLocations = new StoreLocations();
        storeLocations.printLocations();
    }
}
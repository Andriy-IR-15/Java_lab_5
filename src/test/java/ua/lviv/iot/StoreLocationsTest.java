package ua.lviv.iot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class StoreLocationsTest {

    @Test
    public void testFindLocations() {
        String filePath = "testStores.txt";
        ArrayList<String> expectedLocations = new ArrayList<String>();
        expectedLocations.add("\"Еко-Продукт\" N 50.44'58\" E 30.52'36\"");
        expectedLocations.add("\"Дім і Сад\" N 50.45'55\" E 30.51'83\"");
        expectedLocations.add("\"Сільпо\" N 50.44'71\" E 30.52'29\"");
        try {
            ArrayList<String> actualLocations = StoreLocations.findLocations(filePath);
            assertEquals(expectedLocations, actualLocations);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

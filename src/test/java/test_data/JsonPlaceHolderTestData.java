package test_data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonPlaceHolderTestData {

    public Map<String, Objects> expectedDataSetUp() {

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 55);
        expectedData.put("title", "Wash the dishes");
        expectedData.put("completed", false);

        return null;
    }
}

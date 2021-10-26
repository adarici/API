package test_data;

import java.util.HashMap;
import java.util.Map;

public class ReviewJsonPlaceHolderTestData {
    public Map<String,Object> expectedDataSetUp(){
     Map<String,Object> expectedData = new HashMap<>();
     expectedData.put("userId",55);
//     expectedData.put("title","Tidy your room");
//     expectedData.put("completed",true);
        return expectedData;
    }
}

package com;

import org.apache.commons.math.util.MathUtils;
import org.codehaus.jackson.node.ObjectNode;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;

public class GlanceQuery{

	JsonWriter jsonWriter = new JsonWriter();
	
    public ObjectNode calculateChangeInViews(SortedMap<String, Integer> map) throws IOException {
        ObjectNode results = jsonWriter.createObjectNode();
        Integer first = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String date = entry.getKey();
            int count = entry.getValue();

                //System.out.printf("calculateChangeInViews: date: %s, count: %s", date, count);

            if (count <= 0)
                continue;

            double value;

            if (first == null) {
                first = count;
                value = 1.0f;
            } else {
                value = (float) count / (float) first;
                value = MathUtils.round(value, 3);
            }

            System.out.printf("calculateChangeInViews: date: %s, count: %s, value: %s\n", date, count, value);

            // TODO: there's a known bug in Jackson wherein floats lose/gain precision.
            results.put(date, value);
        }
        jsonWriter.writeJson(results, 1);
        return results;
    }

}

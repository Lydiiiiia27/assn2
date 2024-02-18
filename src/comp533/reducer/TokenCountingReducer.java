package comp533.reducer;

import gradingTools.comp533s19.assignment0.AMapReduceTracer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comp533.mapping.KeyValueInterface;

import java.util.Iterator;

public class TokenCountingReducer extends AMapReduceTracer implements ReducerInterface<String, Integer> {
    private static final AMapReduceTracer INSTANCE = new TokenCountingReducer();

    private TokenCountingReducer() {}

    public static ReducerInterface<String, Integer> getInstance() {
        return (ReducerInterface<String, Integer>) INSTANCE;
    }

    @Override
    public Map<String, Integer> reduce(final List<KeyValueInterface<String, Integer>> keyValues) {
       final Map<String, Integer> reducedMap = new HashMap<>();
        
//        for (KeyValueInterface<String, Integer> keyValue : keyValues) {
//            String key = keyValue.getKey();
//            Integer currentValue = reducedMap.getOrDefault(key, 0);
//            reducedMap.put(key, currentValue + keyValue.getValue());
//        }
       final Iterator<KeyValueInterface<String, Integer>> it = keyValues.iterator();
        while (it.hasNext()) {
           final KeyValueInterface<String, Integer> keyValue = it.next();
           final String key = keyValue.getKey();
           final Integer currentValue = reducedMap.getOrDefault(key, 0);
            reducedMap.put(key, currentValue + keyValue.getValue());
        }
        
        traceReduce(keyValues, reducedMap);
        return reducedMap;
    }

    @Override
    public String toString() {
        return REDUCER;
    }
}

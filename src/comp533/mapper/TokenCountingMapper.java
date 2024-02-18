package comp533.mapper;

import java.util.ArrayList;
import java.util.List;

import comp533.mapping.KeyValueInterface;
import comp533.mapping.KeyValuePair;
import gradingTools.comp533s19.assignment0.AMapReduceTracer;

public class TokenCountingMapper extends AbstractMapper implements MapperInterface<String, Integer> {
    //private static final MapperInterface<String, Integer> INSTANCE = new TokenCountingMapper();
	private static MapperInterface<String, Integer> instance;
    private TokenCountingMapper() {}

   
    public static synchronized MapperInterface<String, Integer> getSingleton() {
        if (instance == null) {
        	instance = new TokenCountingMapper();
        }
        return instance;
    }

    @Override
    public List<KeyValueInterface<String, Integer>> map(final List<String> aStrings) {
        final List<KeyValueInterface<String, Integer>> mappedList = new ArrayList<>();
        for (String string : aStrings) {
        	traceMap(string,1);
            mappedList.add(new KeyValuePair<>(string, 1));
        }
        return mappedList;
    }

    @Override
    public String toString() {
        return AMapReduceTracer.TOKEN_COUNTING_MAPPER;
    }
}

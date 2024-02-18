package comp533.mapper;

import java.util.ArrayList;
import java.util.List;

import comp533.mapping.KeyValueInterface;
import comp533.mapping.KeyValuePair;
//import gradingTools.comp533s19.assignment0.AMapReduceTracer;

public class IntSummingMapper extends AbstractMapper implements MapperInterface<String, Integer> {
	private static MapperInterface<String, Integer> instance;
	public static final String RESULT_KEY = "ResultKey";
   // private static final MapperInterface<String, Integer> INSTANCE = new IntSummingMapper();

    public IntSummingMapper() {}

/*    public static MapperInterface<String, Integer> getInstance() {
        return new IntSummingMapper();
    }
*/
    
    public static  MapperInterface<String, Integer> getSingleton() {
        if (instance == null) {
        	instance = new IntSummingMapper();
        }
        return instance;
    }
    @Override
    public List<KeyValueInterface<String, Integer>> map(final List<String> aStrings) {
        final List<KeyValueInterface<String, Integer>> mappedList = new ArrayList<>();
        for (String string : aStrings) {
            try {
                final int value = Integer.parseInt(string);
                mappedList.add(new KeyValuePair<>(RESULT_KEY, value));
            } catch (NumberFormatException excp) {
                // Ignore non-integer values
            }
        }

        // Correct tracing with KeyValue objects
        traceMap(aStrings, mappedList);

        return mappedList;
    }

    @Override
    public String toString() {
        return INT_SUMMING_MAPPER;
    }
}

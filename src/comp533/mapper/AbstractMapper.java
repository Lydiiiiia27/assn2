package comp533.mapper;

import java.util.List;

import comp533.mapping.KeyValueInterface;
import gradingTools.comp533s19.assignment0.AMapReduceTracer;

public abstract class AbstractMapper extends AMapReduceTracer implements MapperInterface<String, Integer> {
    protected AbstractMapper() {}

    public static MapperInterface<String, Integer> getSingleton() {
        
        throw new UnsupportedOperationException("This method should be overridden in subclasses");
    }

    @Override
    public abstract List<KeyValueInterface<String, Integer>> map(final List<String> aStrings);

    @Override
    public abstract String toString();
}


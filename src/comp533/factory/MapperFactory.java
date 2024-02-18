package comp533.factory;

import comp533.mapper.MapperInterface;
import comp533.mapper.TokenCountingMapper;
import gradingTools.comp533s19.assignment0.AMapReduceTracer;

public class MapperFactory extends AMapReduceTracer {
    private static MapperInterface<String, Integer> mapper = TokenCountingMapper.getSingleton();

    public static MapperInterface<String, Integer> getMapper() {
        return mapper;
    }

    public static void setMapper(final MapperInterface<String, Integer> newMapper) {
        mapper = newMapper;
        AMapReduceTracer.traceSingletonChange(MapperFactory.class, newMapper);
    }
}

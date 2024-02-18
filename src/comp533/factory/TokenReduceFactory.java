package comp533.factory;

import comp533.reducer.ReducerInterface;
import comp533.reducer.TokenCountingReducer;
import gradingTools.comp533s19.assignment0.AMapReduceTracer;

public class TokenReduceFactory {
    private static ReducerInterface<String, Integer> reducer = TokenCountingReducer.getInstance();

    public static ReducerInterface<String, Integer> getReducer() {
        return reducer;
    }

    public static void setReducer(final ReducerInterface<String, Integer> newReducer) {
        reducer = newReducer;
        AMapReduceTracer.traceSingletonChange(TokenReduceFactory.class, newReducer);
    }
}

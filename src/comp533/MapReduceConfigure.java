package comp533;

import comp533.mvc.TokenCounterController;
import comp533.mvc.TokenCounterModel;
import comp533.mvc.TokenCounterView;
//import comp533.stubs.*;
import comp533.token.TokenCounter;
import gradingTools.comp533s21.assignment1.interfaces.MapReduceConfiguration;

public class MapReduceConfigure implements MapReduceConfiguration {

	@Override
	public Object getBarrier(final int arg0) {
		// TODO Auto-generated method stub
		return comp533.Barrier.getBarrier(arg0);
	}

	@Override
	public Class<?> getBarrierClass() {
		// TODO Auto-generated method stub
		return comp533.Barrier.class;
	}

	@Override
	public Class<?> getClientTokenCounter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getControllerClass() {
		// TODO Auto-generated method stub
		return TokenCounterController.class;
	}

	@Override
	public Object getIntSummingMapper() {
		// TODO Auto-generated method stub
		return comp533.mapper.IntSummingMapper.getSingleton();
	}

	@Override
	public Class getIntSummingMapperClass() {
		// TODO Auto-generated method stub
		return comp533.mapper.IntSummingMapper.class;
	}

	@Override
	public Object getJoiner(final int arg0) {
		// TODO Auto-generated method stub
		return comp533.Joiner.getJoiner(arg0);
	}

	@Override
	public Class<?> getJoinerClass() {
		// TODO Auto-generated method stub
		return comp533.Joiner.class;
	}

	@Override
	public Class<?> getKeyValueClass() {
		// TODO Auto-generated method stub
		return comp533.mapping.KeyValuePair.class;
	}

	@Override
	public Class<?> getMapperFactory() {
		// TODO Auto-generated method stub
		return comp533.factory.MapperFactory.class;
	}

	@Override
	public Class<?> getModelClass() {
		// TODO Auto-generated method stub
		return TokenCounterModel.class;
	}

	@Override
	public Object getPartitioner() {
		// TODO Auto-generated method stub
		return comp533.partition.PartitionerFactory.getPartitioner();
	}

	@Override
	public Class<?> getPartitionerClass() {
		// TODO Auto-generated method stub
		return comp533.partition.Partitioner.class;
	}

	@Override
	public Class<?> getPartitionerFactory() {
		// TODO Auto-generated method stub
		return comp533.partition.PartitionerFactory.class;
	}

	@Override
	public Object getReducer() {
		// TODO Auto-generated method stub
		return comp533.reducer.TokenCountingReducer.getInstance();
	}

	@Override
	public Class<?> getReducerClass() {
		// TODO Auto-generated method stub
		return comp533.reducer.TokenCountingReducer.class;
	}

	@Override
	public Class<?> getReducerFactory() {
		// TODO Auto-generated method stub
		return comp533.factory.TokenReduceFactory.class;
	}

	@Override
	public Class<?> getRemoteClientFacebookMapReduce() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getRemoteClientObjectClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getRemoteClientObjectInterface() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getRemoteModelInterface() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getServerFacebookMapReduce() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getServerIntegerSummer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getServerTokenCounter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getSlaveClass() {
		// TODO Auto-generated method stub
		return Slave.class;
	}

	@Override
	public Class<?> getStandAloneFacebookMapReduce() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getStandAloneIntegerSummer() {
		// TODO Auto-generated method stub
		return comp533.main.IntSummingMain.class;
	}

	@Override
	public Class<TokenCounter> getStandAloneTokenCounter() {
		// TODO Auto-generated method stub
		return TokenCounter.class;
	}

	@Override
	public Object getTokenCountingMapper() {
		// TODO Auto-generated method stub
		return comp533.mapper.TokenCountingMapper.getSingleton();
	}

	@Override
	public Class<?> getTokenCountingMapperClass() {
		// TODO Auto-generated method stub
		return comp533.mapper.TokenCountingMapper.class;
	}

	@Override
	public Class<?> getViewClass() {
		// TODO Auto-generated method stub
		return TokenCounterView.class;
	}

}

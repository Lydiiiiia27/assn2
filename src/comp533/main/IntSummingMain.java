package comp533.main;

import comp533.mvc.TokenCounterModel;
import comp533.mvc.TokenCounterView;
import comp533.mvc.IController;
import comp533.mvc.IModel;
//import comp533.mvc.IView;
import comp533.mvc.TokenCounterController;

import java.beans.PropertyChangeListener;

import comp533.factory.MapperFactory;
import comp533.mapper.IntSummingMapper;

public class IntSummingMain {
    public static void main(final String[] args) {
        MapperFactory.setMapper(new IntSummingMapper()); // Set the Int Summing Mapper

        final TokenCounterModel model = new TokenCounterModel();
        final PropertyChangeListener view = new TokenCounterView();
        final IController controller = new TokenCounterController( model);

        model.addPropertyChangeListener((PropertyChangeListener) view);
        controller.processInput();
    }
}

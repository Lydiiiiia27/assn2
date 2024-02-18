package comp533.mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface IView {
	void updateView(String data);

	PropertyChangeListener getPropertyChangeListener();

	void propertyChange(PropertyChangeEvent evt);
}

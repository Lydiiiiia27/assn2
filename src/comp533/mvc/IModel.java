package comp533.mvc;

import java.beans.PropertyChangeListener;
import java.util.Map;

public interface IModel {
    String getInputString();
    void setInputString(String inputString);
    Map<String, Integer> getResult();
    void addPropertyChangeListener(PropertyChangeListener listener);
}

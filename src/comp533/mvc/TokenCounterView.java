/*package comp533.mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
//import java.util.EventListener;

import gradingTools.comp533s19.assignment0.AMapReduceTracer;

public  class TokenCounterView extends AMapReduceTracer implements PropertyChangeListener, IView {
 //   private final PropertyChangeListener innerListener = new PropertyChangeListener() {
	@Override
    public void propertyChange(final PropertyChangeEvent evt) {
       tracePropertyChange(evt);
    }

    @Override
    public PropertyChangeListener getPropertyChangeListener() {
    	return innerListener;
    }
    @Override
    public String toString() {
        return gradingTools.comp533s19.assignment0.AMapReduceTracer.VIEW;
    }

	@Override
	public void updateView(final String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PropertyChangeListener getPropertyChangeListener() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    public void propertyChange(final PropertyChangeEvent evt) {
        innerListener.propertyChange(evt);
    }
	
}
*/

package comp533.mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import gradingTools.comp533s19.assignment0.AMapReduceTracer;

public class TokenCounterView extends AMapReduceTracer implements PropertyChangeListener {
   
    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        tracePropertyChange(evt);
    }

/*    @Override
    public void updateView(final String data) {
        
    }

    @Override
    public PropertyChangeListener getPropertyChangeListener() {
        
        return this;
    }
*/
    @Override
    public String toString() {
        return gradingTools.comp533s19.assignment0.AMapReduceTracer.VIEW;
    }
}

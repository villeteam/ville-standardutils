package fi.utu.ville.standardutils.client;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.Connector;

public class FocusChangingTextFieldState extends AbstractComponentState {
	private static final long serialVersionUID = -539970526903290526L;
	private Connector nextComponent;
	private Connector previousComponent;
	private Connector upComponent;
	private Connector downComponent;
	private int changeAfter = 1;
	
	public int getChangeAfter() {
		return changeAfter;
	}
	
	public void setChangeAfter(int changeAfter) {
		this.changeAfter = changeAfter;
	}
	
	public boolean hasNextComponent() {
		return nextComponent != null;
	}
	
	public boolean hasPreviousComponent() {
		return previousComponent != null;
	}
	public boolean hasUpComponent() {
		return upComponent != null;
	}
	public boolean hasDownComponent() {
		return downComponent != null;
	}
	
	public Connector getNextComponent() {
		return nextComponent;
	}
	
	public void setNextComponent(Connector otherComponent) {
		this.nextComponent = otherComponent;
	}


	public Connector getPreviousComponent() {
		return previousComponent;
	}

	public void setPreviousComponent(Connector previousComponent) {
		this.previousComponent = previousComponent;
	}

	public Connector getUpComponent() {
		return upComponent;
	}

	public void setUpComponent(Connector upComponent) {
		this.upComponent = upComponent;
	}

	public Connector getDownComponent() {
		return downComponent;
	}

	public void setDownComponent(Connector downComponent) {
		this.downComponent = downComponent;
	}
	
	
	
}
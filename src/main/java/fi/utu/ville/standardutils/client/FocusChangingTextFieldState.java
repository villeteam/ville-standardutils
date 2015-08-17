package fi.utu.ville.standardutils.client;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.Connector;

import fi.utu.ville.standardutils.client.FocusChangingTextFieldConnector.StateHelper;


public class FocusChangingTextFieldState extends AbstractComponentState {
	public enum FocusLogicType {
		DEFAULT,
		ROW_CALC;
		
		public FocusLogic create(StateHelper state) {
			if(this == DEFAULT) {
				return new FocusLogic(state);
			}
			else if(this == ROW_CALC) {
				return new RowCalcLogic(state);
			}
			return null;
		}
	}
	
	private static final long serialVersionUID = -539970526903290526L;
	
	private Connector rightComponent;
	private Connector leftComponent;
	private Connector upComponent;
	private Connector downComponent;
	private FocusLogicType focusLogic = FocusLogicType.DEFAULT;
	
	private int changeAfter = 1;

	public int getChangeAfter() {
		return changeAfter;
	}

	public Connector getDownComponent() {
		return downComponent;
	}
	
	public FocusLogicType getFocusLogic() {
		return focusLogic;
	}
	
	public Connector getLeftComponent() {
		return leftComponent;
	}
	
	public Connector getRightComponent() {
		return rightComponent;
	}
	
	public Connector getUpComponent() {
		return upComponent;
	}
	
	public boolean hasDownComponent() {
		return downComponent != null;
	}
	
	public boolean hasLeftComponent() {
		return leftComponent != null;
	}
	
	public boolean hasRightComponent() {
		return rightComponent != null;
	}
	
	public boolean hasUpComponent() {
		return upComponent != null;
	}

	public void setChangeAfter(int changeAfter) {
		this.changeAfter = changeAfter;
	}

	public void setDownComponent(Connector downComponent) {
		this.downComponent = downComponent;
	}

	public void setFocusLogic(FocusLogicType focusLogic) {
		this.focusLogic = focusLogic;
	}

	public void setLeftComponent(Connector previousComponent) {
		this.leftComponent = previousComponent;
	}

	public void setRightComponent(Connector otherComponent) {
		this.rightComponent = otherComponent;
	}

	public void setUpComponent(Connector upComponent) {
		this.upComponent = upComponent;
	}
}
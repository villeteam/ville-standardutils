package edu.vserver.ville.JSXGraph;

public class JSXDerivativeGlider extends JSXElement{

	private String id;
	private String funcId;
	private String gliderId;

	public JSXDerivativeGlider(JSXGraphComponent parent,
			String id, String funcId, String gliderId) {
		super(parent);
		this.id = id;
		this.funcId = funcId;
		this.gliderId = gliderId;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the funcId
	 */
	public String getFuncId() {
		return funcId;
	}

	/**
	 * @param funcId the funcId to set
	 */
	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	/**
	 * @return the gliderId
	 */
	public String getGliderId() {
		return gliderId;
	}

	/**
	 * @param gliderId the gliderId to set
	 */
	public void setGliderId(String gliderId) {
		this.gliderId = gliderId;
	}

}

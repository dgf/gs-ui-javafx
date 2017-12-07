package org.graphstream.ui.fx.renderer.shape;

import org.graphstream.ui.fx.FxDefaultCamera;
import org.graphstream.ui.fx.renderer.shape.fx.Area;
import org.graphstream.ui.graphicGraph.GraphicEdge;
import org.graphstream.ui.graphicGraph.stylesheet.Style;

/** Some areas are attached to a connector (sprites). */
public class AreaOnConnector extends Area {
	/** The connector we are attached to. */
	protected Connector theConnector = null;
	
	/** The edge represented by the connector.. */
	protected GraphicEdge theEdge = null;
			
	/** XXX must call this method explicitly in the renderer !!! bad !!! XXX */
	public void theConnectorYoureAttachedTo(Connector connector) { theConnector = connector; }
	
	protected void configureAreaOnConnectorForGroup(Style style, FxDefaultCamera camera) {
		sizeForEdgeArrow(style, camera);
	}
	
	protected void configureAreaOnConnectorForElement(GraphicEdge edge, Style style, FxDefaultCamera camera) {
		connector(edge);
		theCenter.set(edge.to.getX(), edge.to.getY());
	}
	
	private void connector(GraphicEdge edge) { theEdge = edge ; }
 
	private void sizeForEdgeArrow(Style style, FxDefaultCamera camera) {
		double w = camera.getMetrics().lengthToGu(style.getArrowSize(), 0);
		double h = w ;
		if(style.getArrowSize().size() > 1)
			h = camera.getMetrics().lengthToGu(style.getArrowSize(), 1) ;
  
		theSize.set(w, h);
	}
	
}
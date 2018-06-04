package hydraulic;

/**
 * Represents a source of water, i.e. the initial element for the simulation.
 *
 * Lo status of the source is defined through the method
 * {@link #setFlow(double) setFlow()}.
 */
public class Source extends Element {

	private double flow;
	
	public Source(String name) {
		super(name);
	}

	public void setFlow(double flow){
		this.flow = flow;
	}
	
	public void simulate(double flow) {
		flow = this.flow;
		System.out.println("[" + this.getName() + "]Source outcoming flow: " + flow + "\n");
		this.getOutput().simulate(flow);
		
		
	}
	
	
}

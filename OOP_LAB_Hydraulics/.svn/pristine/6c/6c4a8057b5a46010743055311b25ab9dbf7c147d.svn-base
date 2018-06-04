package hydraulic;

/**
 * Represents the sink, i.e. the terminal element of a system
 *
 */
public class Sink extends Element {

	/**
	 * Constructor
	 * @param name
	 */
	public Sink(String name) {
		super(name);
	}
	
	@Override
	public void connect(Element elem){
		System.out.println("Element " + this.getName() + " cannot be connected to Sink");
	}
	
	public void simulate(double flow) {
		System.out.println("[" + this.getName() + "]Sink incoming flow: " + flow + "\n");
	}
}

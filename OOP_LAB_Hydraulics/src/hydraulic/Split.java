package hydraulic;

/**
 * Represents a split element, a.k.a. T element
 * 
 * During the simulation each downstream element will
 * receive a stream that is half the input stream of the split.
 */

public class Split extends Element {

	private static int maxOutputs = 2;
	private Element [] downstreams;
	
	/**
	 * Constructor
	 * @param name
	 */
	public Split(String name) {
		super(name);
		this.downstreams = new Element[maxOutputs];
	}
    
	/**
	 * returns the downstream elements
	 * @return array containing the two downstream element
	 */
    public Element[] getOutputs(){
    	return this.downstreams;
    }

	public void connect(Element elem, int noutput){
		if((noutput < maxOutputs)&&(noutput >= 0))
			this.downstreams[noutput] = elem;
	}
	
	public void simulate(double flow) {
		System.out.println("[" + this.getName() + "]Split incoming flow: " + flow + " outcomunig flow: " + flow + "\n");
		for(Element el:downstreams)
			el.simulate(flow/(double) maxOutputs);		
	}
}

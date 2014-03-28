package miniera;

public class MinieraMarmo extends Miniera {

	private int latoBlocco;
	
	
	public MinieraMarmo(int riserva, int latoBlocco) {
		super(riserva);
		this.latoBlocco = latoBlocco;
	}


	@Override
	protected int getValore() {
		// TODO Auto-generated method stub
		return 2*(latoBlocco*latoBlocco*latoBlocco);
	}

}

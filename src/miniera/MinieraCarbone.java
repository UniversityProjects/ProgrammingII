package miniera;

public class MinieraCarbone extends Miniera {

	public MinieraCarbone(int riserva) {
		super(riserva);
	}

	@Override
	protected int getValore() {
		return 5;
	}

}

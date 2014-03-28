package ContoCorrenteGui;

public class ContoCorrente {
	private double saldo;
	
	public ContoCorrente(double deposito){
		this.saldo = deposito; 
	}
	
	
	public void deposita(double ammontare){
		if(ammontare >0){
			saldo+=ammontare;
		}
	}

	public void preleva(double ammontare){
		if(ammontare >0 && saldo>=ammontare){
			saldo-=ammontare;
		}
	}
		
	public double saldo(){
		return saldo;
	}
}

package springmvclab5;

public class CurrencyConverter {

	public float amount;
	public float exchangeRate;
	public Object result;
	public CurrencyConverter(float amount, float exchangeRate) {
		super();
		this.amount = amount;
		this.exchangeRate = exchangeRate;
	}
	
	public void convert() {
		result = amount * exchangeRate;
	}
	
}

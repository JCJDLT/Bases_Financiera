package model;

public class Amortizacion {
//	private int meses;
//	private double couta;
//	private double amortizacion;
//	private double interes;
//	private double balance;
	
	private String meses;
	private String couta;
	private String amortizacion;
	private String interes;
	private String balance;
	
//	public Amortizacion(int meses, double amortizacion, double interes, double couta, double balance) {
//		super();
//		this.meses = meses;
//		this.amortizacion = amortizacion;
//		this.interes = interes;
//		this.couta = couta;
//		this.balance = balance;
//	}
	
	public Amortizacion(String meses, String amortizacion, String interes, String couta, String balance) {
		super();
		this.meses = meses;
		this.amortizacion = amortizacion;
		this.interes = interes;
		this.couta = couta;
		this.balance = balance;
	}
	
	public Amortizacion() {
		
	}

	public String getMeses() {
		return meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	public String getCouta() {
		return couta;
	}

	public void setCouta(String couta) {
		this.couta = couta;
	}

	public String getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(String amortizacion) {
		this.amortizacion = amortizacion;
	}

	public String getInteres() {
		return interes;
	}

	public void setInteres(String interes) {
		this.interes = interes;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

//	public int getMeses() {
//		return meses;
//	}
//
//	public void setMeses(int meses) {
//		this.meses = meses;
//	}
//
//	public double getAmortizacion() {
//		return amortizacion;
//	}
//
//	public void setAmortizacion(double amortizacion) {
//		this.amortizacion = amortizacion;
//	}
//
//	public double getInteres() {
//		return interes;
//	}
//
//	public void setInteres(double interes) {
//		this.interes = interes;
//	}
//
//	public double getCouta() {
//		return couta;
//	}
//
//	public void setCouta(double couta) {
//		this.couta = couta;
//	}
//
//	public double getBalance() {
//		return balance;
//	}
//
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}
	
	
	
}

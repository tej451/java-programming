package com.designpattern;

public class DecoratorPatternTest {
	public static void main(String a[]){
		Currency currency = new Dollar();
		System.out.println(currency.getDescription() +" cost - "+currency.cost(2.00));
		Currency usdCurrency = new USDDecorator(new Dollar());
		System.out.println("USD Decorator "+usdCurrency.getDescription() + " cost - "+usdCurrency.cost(4.00));
		Currency sgpCurrency = new SGPDecorator(new Rupees());
		System.out.println("SGP Decorator "+sgpCurrency.getDescription() + " cost - "+sgpCurrency.cost(4.00));
	}
}

abstract class Currency{
	String description = "undefined description";

	public String getDescription() {
		return description;
	}
	
	public abstract double cost(double cost);
}

class Dollar extends Currency{
	double cost;
	public Dollar(){
		System.out.println("Dollar");
	}
	public double cost(double cost){
		return this.cost = cost;
	}
}

class Rupees extends Currency{
	double cost;
	public Rupees(){
		System.out.println("Rupees");
	}
	public double cost(double cost){
		return this.cost = cost;
	}
}

abstract class Decorator extends Currency{
	public abstract String getDescription();
	
	
}

class USDDecorator extends Decorator{
	Currency currency;
	public USDDecorator(Currency cu){
		currency = cu;
	}
	public String getDescription(){
		return currency.getDescription()+" USD currency";
	}
	
	public double cost(double cost){
		return currency.cost(cost);
	}
}

class SGPDecorator extends Decorator{
	Currency currency;
	public SGPDecorator(Currency cu){
		currency = cu;
	}
	public String getDescription(){
		return currency.getDescription()+" SGP currency";
	}
	
	public double cost(double cost){
		return currency.cost(cost);
	}
}
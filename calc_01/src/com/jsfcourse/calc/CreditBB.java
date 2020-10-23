package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class CreditBB {
	private String amount;
	private String years;
	private String percent;
	private Double result;
	
	
	@Inject
	FacesContext ctx;
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}
	public Double getResult() {
		return result;
	}

	
	
	
	

	public boolean doTheMath() {
		try {
			double amount = Double.parseDouble(this.amount);
			double years = Double.parseDouble(this.years);
			double percent  = Double.parseDouble(this.percent);
			result = Math.round((amount*(percent/100)+amount)/(years*12)*100.0)/100.0;
			
			
			
			
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "B³¹d podczas przetwarzania parametrów", null));
			return false;
		}
	}

	// Go to "showresult" if ok
	public String calc() {
		
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}

	// Put result in messages on AJAX call
	
	public String info() {
		return "info";
	}
}

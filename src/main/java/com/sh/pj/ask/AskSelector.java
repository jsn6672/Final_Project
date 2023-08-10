package com.sh.pj.ask;

import java.math.BigDecimal;

public class AskSelector {

	private String a_search;
	private BigDecimal a_start;
	private BigDecimal a_end;
	
	public AskSelector() {
		// TODO Auto-generated constructor stub
	}

	

	public AskSelector(String a_search, BigDecimal a_start, BigDecimal a_end) {
		super();
		this.a_search = a_search;
		this.a_start = a_start;
		this.a_end = a_end;
	}



	public String getA_search() {
		return a_search;
	}

	public void setA_search(String a_search) {
		this.a_search = a_search;
	}

	public BigDecimal getA_start() {
		return a_start;
	}

	public void setA_start(BigDecimal a_start) {
		this.a_start = a_start;
	}

	public BigDecimal getA_end() {
		return a_end;
	}

	public void setA_end(BigDecimal a_end) {
		this.a_end = a_end;
	}

	@Override
	public String toString() {
		return "AskSelector [a_search=" + a_search + ", a_start=" + a_start + ", a_end=" + a_end + "]";
	}

	
	
	
	
}

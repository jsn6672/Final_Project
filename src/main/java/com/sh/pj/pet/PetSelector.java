package com.sh.pj.pet;

import java.math.BigDecimal;

public class PetSelector {

	private String ps_search;
	private BigDecimal ps_start;
	private BigDecimal ps_end;
	
	public PetSelector() {
		// TODO Auto-generated constructor stub
	}

	public PetSelector(String ps_search, BigDecimal ps_start, BigDecimal ps_end) {
		super();
		this.ps_search = ps_search;
		this.ps_start = ps_start;
		this.ps_end = ps_end;
	}

	public String getPs_search() {
		return ps_search;
	}

	public void setPs_search(String ps_search) {
		this.ps_search = ps_search;
	}

	public BigDecimal getPs_start() {
		return ps_start;
	}

	public void setPs_start(BigDecimal ps_start) {
		this.ps_start = ps_start;
	}

	public BigDecimal getPs_end() {
		return ps_end;
	}

	public void setPs_end(BigDecimal ps_end) {
		this.ps_end = ps_end;
	}

	@Override
	public String toString() {
		return "PetSelector [ps_search=" + ps_search + ", ps_start=" + ps_start + ", ps_end=" + ps_end + "]";
	}
	
	
	
	
	
	
	
}

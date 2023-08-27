package com.sh.pj.care;

import java.math.BigDecimal;

public class CareSelector {

	private String cs_search;
	private BigDecimal cs_start;
	private BigDecimal cs_end;
	
	public CareSelector() {
		// TODO Auto-generated constructor stub
	}






	public String getCs_search() {
		return cs_search;
	}

	public void setCs_search(String cs_search) {
		this.cs_search = cs_search;
	}

	public BigDecimal getCs_start() {
		return cs_start;
	}

	public void setCs_start(BigDecimal cs_start) {
		this.cs_start = cs_start;
	}

	public BigDecimal getCs_end() {
		return cs_end;
	}

	public void setCs_end(BigDecimal cs_end) {
		this.cs_end = cs_end;
	}


	public CareSelector(String cs_search, BigDecimal cs_start, BigDecimal cs_end) {
		super();
		this.cs_search = cs_search;
		this.cs_start = cs_start;
		this.cs_end = cs_end;
	}


	@Override
	public String toString() {
		return "CareSelector [cs_search=" + cs_search + ", cs_start=" + cs_start + ", cs_end=" + cs_end + "]";
	}

	
	
	
}

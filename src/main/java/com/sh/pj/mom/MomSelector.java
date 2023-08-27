package com.sh.pj.mom;

import java.math.BigDecimal;

public class MomSelector {

	private String ms_search;
	private BigDecimal ms_start;
	private BigDecimal ms_end;
	
	public MomSelector() {
		// TODO Auto-generated constructor stub
	}



	public String getMs_search() {
		return ms_search;
	}

	public void setMs_search(String ms_search) {
		this.ms_search = ms_search;
	}

	public BigDecimal getMs_start() {
		return ms_start;
	}

	public void setMs_start(BigDecimal ms_start) {
		this.ms_start = ms_start;
	}

	public BigDecimal getMs_end() {
		return ms_end;
	}

	public void setMs_end(BigDecimal ms_end) {
		this.ms_end = ms_end;
	}

	@Override
	public String toString() {
		return "MomSelector [ms_search=" + ms_search + ", ms_start=" + ms_start + ", ms_end=" + ms_end + "]";
	}


	public MomSelector(String ms_search, BigDecimal ms_start, BigDecimal ms_end) {
		super();
		this.ms_search = ms_search;
		this.ms_start = ms_start;
		this.ms_end = ms_end;
	}
	

	


}

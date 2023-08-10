package com.sh.pj.ask;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class SiteOption {
	
	private int CountPerPage;	//한페이지당 sns개수(변경할수있으니까)

	public int getSnsCountPerPage() {
		return CountPerPage;
	}

	public void setSnsCountPerPage(int snsCountPerPage) {
		this.CountPerPage = snsCountPerPage;
	}

	public static void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
		
	}
}

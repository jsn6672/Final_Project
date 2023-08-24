package com.sh.pj.account;

public class countDTO {
	private int count_sitter;
	private int count_dolbom;
	private int count_time;
	private int count_cont;

	@Override
	public String toString() {
		return "countDTO [count_sitter=" + count_sitter + ", count_dolbom=" + count_dolbom + ", count_time="
				+ count_time + ", count_cont=" + count_cont + "]";
	}

	public int getCount_sitter() {
		return count_sitter;
	}

	public void setCount_sitter(int count_sitter) {
		this.count_sitter = count_sitter;
	}

	public int getCount_dolbom() {
		return count_dolbom;
	}

	public void setCount_dolbom(int count_dolbom) {
		this.count_dolbom = count_dolbom;
	}

	public int getCount_time() {
		return count_time;
	}

	public void setCount_time(int count_time) {
		this.count_time = count_time;
	}

	public int getCount_cont() {
		return count_cont;
	}

	public void setCount_cont(int count_cont) {
		this.count_cont = count_cont;
	}

}

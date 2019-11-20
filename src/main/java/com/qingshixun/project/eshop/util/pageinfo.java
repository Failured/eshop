package com.qingshixun.project.eshop.util;

import java.util.List;

public class pageinfo<T>{
	
	private int totalpages;
	
	private int pageno;
	
	private List<T> data;

	public int getTotalpages() {
		return totalpages;
	}

	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}

	public int getPageno() {
		return pageno;
	}

	public void setPageno(int pageno) {
		this.pageno = pageno;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	
	

}

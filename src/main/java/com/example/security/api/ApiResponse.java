package com.example.security.api;

import java.util.List;


public class ApiResponse {
	private int status;
	private Object data;
	private List<Errormessage> errorVM;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public List<Errormessage> getErrorVM() {
		return errorVM;
	}
	public void setErrorVM(List<Errormessage> errorVM) {
		this.errorVM = errorVM;
	}
	@Override
	public String toString() {
		return "ApiResponse [status=" + status + ", data=" + data + ", errorVM=" + errorVM + "]";
	}
	
}

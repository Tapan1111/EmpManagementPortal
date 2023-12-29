package com.work.utils;

public class ServiceResponse {
	
	private Object serviceResponse;
	private String serviceStatus;
	private Object serviceError;
	private String serviceCode;
	
	public Object getServiceResponse() {
		return serviceResponse;
	}
	public void setServiceResponse(Object serviceResponse) {
		this.serviceResponse = serviceResponse;
	}
	public String getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	public Object getServiceError() {
		return serviceError;
	}
	public void setServiceError(Object serviceError) {
		this.serviceError = serviceError;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	@Override
	public String toString() {
		return "ServiceResponse [serviceResponse=" + serviceResponse + ", serviceStatus=" + serviceStatus
				+ ", serviceError=" + serviceError + ", serviceCode=" + serviceCode + "]";
	}
	
	
	
	

}

package com.task.productsdemo;

public class Product {

	private String contractplansegcompl;
	
	public Product(String contractplansegcompl, String contract, String brandname, String planname, String state,
			String stateabbreviation, String producttype) {
		super();
		this.contractplansegcompl = contractplansegcompl;
		this.contract = contract;
		this.brandname = brandname;
		this.planname = planname;
		this.state = state;
		this.stateabbreviation = stateabbreviation;
		this.producttype = producttype;
	}
	
	private String contract;
	private String brandname;
	private String planname;
	public String getContractplansegcompl() {
		return contractplansegcompl;
	}
	public void setContractplansegcompl(String contractplansegcompl) {
		this.contractplansegcompl = contractplansegcompl;
	}
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getPlanname() {
		return planname;
	}
	public void setPlanname(String planname) {
		this.planname = planname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStateabbreviation() {
		return stateabbreviation;
	}
	public void setStateabbreviation(String stateabbreviation) {
		this.stateabbreviation = stateabbreviation;
	}
	public String getProducttype() {
		return producttype;
	}
	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}
	private String state;
	private String stateabbreviation;
	private String producttype;
	
}

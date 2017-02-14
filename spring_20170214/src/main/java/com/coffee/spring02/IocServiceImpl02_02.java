package com.coffee.spring02;

public class IocServiceImpl02_02 {
	
	// 01과는 다르다 01과는 
	private IDependencyBean dependencyBean;

	public IDependencyBean getDepencyBean() {
		return dependencyBean;
	}

	public void setDepencyBean(IDependencyBean depencyBean) {
		this.dependencyBean = depencyBean;
	}

}

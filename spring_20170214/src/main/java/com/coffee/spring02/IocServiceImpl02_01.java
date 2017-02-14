package com.coffee.spring02;

public class IocServiceImpl02_01 {
	// 01과는 다르다 01과는 
	private IDependencyBean dependency;

	public IDependencyBean getDepencyBean() {
		return dependency;
	}

	public void setDepencyBean(IDependencyBean depencyBean) {
		this.dependency = depencyBean;
	}

}

package com.coffee.spring01;

public class iocServiceImple {

	//객체도 생성하면서 값도 넣고 속성도 음
	
	private DependencyBean01 dependencyBean; // bean property에 들어갈 이름

	public DependencyBean01 getDependencyBean() {
		return dependencyBean;
	}

	public void setDependencyBean(DependencyBean01 dependencyBean) {
		this.dependencyBean = dependencyBean;
	}

	@Override
	public String toString() {
		return "iocServiceImple [dependencyBean=" + dependencyBean + "]";
	}

	public void helloIoc() {
		System.out.println("hi");
	}

}

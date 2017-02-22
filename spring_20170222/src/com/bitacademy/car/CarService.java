package com.bitacademy.car;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Controller
public class CarService
{
	@RequestMapping(value = "/car.do", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String getCar()
	{
		ArrayList<Car> carList = new ArrayList<Car>();

		carList.add(new Car("thskxk", "guseo"));
		carList.add(new Car("k5", "rldk"));
		carList.add(new Car("tmvkzm", "tnpqhfp"));

		XStream xstream = new XStream(new DomDriver("UTF-8"));
		xstream.alias("car", Car.class);
		String result = xstream.toXML(carList);

		return result;

	}
	@RequestMapping(value = "/carlist.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object getCarList()
	{
		ArrayList<Car> carList = new ArrayList<Car>();
		
		carList.add(new Car("thskxk","guseo"));
		carList.add(new Car("k5","rldk"));
		carList.add(new Car("tmvkzm","tnpqhfp"));
		
//		{
//		{{"name":"thskxk"},{"brand":"guseo"}},
//		{{"name":"k5"},{"brand":"rldk"}}
//		}
		
		return carList;
	
	}
}

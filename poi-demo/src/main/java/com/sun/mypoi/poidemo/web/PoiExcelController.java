package com.sun.mypoi.poidemo.web;

import com.sun.mypoi.poidemo.service.PoiExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 *@author sunq
 *@date2019/7/30 10:13
 *@Description
 */
@Controller
@RequestMapping("/excel")
public class PoiExcelController {

	@Autowired
	private PoiExcelService poiExcelService;

	@RequestMapping(value = "/export", produces = {"application/vnd.ms-excel;charset=UTF-8"})
	@ResponseBody
	public String export(HttpServletResponse response){
		return poiExcelService.export(response);
	}

	@RequestMapping(value = "/hi")
	@ResponseBody
	public String sayHello(){
		return "hello !";
	}



}

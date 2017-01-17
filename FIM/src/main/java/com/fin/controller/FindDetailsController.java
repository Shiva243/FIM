package com.fin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fin.logging.Log;
import com.fin.model.FinanceDetails;
import com.fin.service.FinDetailService;
import com.fin.util.ResponseUtil;

@Controller
public class FindDetailsController {
	
	@Autowired
	FinDetailService finDetailService;
	
	@RequestMapping("/findetailhome")
	public String finDetailHome(){
		return "html/findetailhome";
	}
	@RequestMapping(value="/addfindetail", method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String addFinDetail(@RequestBody FinanceDetails finDetails){
		Log.info(this.getClass(), "Inside addFinDetail ["+finDetails.getChitAmount()+"]");
		finDetails.set_id(ResponseUtil.getCurrentDateTime());
		finDetails.setModifyDate(finDetails.getCreatedDate());
		if(finDetailService.save(finDetails)!=null){
			return ResponseUtil.getJsonObject("Success","000","FinanceDetails Added Successfully").toString();
		}
		return ResponseUtil.getJsonObject("Failed","001","Something wrong, please entered once again").toString();
	}
	@RequestMapping(value="/chitamountexsist", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public FinanceDetails isChitAmountExsist(@RequestParam("chitAmount") String chitAmount){
		Log.info(this.getClass(), "Inside isChitAmountValid chitAmount is ["+chitAmount+"]");
		return finDetailService.findByChitAmount(chitAmount);
	}
	@RequestMapping(value="/getfindetails", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<FinanceDetails> getFinDetails(){
		Log.info(this.getClass(), "Inside getFinDetails ");
		return finDetailService.findAll();
	}

}

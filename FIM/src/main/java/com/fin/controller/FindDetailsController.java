package com.fin.controller;

import java.util.ArrayList;
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
		Log.info(this.getClass(), "Inside addFinDetail ["+finDetails.getChitName()+"]");
		finDetails.set_id(ResponseUtil.getCurrentDateTime());
		finDetails.setModifyDate(finDetails.getCreatedDate());
		if(finDetailService.save(finDetails)!=null){
			return ResponseUtil.getJsonObject("Success","000","FinanceDetails Added Successfully").toString();
		}
		return ResponseUtil.getJsonObject("Failed","001","Something wrong, please entered once again").toString();
	}
	@RequestMapping(value="/chitnameexsist", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public FinanceDetails isChitNameExsist(@RequestParam("chitName") String chitName){
		Log.info(this.getClass(), "Inside isChitAmountValid chitAmount is ["+chitName+"]");
		return finDetailService.findByChitName(chitName);
	}
	@RequestMapping(value="/getfindetails", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<FinanceDetails> getFinDetails(@RequestParam(value="chitName",defaultValue = "chitName", required = false) String chitName){
		Log.info(this.getClass(), "Inside getFinDetails chitAmount ["+chitName+"]");
		if(chitName.equals("chitName")){
			return finDetailService.findAll();
		}else{
			List<FinanceDetails> list=new ArrayList<>();
			list.add(finDetailService.findByChitName(chitName));
			return list;
		}
		
	}

}

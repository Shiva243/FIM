package com.fin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fin.logging.Log;
import com.fin.model.UserDetails;
import com.fin.service.UserService;
import com.fin.util.ResponseUtil;

@Controller
public class UserRegisterController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String main() {
		Log.info(this.getClass(), "Inside main");
		return "html/main";
	}
	
	@RequestMapping("/userhome")
	public String userHome() {
		Log.info(this.getClass(), "Inside userHome");
		return "html/userhome";
	}
	@RequestMapping(value="/usernameexsist", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String isUserNameExsist(@RequestParam(value ="userName") String userName) {
		Log.info(this.getClass(), "Inside isUserNameExsist userName is[" + userName + "");
		if( userService.findByUserName(userName) == null){
			return ResponseUtil.getJsonObject("true","000","UserName doesn't exisist").toString();
		}
		return ResponseUtil.getJsonObject("false","001","UserName already exisist").toString();
	}
	@RequestMapping(value="/useridexsist", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String isUserIdNoExsist(@RequestParam(value ="idNo") String idNo) {
		Log.info(this.getClass(), "Inside isUserIdNoExsist idNo is[" + idNo + "");
		if( userService.findByIdNo(idNo) == null){
			return ResponseUtil.getJsonObject("true","000","UserId doesn't exisist").toString();
		}
		return ResponseUtil.getJsonObject("false","001","UserId already exisist").toString();
	}
	@RequestMapping(value="/mobilenoexsist", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String isMobileNoExsist(@RequestParam(value ="mobileNo") String mobileNo) {
		Log.info(this.getClass(), "Inside isMobileNoExsist mobileNo is[" + mobileNo + "");
		if( userService.findByMobileNo(mobileNo) == null){
			return ResponseUtil.getJsonObject("true","000","MobileNo doesn't exisist").toString();
		}
		return ResponseUtil.getJsonObject("false","001","MobileNo already exisist").toString();
	}

@RequestMapping(value="/adduser", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public String addUser(@RequestBody UserDetails user) {
	user.set_id(ResponseUtil.getCurrentDateTime());
	Log.info(this.getClass(), "Inside addUser user id value is ["+user.get_id()+"]");
	if(userService.save(user)!= null){
		return ResponseUtil.getJsonObject("Success","000","User Registered Successfully").toString();
	}
	return ResponseUtil.getJsonObject("Failed","001","Something wrong, please registered once again").toString();
}
	
}

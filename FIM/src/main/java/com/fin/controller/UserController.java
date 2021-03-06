package com.fin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class UserController {

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
		return "html/user/userhome";
	}

	@RequestMapping("/adduser")
	public String addUser() {
		Log.info(this.getClass(), "Inside userHome");
		return "html/user/adduser";
	}

	@RequestMapping("/userlist")
	public String getUserList() {
		Log.info(this.getClass(), "Inside getUserList");
		return "html/user/userlist";
	}

	@RequestMapping(value = "/usernameexsist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String isUserNameExsist(@RequestParam(value = "userName") String userName) {
		Log.info(this.getClass(), "Inside isUserNameExsist userName is[" + userName + "");
		if (userService.findByUserName(userName) == null) {
			return ResponseUtil
					.getJsonObject(ResponseUtil.SUCCESS_MSG, ResponseUtil.SUCCESS_CODE, "UserName doesn't exisist")
					.toString();
		}
		return ResponseUtil.getJsonObject(ResponseUtil.FAIL_MSG, ResponseUtil.FAIL_CODE, "UserName already exisist")
				.toString();
	}

	@RequestMapping(value = "/useridexsist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String isUserIdNoExsist(@RequestParam(value = "idNo") String idNo) {
		Log.info(this.getClass(), "Inside isUserIdNoExsist idNo is[" + idNo + "");
		if (userService.findByIdNo(idNo) == null) {
			return ResponseUtil
					.getJsonObject(ResponseUtil.SUCCESS_MSG, ResponseUtil.SUCCESS_CODE, "UserId doesn't exisist")
					.toString();
		}
		return ResponseUtil.getJsonObject(ResponseUtil.FAIL_MSG, ResponseUtil.FAIL_CODE, "UserId already exisist")
				.toString();
	}

	@RequestMapping(value = "/mobilenoexsist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String isMobileNoExsist(@RequestParam(value = "mobileNo") String mobileNo) {
		Log.info(this.getClass(), "Inside isMobileNoExsist mobileNo is[" + mobileNo + "");
		if (userService.findByMobileNo(mobileNo) == null) {
			return ResponseUtil
					.getJsonObject(ResponseUtil.SUCCESS_MSG, ResponseUtil.SUCCESS_CODE, "MobileNo doesn't exisist")
					.toString();
		}
		return ResponseUtil.getJsonObject(ResponseUtil.FAIL_MSG, ResponseUtil.FAIL_CODE, "MobileNo already exisist")
				.toString();
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	
	public String addUser(@RequestBody UserDetails user) {
		Log.info(this.getClass(), "Inside addUser user id value is [" + user.get_id() + "] ");
		if(user.get_id()==null){
			user.set_id(ResponseUtil.getCurrentDateTime());
			user.setCreatedDate(ResponseUtil.getDateString("yyyy-MM-dd"));
		}
		user.setModifyDate(ResponseUtil.getDateString("yyyy-MM-dd"));
		if (userService.save(user) != null) {
			return ResponseUtil
					.getJsonObject(ResponseUtil.SUCCESS_MSG, ResponseUtil.SUCCESS_CODE, "User Registered Successfully")
					.toString();
		}
		return ResponseUtil.getJsonObject(ResponseUtil.FAIL_MSG, ResponseUtil.FAIL_CODE,
				"Something wrong, please registered once again").toString();
	}

	@RequestMapping(value = "/getuserlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<UserDetails> getUserList(
			@RequestParam(value = "userName", defaultValue = "userName", required = false) String userName) {
		Log.info(this.getClass(), "Inside getUserList userName is [" + userName + "]");
		if ("userName".equals(userName)) {
			return userService.findAll();
		} else {
			List<UserDetails> userList = new ArrayList<>();
			userList.add(userService.findByUserName(userName));
			return userList;
		}
	}

	@RequestMapping(value = "/deleteuser", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deleteUser(@RequestParam(value = "userId") Long userId) {
		Log.info(this.getClass(), "Inside deleteUser userId is [" + userId + "]");
		userService.deleteUserById(userId);
		return ResponseUtil
				.getJsonObject(ResponseUtil.SUCCESS_MSG, ResponseUtil.SUCCESS_CODE, "User Deleted Successfully")
				.toString();
	}
}

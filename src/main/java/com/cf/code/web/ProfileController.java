/**
 * 
 */
package com.cf.code.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.jfinal.core.Controller;

/**
 * @Version: 1.0
 * @Author: 丛峰
 * @Email: 3024992@qq.com
 */
public class ProfileController extends Controller{
	
	public void login(){
		String username = this.getPara("username");
		String password = this.getPara("password");
		Map<String,Object> ret = new HashMap<String,Object>();
		if(StringUtils.isEmpty(username)){
			ret.put("s", 0);
			ret.put("m", "用户名 不能为空");
			this.renderJson(ret);
			return ;
		}
		if(StringUtils.isEmpty(password)){
			ret.put("s", 0);
			ret.put("m", "密码不能为空");
			this.renderJson(ret);
			return ;
		}
		String rPassword = UserController.Users.get(username);
		if(StringUtils.isEmpty(rPassword)){
			ret.put("s", 0);
			ret.put("m", "用户不存在");
			this.renderJson(ret);
			return ;
		}
		if(!rPassword.equals(password)){
			ret.put("s", 0);
			ret.put("m", "密码错误");
			this.renderJson(ret);
			return ;
		}
		super.setSessionAttr("username", username);
		this.renderJson("s", 1);
	}
	
	public void info(){
		Map<String,Object> ret = new HashMap<String,Object>();
		ret.put("userNick", "大风哥");
		ret.put("userNum", super.getSessionAttr("username"));
		ret.put("userPortrait", "image/portrait.jpg");
		this.renderJson(ret);
	}
	
}

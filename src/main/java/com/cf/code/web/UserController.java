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
public class UserController extends Controller{

	public static final Map<String,String> Users = new HashMap<String,String>(){{
		this.put("admin", "admin");
	}};	
	
	public void info(){
		Map<String,Object> ret = new HashMap<String,Object>();
		ret.put("userNick", "大风哥");
		ret.put("userNum", super.getSessionAttr("username"));
		ret.put("userPortrait", "image/portrait.jpg");
		this.renderJson(ret);
	}
	
	public void resetPassword(){
		Map<String,Object> ret = new HashMap<String,Object>();
		String newPassword = this.getPara("newPassword");
		if(StringUtils.isEmpty(newPassword)){
			ret.put("s", 0);
			ret.put("m", "新密码不能为空");
			this.renderJson(ret);
			return ;
		}
		String username = super.getSessionAttr("username");
		Users.put(username, newPassword);
		ret.put("s", 1);
		ret.put("m", "修改密码成功");
		this.renderJson(ret);
	}
	
	public void register(){
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
		if(Users.containsKey(username)){
			ret.put("s", 0);
			ret.put("m", "用户已经存在，不能重复注册");
			this.renderJson(ret);
			return ;
		}
		Users.put(username, password);
		ret.put("s", 1);
		ret.put("m", "注册成功");
		this.renderJson(ret);
	}
	
}

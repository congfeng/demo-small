/**
 * 
 */
package com.cf.code.web;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;

/**
 * @Version: 1.0
 * @Author: 丛峰
 * @Email: 3024992@qq.com
 */
public class TalkController extends Controller{

	public void init(){
		Map<String,Object> ret = new HashMap<String,Object>();
		ret.put("waitCount", 18);
		this.renderJson(ret);
	}
	
}

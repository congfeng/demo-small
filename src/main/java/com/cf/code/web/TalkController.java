/**
 * 
 */
package com.cf.code.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	public void list(){
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,String>> talks = new ArrayList<Map<String,String>>();
		for(int i=0;i<15;i++){
			Map<String,String> talk = new HashMap<String,String>();
			if(i == 1){
				talk.put("portrait", "image/portrait.jpg");
			}else if(i == 2){
				talk.put("portrait", "images/img_01.gif");
			}else if(i == 3){
				talk.put("portrait", "images/img_03.gif");
			}else{
				talk.put("portrait", "images/img_08.jpg");
			}
			talk.put("fname", "小名"+i);
			talk.put("ftalk", "早上好----"+i);
			if(i < 10){
				talk.put("ftime", "15:0"+i);
			}else{
				talk.put("ftime", "15:"+i);
			}
			talks.add(talk);
		}
		ret.put("talks", talks);
		this.renderJson(ret);
	}
	
}

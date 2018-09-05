package com.lanmei.cms.controller.commodity;

import com.lanmei.cms.controller.commodity.CommodityController;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)  //此处调用Spring单元测试类  
@WebAppConfiguration    //调用javaWEB的组件，比如自动注入ServletContext Bean等等  
@ContextConfiguration(locations = {"classpath*:springmvc/spring-mvc.xml",//加载Spring配置文件  
		                           "classpath*:spring/spring-context.xml"})//加载Spring-mvc配置文件 
public class CommodityControllerTest {

	@Autowired
	CommodityController commodityController;
	 
	
	
	@Autowired  
	ServletContext context;  
	  
	MockMvc mockMvc;  
	@Before  
	public void setup(){  
	    mockMvc = MockMvcBuilders.standaloneSetup(commodityController).build();  
	}  
	/**
	 * 获取节点数据　测试
	 * @throws Exception
	 */
	//@Test
	public void testGetTreeNode() throws Exception{
		System.out.println("testGetTreeNode 开始进行测试");  
		  
        //发送请求           	
        MvcResult mvcResult = mockMvc.perform( get("/commodity/get/node")
        		.param("id", "0")
        		.contentType(MediaType.APPLICATION_JSON_UTF8))
        		.andDo(print())
                .andExpect(status().isOk())
                .andReturn();
	}
	/**
	 * 增加节点　测试
	 * @throws Exception
	 */
	//@Test
	public void testAddTreeNode() throws Exception{
		System.out.println("testGetTreeNode 开始进行测试");  
		 Map<String,Object> map = new HashMap<String,Object>();  
		 int id = 1;
	     map.put("id", id);
	     map.put("name", "新类目"+id);
	    JSONObject jsonObject = JSONObject.fromObject(map);
        //发送请求           	
        MvcResult mvcResult = mockMvc.perform( get("/commodity/add/node")
        		.contentType(MediaType.APPLICATION_JSON_UTF8)
        		.content(jsonObject.toString()))
        		.andDo(print())
                .andExpect(status().isOk())
                .andReturn();
	}
	
	/**
	 * 更改节点　测试
	 * @throws Exception
	 */
	//@Test
	public void testModityTreeNode() throws Exception{
		System.out.println("testModityTreeNode 开始进行测试"); 
		
		 Map<String,Object> map = new HashMap<String,Object>();  
		 int id = 25;
	     map.put("id", id);
	     map.put("name", "修改" + Math.round((Math.random()*100)));
	    JSONObject jsonObject = JSONObject.fromObject(map);
        //发送请求           	
        MvcResult mvcResult = mockMvc.perform( get("/commodity/modify/node")
        		.contentType(MediaType.APPLICATION_JSON_UTF8)
        		.content(jsonObject.toString()))
        		.andDo(print())
                .andExpect(status().isOk())
                .andReturn();
	}
	
	/**
	 * 删除节点　测试
	 * @throws Exception
	 */
	///@Test
	public void testDeleteTreeNode() throws Exception{
		System.out.println("testＤeleteTreeNode 开始进行测试");  
		  
		Map<String,Object> map = new HashMap<String,Object>();  
	    int id = 23;
	    map.put("id", id);
	   JSONObject jsonObject = JSONObject.fromObject(map);
       //发送请求           	
       MvcResult mvcResult = mockMvc.perform( get("/commodity/delete/node")
       		.contentType(MediaType.APPLICATION_JSON_UTF8)
       		.content(jsonObject.toString()))
       		.andDo(print())
               .andExpect(status().isOk())
               .andReturn();
	}
	
	/**
	 * 删除节点　测试
	 * @throws Exception
	 */
	//@Test
	public void testNewCommodity() throws Exception{
		System.out.println("testNewCommodity 开始进行测试");  
		
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("name", "小米6");
		map.put("brand", "小米");
		map.put("title", "小米经典款");
		map.put("referencePrice", 2499);
		map.put("activityPrice", 2199);
		map.put("description", "最好的小米手机");
	    map.put("id", 39);
	    JSONObject jsonObject = JSONObject.fromObject(map);
       //发送请求           	
       MvcResult mvcResult = mockMvc.perform( get("/commodity/new/commodity")
       		.contentType(MediaType.APPLICATION_JSON_UTF8)
       		.content(jsonObject.toString()))
       		.andDo(print())
               .andExpect(status().isOk())
               .andReturn();
	}
	/**
	 * 获取商品列表
	 * @throws Exception
	 */
	//@Test
	public void tesGetCommodityList() throws Exception{
		System.out.println("tesGetCommodityList 开始进行测试");  
		
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("id",0);
	
	    JSONObject jsonObject = JSONObject.fromObject(map);
       //发送请求           	                        commodity/get/commodity/list?id=1 400 () 
       MvcResult mvcResult = mockMvc.perform( get("/commodity/get/commodity/list")
       		.contentType(MediaType.APPLICATION_JSON_UTF8)
       		.content(jsonObject.toString()))
       		.andDo(print())
               .andExpect(status().isOk())
               .andReturn();
	}
	
	
	//@Test
	public void testUploadEditorImg() throws Exception{
		System.out.println("testUploadEditorImg 开始进行测试");  
		List<MultipartFile> list = new ArrayList<MultipartFile> ();
		File myfile = new  File("/img");
		FileItem fileItem = new DiskFileItem("img", 
				null, false, "222.jpg", -1, myfile);
 		MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
		
 		List<MultipartFile> multipartFileList = new ArrayList<MultipartFile>();
 		multipartFileList.add(multipartFile);
       //发送请求           	
       MvcResult mvcResult = mockMvc.perform( post("/commodity/upload/editor/img")
       		.contentType(MediaType.IMAGE_JPEG).param("img", multipartFileList.toString()))
       		.andDo(print())
               .andExpect(status().isOk())
               .andReturn();
	}
	
	/**
	 * 设置商品销售属性
	 * @throws Exception
	 */
	//@Test
	public void testSetSkuAttr() throws Exception{
		System.out.println("tesGetCommodityList 开始进行测试");  
		
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("commodityId",2);
		map.put("name","颜色");
		map.put("attr","玫瑰金");
		
	    JSONObject jsonObject = JSONObject.fromObject(map);
       //发送请求           	                        commodity/get/commodity/list?id=1 400 () 
       MvcResult mvcResult = mockMvc.perform( post("/commodity/set/sku/attr")
       		.contentType(MediaType.APPLICATION_JSON_UTF8)
       		.content(jsonObject.toString()))
       		.andDo(print())
               .andExpect(status().isOk())
               .andReturn();
	}
	/**
	 * 获取商品销售属性
	 * @throws Exception
	 */
	//@Test
	public void testGetSkuAttr() throws Exception{
		System.out.println("testGetSkuAttr 开始进行测试");  
		
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("commodityId",2);
		
	    JSONObject jsonObject = JSONObject.fromObject(map);
       //发送请求           	                        commodity/get/commodity/list?id=1 400 () 
       MvcResult mvcResult = mockMvc.perform( get("/commodity/get/sku/attr")
       		.param("commodityId", "2"))
       		.andDo(print())
               .andExpect(status().isOk())
               .andReturn();
	}
	/**
	 * 删除商品销售属性
	 * @throws Exception
	 */
	//@Test
	public void testDeleteSkuAttr() throws Exception{
			System.out.println("tesGetCommodityList 开始进行测试");  
			
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("skuId",2);
			
		    JSONObject jsonObject = JSONObject.fromObject(map);
	       //发送请求           	                        commodity/get/commodity/list?id=1 400 () 
	       MvcResult mvcResult = mockMvc.perform( post("/commodity/delete/sku/attr")
	       		.contentType(MediaType.APPLICATION_JSON_UTF8)
	       		.content(jsonObject.toString()))
	       		.andDo(print())
	               .andExpect(status().isOk())
	               .andReturn();
	}
	
	/**
	 *新建商品属性
	 * @throws Exception
	 */
	//@Test
	public void testNewAttribution() throws Exception{
		System.out.println("testNewAttribution 开始进行测试");  
		
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("commodityId",2);
		map.put("attrName","品牌");
		map.put("attrVal","小米");
		map.put("category","主体");
		
	    JSONObject jsonObject = JSONObject.fromObject(map);
       //发送请求           	                        commodity/get/commodity/list?id=1 400 () 
       MvcResult mvcResult = mockMvc.perform( post("/commodity/new/attribution")
       		.contentType(MediaType.APPLICATION_JSON_UTF8)
       		.content(jsonObject.toString()))
       		.andDo(print())
               .andExpect(status().isOk())
               .andReturn();
	}
	/**
	 *编辑商品属性
	 * @throws Exception
	 */
	//@Test
	public void tesEditAttribution() throws Exception{
		System.out.println("tesEditAttribution 开始进行测试");  
		
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("attrId",2);
		map.put("commodityId",2);
		map.put("attrName","品牌");
		map.put("attrVal","小米(MI)");
		map.put("category","主体");
		
	    JSONObject jsonObject = JSONObject.fromObject(map);
       //发送请求           	                        commodity/get/commodity/list?id=1 400 () 
       MvcResult mvcResult = mockMvc.perform( post("/commodity/edit/attribution")
       		.contentType(MediaType.APPLICATION_JSON_UTF8)
       		.content(jsonObject.toString()))
       		.andDo(print())
               .andExpect(status().isOk())
               .andReturn();
	}
	/**
	 *删除商品属性
	 * @throws Exception
	 */
	//@Test
	public void testDeleteAttribution() throws Exception{
		System.out.println("testDeleteAttribution 开始进行测试");  
		
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("attrId",1);		
	    JSONObject jsonObject = JSONObject.fromObject(map);
       //发送请求           	                        commodity/get/commodity/list?id=1 400 () 
       MvcResult mvcResult = mockMvc.perform( delete("/commodity/delete/attribution")
       		.contentType(MediaType.APPLICATION_JSON_UTF8)
       		.content(jsonObject.toString()))
       		.andDo(print())
               .andExpect(status().isOk())
               .andReturn();
	}
	/**
	 *获取商品属性
	 * @throws Exception
	 */
	@Test
	public void testGetAttribution() throws Exception{
		System.out.println("testNewAttribution 开始进行测试");  
		
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("commodityId",2);
		map.put("attrName","品牌");
		map.put("attrVal","小米");
		map.put("category","主体");
		
	    JSONObject jsonObject = JSONObject.fromObject(map);
       //发送请求           	                        commodity/get/commodity/list?id=1 400 () 
       MvcResult mvcResult = mockMvc.perform( get("/commodity/get/attribution")
       		.param("commodityId","2"))
       		.andDo(print())
               .andExpect(status().isOk())
               .andReturn();
	}
	
	/**
	 * 设置商品描述
	 * @throws Exception
	 */
	//@Test
	public void testSetDescription() throws Exception{
		System.out.println("testSetDescription 开始进行测试");  
		
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("commodityId",2);
		map.put("descriptionInfo","颜色");
		
	    JSONObject jsonObject = JSONObject.fromObject(map);
       //发送请求           	                        commodity/get/commodity/list?id=1 400 () 
       MvcResult mvcResult = mockMvc.perform( post("/commodity/set/description")
       		.contentType(MediaType.APPLICATION_JSON_UTF8)
       		.content(jsonObject.toString()))
       		.andDo(print())
               .andExpect(status().isOk())
               .andReturn();
	}
	/**
	 * 获取商品描述
	 * @throws Exception
	 */
	//@Test
	public void testgetDescription() throws Exception{
		System.out.println("testgetDescription 开始进行测试");  
		
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("commodityId",2);
		
	    JSONObject jsonObject = JSONObject.fromObject(map);
       //发送请求           	                        commodity/get/commodity/list?id=1 400 () 
       MvcResult mvcResult = mockMvc.perform( get("/commodity/get/description")
       		.param("commodityId", "2"))
       		.andDo(print())
               .andExpect(status().isOk())
               .andReturn();
	}
}

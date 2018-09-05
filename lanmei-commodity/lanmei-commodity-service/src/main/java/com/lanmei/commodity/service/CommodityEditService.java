package com.lanmei.commodity.service;

import com.lanmei.commodity.dao.model.Commodity;
import com.lanmei.commodity.dao.model.CommoditySku;
import com.lanmei.commodity.dto.EditDto;
import com.lanmei.commodity.dto.ImgResultDto;
import com.lanmei.common.enums.CommodityState;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface CommodityEditService {

	/**
	 * 增加商品
	 * @param map
	 */
	CommodityState addCommodity(Map<String,Object> map);
	/**
	 * 上传商品图片
	 * @param files
	 */
	CommodityState upLoadImg(CommonsMultipartFile[] files,
			String UploadAbsolutePath,
			String UploadRelativePath,
			int commodityId);
	/**
	 * 上传商品图片
	 * @param files
	 */
	ImgResultDto upLoadEditorImg(List<MultipartFile> list,
								 String UploadRelativePath,
								 File file);
	/**
	 * 检查是否存在同名商品　
	 * @param map
	 * @return
	 */
	CommodityState checkName(Map<String,Object> map);
	
	/**
	 * 通过分类id 获取商品列表
	 * @return
	 */
	List<Commodity>  getComodityList(Integer id);
	
	/**
	 * 通过商品id删除商品
	 * @return
	 */
	CommodityState  deleteComodity(Integer id);
	
	void getSkuInfo(Integer commodityId);
	
	/**
	 * 设置销售属性
	 * @param map
	 */
	CommodityState setSkuAttr(Map<String,Object> map);
	/**
	 * 获取销售属性
	 * @param map
	 */
	List<CommoditySku> getSkuAttr(Integer commodityId);
	/**
	 * 删除销售属性
	 * @param skuId
	 * @return
	 */
	CommodityState deleteSkuAttr( Integer skuId);
	
	/**
	 * 新建商品属性
	 * @param map 
	 * @return
	 */
	EditDto newAttribution(Map<String,Object> map);
	/**
	 * 编辑商品属性
	 * @param Integer　商品ＩＤ
	 * @return
	 */
	EditDto editAttribution(Map<String,Object> map);
	/**
	 * 删除商品属性
	 * @param map 
	 * @return
	 */
	EditDto deleteAttribution(Map<String,Object> map);
	/**
	 * 获取商品属性
	 * @param Integer　商品ＩＤ
	 * @return
	 */
	EditDto getAttribution(Integer commodityId);
	
	/**
	 * 设置商品描述
	 * @param map 
	 * @return
	 */
	EditDto setDescription(Map<String,Object> map);
	/**
	 * 获取商品描述
	 * @param Integer　商品ＩＤ
	 * @return
	 */
	EditDto getDescription(Integer commodityId);
	
	
}

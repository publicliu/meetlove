/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月22日 上午2:39:18
 */
package net.lw.meetlove.web.admin.goods.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.lw.meetlove.api.entity.IGoodsClassify;
import net.lw.meetlove.api.entity.IGoodsItem;
import net.lw.meetlove.api.entity.IItemResource;
import net.lw.meetlove.api.entity.ItemResourceType;
import net.lw.meetlove.api.service.IGoodsClassifyService;
import net.lw.meetlove.api.service.IGoodsItemService;
import net.lw.meetlove.api.service.ISystemArgsService;
import net.lw.meetlove.web.admin.goods.form.ClassifyForm;
import net.lw.meetlove.web.admin.goods.form.ItemForm;
import net.lw.meetlove.web.util.FishWebUtils;
import net.lw.meetlove.web.util.IceConstant;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liuwei
 *
 */
@Controller
@RequestMapping("/admin/goods/item")
public class ItemController {

	private final Logger logger = LoggerFactory.getLogger(ItemController.class);


	@Autowired
	private IGoodsItemService itemService;
	@Autowired
	private ISystemArgsService argsService;
	@Autowired
	private IGoodsClassifyService classifyService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ModelMap list(WebRequest webRequest,HttpServletRequest request){
		ModelMap model = new ModelMap();
		List<IGoodsItem> items = itemService.list();
		model.addAttribute(IceConstant.SUCCESS, true);
		model.addAttribute(IceConstant.DATA, ItemForm.toForms(items));
		return model;
	}

	@RequestMapping(value="/resource/{name}.{suffix}",method = RequestMethod.GET)
	public void getResource(@PathVariable String name,@PathVariable String suffix,HttpServletRequest request, HttpServletResponse response){
		String filename = name+"."+suffix;
	    File file = new File(FishWebUtils.resourceImgPath, filename);
	    if(!file.exists()){
	    	file = new File(FishWebUtils.resourceImgPath, "default.jpg");
	    }
	    response.setHeader("Content-Type", request.getSession().getServletContext().getMimeType(filename));
	    response.setHeader("Content-Length", String.valueOf(file.length()));
	    response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
	    try {
			IOUtils.copy(new FileInputStream(file), response.getOutputStream());
		} catch (FileNotFoundException e) {
			logger.info(e.getMessage());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ModelMap add(@RequestBody ItemForm form){
		ModelMap result = new ModelMap();

		IGoodsItem item = itemService.make();
		IGoodsClassify classify = classifyService.get(form.getClassifyId());
		item.setClassify(classify);
		item.setName(form.getName());
		item.setRemark(form.getRemark());
		item.setStatus(form.getStatus());
		item = itemService.add(item);

		IItemResource resource = itemService.makeResource();
		resource.setGoodsItem(item);
		resource.setName(form.getResourceName());
		resource.setType(ItemResourceType.IMAGE);
		itemService.addResource(item.getId(), resource);



		result.addAttribute(IceConstant.SUCCESS, true);
		return result;
	}

	@ResponseBody
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ModelMap update(@PathVariable long id ,@RequestBody ClassifyForm form){
		ModelMap result = new ModelMap();
		result.addAttribute(IceConstant.SUCCESS, true);
		result.addAttribute(IceConstant.ERROR_MSG, "修改成功");
		return result;
	}

	@ResponseBody
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ModelMap delete(@PathVariable long id){
		ModelMap result = new ModelMap();
		try {
			itemService.remove(id);
			result.addAttribute(IceConstant.SUCCESS, true);
			result.addAttribute(IceConstant.ERROR_MSG, "删除成功");
		} catch (Exception e) {
			result.addAttribute(IceConstant.SUCCESS, false);
			result.addAttribute(IceConstant.ERROR_MSG, "删除失败");
		}

		return result;
	}

	@ResponseBody
	@RequestMapping(value="/uploadResource")
	public ModelMap uploadResource(@RequestParam(value="file") MultipartFile file,
			HttpServletRequest request,HttpServletResponse response){
		ModelMap model = new ModelMap();
		response.setContentType("text/html;charset=UTF-8");
		String fileName = file.getOriginalFilename();
		String path = FishWebUtils.resourceImgPath;
		String newFileName = FishWebUtils.createFileName(fileName);
		File destFile = new File(path + File.separator+newFileName);

		try {
			file.transferTo(destFile);
		} catch (IllegalStateException e) {
			logger.info(e.getMessage());
		} catch (IOException e) {
			logger.info(e.getMessage());
			model.addAttribute(IceConstant.SUCCESS, false);
			return model;
		}
		logger.info("图片上传成功");

		model.addAttribute(IceConstant.SUCCESS, true);
		model.addAttribute(IceConstant.DATA, newFileName);
		return model;
	}
















}

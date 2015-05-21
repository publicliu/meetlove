/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月22日 上午2:39:18
 */
package net.lw.meetlove.web.admin.goods.controller;

import javax.servlet.http.HttpServletRequest;

import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;
import net.lw.ice.common.filter.Filter;
import net.lw.meetlove.api.entity.IFoodClassify;
import net.lw.meetlove.api.service.IFoodClassifyService;
import net.lw.meetlove.web.admin.goods.form.ClassifyForm;
import net.lw.meetlove.web.util.IceConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * @author liuwei
 *
 */
@Controller
@RequestMapping("/goods/classify")
public class ClassifyController {

	@Autowired
	private IFoodClassifyService classifyService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ModelMap list(@RequestParam int start,@RequestParam int limit,WebRequest webRequest,HttpServletRequest request){
		ModelMap model = new ModelMap();

		IFilter filter = new Filter();
		IPageResult<IFoodClassify> pageResult = classifyService.page(start, limit, filter);

		model.addAttribute(IceConstant.SUCCESS, true);
		model.addAttribute(IceConstant.TOTAL, pageResult.getTotal());
		model.addAttribute(IceConstant.DATA, ClassifyForm.toForms(pageResult.list()));
		return model;
	}

}
/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月22日 上午2:39:18
 */
package net.lw.meetlove.web.admin.goods.controller;

import java.text.Normalizer.Form;

import javax.servlet.http.HttpServletRequest;

import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;
import net.lw.ice.common.filter.Filter;
import net.lw.meetlove.api.entity.FoodStatus;
import net.lw.meetlove.api.entity.IFoodClassify;
import net.lw.meetlove.api.service.IFoodClassifyService;
import net.lw.meetlove.web.admin.goods.form.ClassifyForm;
import net.lw.meetlove.web.person.form.OrgForm;
import net.lw.meetlove.web.util.IceConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ModelMap add(@RequestBody ClassifyForm form){
		ModelMap result = new ModelMap();

		IFoodClassify classify = classifyService.make();
		classify.setName(form.getName());
		classify.setRemark(form.getRemark());
		classify.setStatus(form.getStatus());

		try {
			classify = classifyService.add(classify);
		} catch (Exception e) {
			result.addAttribute(IceConstant.SUCCESS, false);
			result.addAttribute(IceConstant.ERROR_MSG, "增加失败");
			return result;
		}

		result.addAttribute(IceConstant.DATA, ClassifyForm.toForm(classify));
		result.addAttribute(IceConstant.SUCCESS, true);
		return result;
	}

	@ResponseBody
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ModelMap update(@PathVariable long id ,@RequestBody ClassifyForm form){
		ModelMap result = new ModelMap();
		IFoodClassify classify = classifyService.get(id);
		classify.setName(form.getName());
		classify.setRemark(form.getRemark());
		classify.setStatus(form.getStatus());
		classify.setSort(0);

		try {
			classifyService.update(classify);
		} catch (Exception e) {
			result.addAttribute(IceConstant.SUCCESS, false);
			result.addAttribute(IceConstant.ERROR_MSG, "修改失败");
			return result;
		}
		result.addAttribute(IceConstant.SUCCESS, true);
		result.addAttribute(IceConstant.ERROR_MSG, "修改成功");
		return result;
	}
}

/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月22日 上午2:39:18
 */
package net.lw.meetlove.web.admin.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.lw.meetlove.api.entity.ISystemArgs;
import net.lw.meetlove.api.entity.SystemArgsType;
import net.lw.meetlove.api.service.ISystemArgsService;
import net.lw.meetlove.web.admin.system.form.ArgsForm;
import net.lw.meetlove.web.util.IceConstant;

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

/**
 * @author liuwei
 *
 */
@Controller
@RequestMapping("/admin/systemargs")
public class SystemArgsController {

	@Autowired
	private ISystemArgsService argsService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ModelMap list(@RequestParam int start,@RequestParam int limit,WebRequest webRequest,HttpServletRequest request){
		ModelMap model = new ModelMap();

		List<ISystemArgs> args = argsService.list();


		model.addAttribute(IceConstant.SUCCESS, true);
		model.addAttribute(IceConstant.DATA, ArgsForm.toForms(args));
		return model;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ModelMap add(@RequestBody ArgsForm form){
		ModelMap result = new ModelMap();

		ISystemArgs args = argsService.make();
		args.setName(form.getName());
		args.setValue(form.getValue());
		args.setRemark(form.getRemark());
		args.setType(SystemArgsType.CUSTOM);

		try {
			args = argsService.add(args);
		} catch (Exception e) {
			result.addAttribute(IceConstant.SUCCESS, false);
			result.addAttribute(IceConstant.ERROR_MSG, "增加失败");
			return result;
		}

		result.addAttribute(IceConstant.DATA, ArgsForm.toForm(args));
		result.addAttribute(IceConstant.SUCCESS, true);
		return result;
	}

	@ResponseBody
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ModelMap update(@PathVariable long id ,@RequestBody ArgsForm form){
		ModelMap result = new ModelMap();
		ISystemArgs args = argsService.get(id);
		args.setName(form.getName());
		args.setValue(form.getValue());
		args.setRemark(form.getRemark());
		args.setType(form.getType());

		try {
			argsService.update(args);
		} catch (Exception e) {
			result.addAttribute(IceConstant.SUCCESS, false);
			result.addAttribute(IceConstant.ERROR_MSG, "修改失败");
			return result;
		}
		result.addAttribute(IceConstant.SUCCESS, true);
		result.addAttribute(IceConstant.ERROR_MSG, "修改成功");
		return result;
	}

	@ResponseBody
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ModelMap delete(@PathVariable long id){
		ModelMap result = new ModelMap();
		try {
			argsService.remove(id);
			result.addAttribute(IceConstant.SUCCESS, true);
			result.addAttribute(IceConstant.ERROR_MSG, "删除成功");
		} catch (Exception e) {
			result.addAttribute(IceConstant.SUCCESS, false);
			result.addAttribute(IceConstant.ERROR_MSG, "删除失败");
		}

		return result;
	}
}

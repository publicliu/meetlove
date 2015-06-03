/**
 * liuwei
 * publicliu@yeah.net
 * 2015年6月2日 上午11:23:16
 */
package net.lw.meetlove.web.custom.item.controller;

import javax.servlet.http.HttpServletRequest;

import net.lw.meetlove.api.service.IGoodsItemService;
import net.lw.meetlove.web.admin.goods.form.ItemForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liuwei
 *
 */

@Controller
@RequestMapping("/index")
public class CustomIndexController {
	private final Logger logger = LoggerFactory.getLogger(CustomIndexController.class);

	@Autowired
	private IGoodsItemService itemService;

	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap map,HttpServletRequest request){
		request.getSession(true).setAttribute("itemList", ItemForm.toForms(itemService.list()));
		return "forward:/custom/itemlist.jsp";
	}


}

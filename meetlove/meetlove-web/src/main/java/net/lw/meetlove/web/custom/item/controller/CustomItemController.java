/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月25日 下午2:14:30
 */
package net.lw.meetlove.web.custom.item.controller;

import net.lw.meetlove.api.entity.IGoodsItem;
import net.lw.meetlove.api.service.IGoodsItemService;
import net.lw.meetlove.web.admin.goods.form.Item2Form;
import net.lw.meetlove.web.util.IceConstant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuwei
 *
 */

@Controller
@RequestMapping("/custom/item")
public class CustomItemController {

	private final Logger logger = LoggerFactory.getLogger(CustomItemController.class);

	@Autowired
	private IGoodsItemService itemService;

	@RequestMapping(value="/detail",method=RequestMethod.GET)
	@ResponseBody
	public ModelMap detail(@RequestParam("goodsId") long goodsId){
		ModelMap map = new ModelMap();
		IGoodsItem item = itemService.get(goodsId);
		map.addAttribute(IceConstant.SUCCESS, true);
		map.addAttribute(IceConstant.DATA, Item2Form.toForm(item));
		return map;
	}

}

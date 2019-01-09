package com.imooc.controller.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2019/1/8 15:06
 */
@Controller
@RequestMapping(value ="/shopadmin",method = RequestMethod.GET)
public class ShopAdminController {
    @RequestMapping(value = "/shopoperation")
    public String shopOperation(){
        return "/shop/shopoperation";
    }

}

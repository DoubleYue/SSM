package com.imooc.controller.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.dto.ShopExecution;
import com.imooc.entity.Area;
import com.imooc.entity.PersonInfo;
import com.imooc.entity.Shop;
import com.imooc.entity.ShopCategory;
import com.imooc.enums.ShopStateEnum;
import com.imooc.service.AreaService;
import com.imooc.service.ShopCategoryService;
import com.imooc.service.ShopService;
import com.imooc.util.CodeUtil;
import com.imooc.util.HttpServletRequestUtil;
import com.imooc.util.ImageUtil;
import com.imooc.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2019/1/8 11:34
 */
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;

    /**
     * 初始化店铺类别和区域信息
     */
    @RequestMapping(value = "/getshopinitinfo",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getShopInitInfo(){
        System.out.println("什么鬼！");
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
        List<Area> areaList = new ArrayList<Area>();
        try{
            shopCategoryList = shopCategoryService.queryShopCategory(new ShopCategory());
            areaList = areaService.getAreaList();
            modelMap.put("shopCategoryList",shopCategoryList);
            modelMap.put("areaList",areaList);
            modelMap.put("success",true);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
        }
        return modelMap;
    }

    /**
     * 店铺信息注册
     */
    @RequestMapping(value = "/registershop" ,method= RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> registerShop(HttpServletRequest request){

        //接收并转换相应的参数，包括店铺信息以及图片信息
        Map<String,Object> moduleMap = new HashMap<String, Object>();
        //校验验证码
        if(!CodeUtil.checkVertifyCode(request))
        {
            moduleMap.put("success",false);
            moduleMap.put("errMsg","输入了错误的验证码");
            return moduleMap;
        }
        String shopStr = HttpServletRequestUtil.getString(request,"shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try{
            //将json转为类对象
            shop = mapper.readValue(shopStr,Shop.class);
        }catch (Exception e){
            moduleMap.put("success",false);
            moduleMap.put("errMsg",e.getMessage());
            return moduleMap;
        }
        CommonsMultipartFile shopImg = null;
        //1.获取文件流
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if(commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
            shopImg = (CommonsMultipartFile)multipartHttpServletRequest.getFile("shopImg");
        }else{
            moduleMap.put("success",false);
            moduleMap.put("errMsg","上传图片不能为空");
            return  moduleMap;
        }
       //2.店铺注册
        if(shop!=null && shopImg!=null){
            PersonInfo owner = new PersonInfo();
            owner.setUserId(1);
            shop.setOwner(owner);
            ShopExecution shopExecution = null;
            try {
                shopExecution = shopService.addShop(shop, shopImg.getInputStream(),shopImg.getOriginalFilename());
            } catch (IOException e) {
                moduleMap.put("success",false);
                moduleMap.put("errMsg",shopExecution.getStateInfo());
            }
            if(shopExecution.getState()== ShopStateEnum.CHECK.getState()){
                moduleMap.put("success",true);
            }else{
                moduleMap.put("success",false);
                moduleMap.put("errMsg",shopExecution.getStateInfo());
            }
            return  moduleMap;
        }else {
            moduleMap.put("success",false);
            moduleMap.put("errMsg","请输入店铺信息");
            return  moduleMap;
        }

    }
//
//    /**
//     * 将输入流转为文件类型
//     * @param ins
//     * @param file
//     */
//    private static void inputStreamToFile(InputStream ins, File file){
//        FileOutputStream os = null;
//        try{
//            os = new FileOutputStream(file);
//            int bytesRead = 0;
//            byte[] buffer = new byte[1024];
//            if((bytesRead=ins.read(buffer))!=-1)
//            {
//                os.write(buffer,0,bytesRead);
//            }
//        }catch (Exception e){
//            throw new RuntimeException("调用inputStreamToFile产生异常:"+e.getMessage());
//        }finally {
//            try{
//                if(os!=null){
//                    os.close();
//                }
//                if(ins!=null){
//                    ins.close();
//                }
//            }catch (IOException e){
//                throw new RuntimeException("inputStreamToFile关闭io产生异常:"+e.getMessage());
//            }
//        }
//    }
}


$(function () {
    var initUrl = '/demo/shopadmin/getshopinitinfo';
    var registerShopUrl = '/demo/shopadmin/registershop';
    getShopInitInfo();

    /**
     * 1.从后台获取店铺和区域信息，并填充到前台html页面中
     */
    function getShopInitInfo(){
    $.getJSON(initUrl,function (data) {
        if(data.success){
            var tempHtml = '';
            var tempAreaHtml = '';
            data.shopCategoryList.map(function (item,index) {
                tempHtml+='<option data-id="'+item.shopCategoryId+'">'+
                    item.shopCategoryName+'</option>>';
            });
            data.areaList.map(function (item,index) {
                tempAreaHtml+='<option data-id="'+item.areaId+'">'+item.areaName+
                    '</option>';
            });
            //将获取到的数据填充到前台html页面中
            $('#shop-category').html(tempHtml);
            $('#area').html(tempAreaHtml);
        }
    });
    }

    /***
     * 2.信息提交给后端注册店铺
     */
    $('#submit').click(function () {
        var shop = {};
        shop.shopName = $('#shop-name').val();
        shop.shopAddr = $('#shop-addr').val();
        shop.phone = $('#shop-phone').val();
        shop.shopDesc = $('#shop-desc').val();
        shop.shopCategory = {
            shopCategoryId:$('#shop-category').find('option').not(function () {
                return !this.selected;
            }).data('id')
        };
        shop.area ={
            areaId: $('#area').find('option').not(function () {
                return !this.selected
            }).data('id')
        };
        //获得文件的大小
        var shopImg = $('#shop-img')[0].files[0];
        var formData = new FormData();
        formData.append('shopImg',shopImg);
        formData.append('shopStr',JSON.stringify(shop));
        var verifyCodeActual = $('#j_captcha').val();
        if(!verifyCodeActual){
            $.toast('请输入验证码！');
            return ;
        }
        formData.append('verifyCodeActual',verifyCodeActual);
        $.ajax({
            url:registerShopUrl,
            type:'POST',
            data:formData,
            contentType:false,
            processData:false,
            cache:false,
            success:function (data) {
                if(data.success){
                    $.toast('提交成功！');
                }else{
                    $.toast('提交失败！'+data.errMsg);
                }
                $('#captcha_img').click();
            }
        })
    })

})
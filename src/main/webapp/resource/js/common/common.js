
/**
 * 生成随机数用于验证码的生成
 */
function changeVerifyCode(img) {
    img.src = '../Kaptcha?'+Math.floor(Math.random()*100);
}

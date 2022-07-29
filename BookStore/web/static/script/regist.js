function check() {
    var uname = document.getElementById("uname").value; // 用户名
    // 校验用户名(4-10位字母+数字)，不符合给出相应提示。
    var unameReg = /^[0-9a-zA-Z]{4,10}$/; // -g：匹配所有;  -i：忽略大小写;  -m：多行匹配
    if (!unameReg.test(uname)){
        document.getElementById("unameSpan").style.visibility = "visible";
        return false;
    }else{
        document.getElementById("unameSpan").style.visibility = "hidden";
    }

    // 校验密码(至少6位)，不符合给出相应提示。
    var pwd1 = document.getElementById("pwd1").value; // 第一次输入的密码
    var pwdReg1 = /^\S{6,}$/;
    if (!pwdReg1.test(pwd1)){
        document.getElementById("pwdSpan1").style.visibility = "visible";
        return false;
    }else{
        document.getElementById("pwdSpan1").style.visibility = "hidden";
    }

    // 校验两次密码输入
    var pwd2 = document.getElementById("pwd2").value; // 第二次输入的密码
    if (pwd1 != pwd2){
        document.getElementById("pwdSpan2").style.visibility = "visible";
        return false;
    }else{
        document.getElementById("pwdSpan2").style.visibility = "hidden";
    }

    // 校验邮箱
    var email = document.getElementById("email").value; // 邮箱
    var emailReg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
    if (!emailReg.test(email)){
        document.getElementById("emailSpan").style.visibility = "visible";
        return false;
    }else{
        document.getElementById("emailSpan").style.visibility = "hidden";
    }

    // // 校验验证码
    // var inputCode = document.getElementById("inputCode").value; // 验证码
    // var code  = document.getElementById("CodeSpan").value;
    // if (inputCode !== code){
    //     document.getElementById("CodeSpan").style.visibility = "visible";
    //     return false;
    // }else{
    //     document.getElementById("CodeSpan").style.visibility = "hidden";
    // }

}
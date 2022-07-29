package com.callbin.bookstores.controllers;

import com.callbin.bookstores.pojo.Cart;
import com.callbin.bookstores.pojo.User;
import com.callbin.bookstores.service.CartItemService;
import com.callbin.bookstores.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * dao
 *
 * @author 张滨
 * @time 2022/07/12 15:02
 */
public class UserController {
    private UserService userService;
    private CartItemService cartItemService;

    public String login(String uname, String pwd, HttpSession session,HttpServletResponse response) throws IOException {

        User user = userService.login(uname, pwd);
        if (user != null) {
            Cart cart = cartItemService.getCartByUser(user);
            user.setCart(cart);

            session.setAttribute("user", user);
            return "redirect:book.do?operate=getBookList";
        }
        return "user/login";
    }

    public String regist(HttpSession session, String inputCode, String uname, String pwd1, String email, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); // 输出流。向网页输出错误提示信息

        Object kaptcha_session_key = session.getAttribute("KAPTCHA_SESSION_KEY"); // 图片验证码中的具体字符

        // 判断用户是否已注册
        if (userService.login(uname,pwd1) != null){
            out.println("<script language='javascript'>alert('该用户已注册！');</script>");
            return "user/regist";
        }

        // 验证码输入为空 或者 输入验证码信息不一致
        if (inputCode == null || !inputCode.equals(kaptcha_session_key)){
            out.println("<script language='javascript'>alert('验证码输入有误！');</script>");
            return "user/regist";
        }else{
            userService.addUser(new User(uname, pwd1, email));
            return "user/login";
        }

    }
}

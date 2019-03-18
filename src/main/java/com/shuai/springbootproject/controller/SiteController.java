package com.shuai.springbootproject.controller;

import com.shuai.springbootproject.pojo.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
@Controller
public class SiteController {

    @RequestMapping("/toIndex")
    public String index(Model model) {
        ArrayList<Article> list = new ArrayList<>();
        list.add(new Article("nginx","Nginx (engine x) 是一个高性能的HTTP和反向代理服务，也是一个IMAP/POP3/SMTP服务。","www.baidu.com"));
        list.add(new Article("springboot","H5 页面发版灵活，轻量，又具有跨平台的特性，在业务上有很多应用场景。","www.baidu.com"));
        list.add(new Article("doubbo","Python是最容易入门的编程语言。","www.baidu.com"));
        model.addAttribute("articleList",list);
        return "index";
    }

}

package com.example.demo.controller;

import com.example.demo.config.WebConst;
import com.example.demo.model.ContentVo;
import com.example.demo.service.IContentService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mr.PanYang on 2018/3/15.
 */
public class IndexController extends BaseController{

    private IContentService contentService;

    /**
     * 首页
     *
     * @return
     */
    @GetMapping(value = "/")
    public String index(HttpServletRequest request, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        return this.index(request, 1, limit);
    }

    /**
     * 首页分页
     *
     * @param request request
     * @param p       第几页
     * @param limit   每页大小
     * @return 主页
     */
    @GetMapping(value = "page/{p}")
    public String index(HttpServletRequest request, @PathVariable int p, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        p = p < 0 || p > WebConst.MAX_PAGE ? 1 : p;
        PageInfo<ContentVo> articles = contentService.getContents(p, limit);
        request.setAttribute("articles", articles);
        if (p > 1) {
            this.title(request, "第" + p + "页");
        }
        return this.render("index");
    }


}

/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web.front;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.servlet.ValidateCodeServlet;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import com.thinkgem.jeesite.modules.cms.entity.Category;
import com.thinkgem.jeesite.modules.cms.entity.Comment;
import com.thinkgem.jeesite.modules.cms.entity.Link;
import com.thinkgem.jeesite.modules.cms.entity.Site;
import com.thinkgem.jeesite.modules.cms.service.ArticleDataService;
import com.thinkgem.jeesite.modules.cms.service.ArticleService;
import com.thinkgem.jeesite.modules.cms.service.CategoryService;
import com.thinkgem.jeesite.modules.cms.service.CommentService;
import com.thinkgem.jeesite.modules.cms.service.LinkService;
import com.thinkgem.jeesite.modules.cms.service.SiteService;
import com.thinkgem.jeesite.modules.cms.utils.CmsUtils;
import com.thinkgem.jeesite.modules.zh.star.entity.StarAlbum;
import com.thinkgem.jeesite.modules.zh.star.entity.StarPhoto;
import com.thinkgem.jeesite.modules.zh.star.entity.StarStarmessage;
import com.thinkgem.jeesite.modules.zh.star.entity.StarUser;
import com.thinkgem.jeesite.modules.zh.star.service.StarAlbumService;
import com.thinkgem.jeesite.modules.zh.star.service.StarPhotoService;
import com.thinkgem.jeesite.modules.zh.star.service.StarStarmessageService;
import com.thinkgem.jeesite.modules.zh.star.utils.starUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 网站Controller
 * @author ThinkGem
 * @version 2013-5-29
 */
@Controller
@RequestMapping(value = "${frontPath}")
public class FrontController extends BaseController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleDataService articleDataService;
    @Autowired
    private LinkService linkService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SiteService siteService;
    @Autowired
    private StarPhotoService starPhotoService;
    @Autowired
    private StarAlbumService starAlbumService;
    @Autowired
    private StarStarmessageService starStarmessageService;

    /**
     * 网站首页
     */
    @RequestMapping
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {

        Site site = CmsUtils.getSite(Site.defaultSiteId());
        model.addAttribute("site", site);
        model.addAttribute("isIndex", true);
//		是否登录 如果登录 只展示守护星
        StarUser starUser = null;
        StarAlbum starAlbum = new StarAlbum();
//        人物信息
        List<StarStarmessage> starMessageList = new ArrayList<StarStarmessage>();
        if (starUtils.isStarLogin(request)) {
            starUser = starUtils.getCurrentUser(request);
            starAlbum.setStarIds(starUser.getStarId());
        }
//		TODO：前台首页需要的图片 选取人气最高的5位明星 各一张背景图片
        List<StarPhoto> bgPhoto = starPhotoService.findListBGPhoto("5", starUser);
        model.addAttribute("bgPhoto", bgPhoto);
        for (StarPhoto s : bgPhoto) {
            starMessageList.add(starStarmessageService.get(s.getStarId()));
        }
        model.addAttribute("starMessageList", starMessageList);
//		为你代颜 相册
        List<StarAlbum> starAlbumlist = starAlbumService.findPage(new Page<StarAlbum>(1, 6), starAlbum).getList();
        model.addAttribute("starAlbumlist", starAlbumlist);
        return "modules/cms/front/themes/" + site.getTheme() + "/frontIndex";
    }

    @RequestMapping("alubmPhotoList")
    @ResponseBody
    public String alubmPhotoList(@RequestParam("id") String id) {
        String html = "";
        List<StarPhoto> photoList = starAlbumService.get(id).getPhotoList();
        for (StarPhoto s : photoList) {
//            灯箱展示时 如果没有标题说明 给一个相册名
            if (s.getTitle()==null){
                s.setTitle(starAlbumService.get(id).getName());
            }
            html += "<a data-src=\"" + Global.getUploadfile() + s.getUrl() + "\" data-title="+s.getTitle()+" \"><img src=\"" + Global.getUploadfile() + s.getUrl() + "\" hidden=\"hidden\"  alt=\"Couture\"></a>";
        }
        return html;
    }

    /**
     * 网站首页
     */
    @RequestMapping(value = "index-{siteId}${urlSuffix}")
    public String index(@PathVariable String siteId, Model model) {
        if (siteId.equals("1")) {
            return "redirect:" + Global.getFrontPath();
        }
        Site site = CmsUtils.getSite(siteId);
        // 子站有独立页面，则显示独立页面
        if (StringUtils.isNotBlank(site.getCustomIndexView())) {
            model.addAttribute("site", site);
            model.addAttribute("isIndex", true);
            return "modules/cms/front/themes/" + site.getTheme() + "/frontIndex" + site.getCustomIndexView();
        }
        // 否则显示子站第一个栏目
        List<Category> mainNavList = CmsUtils.getMainNavList(siteId);
        if (mainNavList.size() > 0) {
            String firstCategoryId = CmsUtils.getMainNavList(siteId).get(0).getId();
            return "redirect:" + Global.getFrontPath() + "/list-" + firstCategoryId + Global.getUrlSuffix();
        } else {
            model.addAttribute("site", site);
            return "modules/cms/front/themes/" + site.getTheme() + "/frontListCategory";
        }
    }

    /**
     * 内容列表
     */
    @RequestMapping(value = "list-{categoryId}${urlSuffix}")
    public String list(@PathVariable String categoryId, @RequestParam(required = false, defaultValue = "1") Integer pageNo,
                       @RequestParam(required = false, defaultValue = "15") Integer pageSize, Model model) {
        Category category = categoryService.get(categoryId);
        if (category == null) {
            Site site = CmsUtils.getSite(Site.defaultSiteId());
            model.addAttribute("site", site);
            return "error/404";
        }
        Site site = siteService.get(category.getSite().getId());
        model.addAttribute("site", site);
        // 2：简介类栏目，栏目第一条内容
        if ("2".equals(category.getShowModes()) && "article".equals(category.getModule())) {
            // 如果没有子栏目，并父节点为跟节点的，栏目列表为当前栏目。
            List<Category> categoryList = Lists.newArrayList();
            if (category.getParent().getId().equals("1")) {
                categoryList.add(category);
            } else {
                categoryList = categoryService.findByParentId(category.getParent().getId(), category.getSite().getId());
            }
            model.addAttribute("category", category);
            model.addAttribute("categoryList", categoryList);
            // 获取文章内容
            Page<Article> page = new Page<Article>(1, 1, -1);
            Article article = new Article(category);
            page = articleService.findPage(page, article, false);
            if (page.getList().size() > 0) {
                article = page.getList().get(0);
                article.setArticleData(articleDataService.get(article.getId()));
                articleService.updateHitsAddOne(article.getId());
            }
            model.addAttribute("article", article);
            CmsUtils.addViewConfigAttribute(model, category);
            CmsUtils.addViewConfigAttribute(model, article.getViewConfig());
            return "modules/cms/front/themes/" + site.getTheme() + "/" + getTpl(article);
        } else {
            List<Category> categoryList = categoryService.findByParentId(category.getId(), category.getSite().getId());
            // 展现方式为1 、无子栏目或公共模型，显示栏目内容列表
            if ("1".equals(category.getShowModes()) || categoryList.size() == 0) {
                // 有子栏目并展现方式为1，则获取第一个子栏目；无子栏目，则获取同级分类列表。
                if (categoryList.size() > 0) {
                    category = categoryList.get(0);
                } else {
                    // 如果没有子栏目，并父节点为跟节点的，栏目列表为当前栏目。
                    if (category.getParent().getId().equals("1")) {
                        categoryList.add(category);
                    } else {
                        categoryList = categoryService.findByParentId(category.getParent().getId(), category.getSite().getId());
                    }
                }
                model.addAttribute("category", category);
                model.addAttribute("categoryList", categoryList);
                // 获取内容列表
                if ("article".equals(category.getModule())) {
                    Page<Article> page = new Page<Article>(pageNo, pageSize);
                    //System.out.println(page.getPageNo());
                    page = articleService.findPage(page, new Article(category), false);
                    model.addAttribute("page", page);
                    // 如果第一个子栏目为简介类栏目，则获取该栏目第一篇文章
                    if ("2".equals(category.getShowModes())) {
                        Article article = new Article(category);
                        if (page.getList().size() > 0) {
                            article = page.getList().get(0);
                            article.setArticleData(articleDataService.get(article.getId()));
                            articleService.updateHitsAddOne(article.getId());
                        }
                        model.addAttribute("article", article);
                        CmsUtils.addViewConfigAttribute(model, category);
                        CmsUtils.addViewConfigAttribute(model, article.getViewConfig());
                        return "modules/cms/front/themes/" + site.getTheme() + "/" + getTpl(article);
                    }
                } else if ("link".equals(category.getModule())) {
                    Page<Link> page = new Page<Link>(1, -1);
                    page = linkService.findPage(page, new Link(category), false);
                    model.addAttribute("page", page);
                }
                String view = "/frontList";
                if (StringUtils.isNotBlank(category.getCustomListView())) {
                    view = "/" + category.getCustomListView();
                }
                CmsUtils.addViewConfigAttribute(model, category);
                site = siteService.get(category.getSite().getId());
                //System.out.println("else 栏目第一条内容 _2 :"+category.getSite().getTheme()+","+site.getTheme());
                return "modules/cms/front/themes/" + siteService.get(category.getSite().getId()).getTheme() + view;
                //return "modules/cms/front/themes/"+category.getSite().getTheme()+view;
            }
            // 有子栏目：显示子栏目列表
            else {
                model.addAttribute("category", category);
                model.addAttribute("categoryList", categoryList);
                String view = "/frontListCategory";
                if (StringUtils.isNotBlank(category.getCustomListView())) {
                    view = "/" + category.getCustomListView();
                }
                CmsUtils.addViewConfigAttribute(model, category);
                return "modules/cms/front/themes/" + site.getTheme() + view;
            }
        }
    }

    /**
     * 内容列表（通过url自定义视图）
     */
    @RequestMapping(value = "listc-{categoryId}-{customView}${urlSuffix}")
    public String listCustom(@PathVariable String categoryId, @PathVariable String customView, @RequestParam(required = false, defaultValue = "1") Integer pageNo,
                             @RequestParam(required = false, defaultValue = "15") Integer pageSize, Model model) {
        Category category = categoryService.get(categoryId);
        if (category == null) {
            Site site = CmsUtils.getSite(Site.defaultSiteId());
            model.addAttribute("site", site);
            return "error/404";
        }
        Site site = siteService.get(category.getSite().getId());
        model.addAttribute("site", site);
        List<Category> categoryList = categoryService.findByParentId(category.getId(), category.getSite().getId());
        model.addAttribute("category", category);
        model.addAttribute("categoryList", categoryList);
        CmsUtils.addViewConfigAttribute(model, category);
        return "modules/cms/front/themes/" + site.getTheme() + "/frontListCategory" + customView;
    }

    /**
     * 显示内容
     */
    @RequestMapping(value = "view-{categoryId}-{contentId}${urlSuffix}")
    public String view(@PathVariable String categoryId, @PathVariable String contentId, Model model) {
        Category category = categoryService.get(categoryId);
        if (category == null) {
            Site site = CmsUtils.getSite(Site.defaultSiteId());
            model.addAttribute("site", site);
            return "error/404";
        }
        model.addAttribute("site", category.getSite());
        if ("article".equals(category.getModule())) {
            // 如果没有子栏目，并父节点为跟节点的，栏目列表为当前栏目。
            List<Category> categoryList = Lists.newArrayList();
            if (category.getParent().getId().equals("1")) {
                categoryList.add(category);
            } else {
                categoryList = categoryService.findByParentId(category.getParent().getId(), category.getSite().getId());
            }
            // 获取文章内容
            Article article = articleService.get(contentId);
            if (article == null || !Article.DEL_FLAG_NORMAL.equals(article.getDelFlag())) {
                return "error/404";
            }
            // 文章阅读次数+1
            articleService.updateHitsAddOne(contentId);
            // 获取推荐文章列表
            List<Object[]> relationList = articleService.findByIds(articleDataService.get(article.getId()).getRelation());
            // 将数据传递到视图
            model.addAttribute("category", categoryService.get(article.getCategory().getId()));
            model.addAttribute("categoryList", categoryList);
            article.setArticleData(articleDataService.get(article.getId()));
            model.addAttribute("article", article);
            model.addAttribute("relationList", relationList);
            CmsUtils.addViewConfigAttribute(model, article.getCategory());
            CmsUtils.addViewConfigAttribute(model, article.getViewConfig());
            Site site = siteService.get(category.getSite().getId());
            model.addAttribute("site", site);
//			return "modules/cms/front/themes/"+category.getSite().getTheme()+"/"+getTpl(article);
            return "modules/cms/front/themes/" + site.getTheme() + "/" + getTpl(article);
        }
        return "error/404";
    }

    /**
     * 内容评论
     */
    @RequestMapping(value = "comment", method = RequestMethod.GET)
    public String comment(String theme, Comment comment, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Comment> page = new Page<Comment>(request, response);
        Comment c = new Comment();
        c.setCategory(comment.getCategory());
        c.setContentId(comment.getContentId());
        c.setDelFlag(Comment.DEL_FLAG_NORMAL);
        page = commentService.findPage(page, c);
        model.addAttribute("page", page);
        model.addAttribute("comment", comment);
        return "modules/cms/front/themes/" + theme + "/frontComment";
    }

    /**
     * 内容评论保存
     */
    @ResponseBody
    @RequestMapping(value = "comment", method = RequestMethod.POST)
    public String commentSave(Comment comment, String validateCode, @RequestParam(required = false) String replyId, HttpServletRequest request) {
        if (StringUtils.isNotBlank(validateCode)) {
            if (ValidateCodeServlet.validate(request, validateCode)) {
                if (StringUtils.isNotBlank(replyId)) {
                    Comment replyComment = commentService.get(replyId);
                    if (replyComment != null) {
                        comment.setContent("<div class=\"reply\">" + replyComment.getName() + ":<br/>"
                                + replyComment.getContent() + "</div>" + comment.getContent());
                    }
                }
                comment.setIp(request.getRemoteAddr());
                comment.setCreateDate(new Date());
                comment.setDelFlag(Comment.DEL_FLAG_AUDIT);
                commentService.save(comment);
                return "{result:1, message:'提交成功。'}";
            } else {
                return "{result:2, message:'验证码不正确。'}";
            }
        } else {
            return "{result:2, message:'验证码不能为空。'}";
        }
    }

    /**
     * 站点地图
     */
    @RequestMapping(value = "map-{siteId}${urlSuffix}")
    public String map(@PathVariable String siteId, Model model) {
        Site site = CmsUtils.getSite(siteId != null ? siteId : Site.defaultSiteId());
        model.addAttribute("site", site);
        return "modules/cms/front/themes/" + site.getTheme() + "/frontMap";
    }

    private String getTpl(Article article) {
        if (StringUtils.isBlank(article.getCustomContentView())) {
            String view = null;
            Category c = article.getCategory();
            boolean goon = true;
            do {
                if (StringUtils.isNotBlank(c.getCustomContentView())) {
                    view = c.getCustomContentView();
                    goon = false;
                } else if (c.getParent() == null || c.getParent().isRoot()) {
                    goon = false;
                } else {
                    c = c.getParent();
                }
            } while (goon);
            return StringUtils.isBlank(view) ? Article.DEFAULT_TEMPLATE : view;
        } else {
            return article.getCustomContentView();
        }
    }

}

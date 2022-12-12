package org.hantiv.user.designPattern.filterPattern;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Zhikun Han
 * @Date Created in 16:52 2022/12/12
 * @Description:
 */
public class ArticleFilterDemo {
    private List<ArticleFilterEnum> articleFilterEnumList;

    private List<IArticleFilter> iArticleFilters;

    private void init(){
        this.iArticleFilters = ArticleFilterFactory.createArticleFilter(articleFilterEnumList);
    }

    public void doFilter(List<Article> articleList){
        articleList.stream().filter(article -> {
            ArticleContext articleContext = new ArticleContext();
            articleContext.setArticle(article);
            return doFilter(articleContext);
        }).collect(Collectors.toList());
    }
    private boolean doFilter(ArticleContext articleContext){
        for (IArticleFilter iArticleFilter : iArticleFilters) {
            if (iArticleFilter.doFilter(articleContext)){
                return false;
            }
        }
        return true;
    }
}

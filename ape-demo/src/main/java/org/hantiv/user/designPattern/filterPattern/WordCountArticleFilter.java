package org.hantiv.user.designPattern.filterPattern;

/**
 * @Author Zhikun Han
 * @Date Created in 16:40 2022/12/12
 * @Description:
 */
public class WordCountArticleFilter extends BaseArticleFilter{
    @Override
    public boolean doFilter(ArticleContext articleContext) {
        Article article = articleContext.getArticle();
        Long count = article.getWordCount();
        if (count>10){
            return true;
        }
        return false;
    }
}

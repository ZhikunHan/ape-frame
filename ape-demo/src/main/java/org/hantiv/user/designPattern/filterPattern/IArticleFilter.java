package org.hantiv.user.designPattern.filterPattern;

/**
 * @Author Zhikun Han
 * @Date Created in 16:34 2022/12/12
 * @Description:
 */
public interface IArticleFilter {

    boolean doFilter(ArticleContext articleContext);

}

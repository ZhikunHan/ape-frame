package org.hantiv.user.designPattern.filterPattern;

/**
 * @Author Zhikun Han
 * @Date Created in 16:36 2022/12/12
 * @Description:
 */
public abstract class BaseArticleFilter implements IArticleFilter{
    public abstract boolean doFilter(ArticleContext articleContext);
    private void filter(ArticleContext articleContext){
        // 过滤
        doFilter(articleContext);
        // 各种操作如 -> 发送通知
        sendMsg();
    }

    private void sendMsg(){
        // 发送通知
    }
}

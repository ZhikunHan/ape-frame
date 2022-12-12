package org.hantiv.user.designPattern.filterPattern;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Zhikun Han
 * @Date Created in 16:46 2022/12/12
 * @Description:
 */
public class ArticleFilterFactory {
    public static List<IArticleFilter> createArticleFilter(List<ArticleFilterEnum> articleFilterEnumList){
        List<IArticleFilter> articleFilters = new ArrayList<>();
        if (CollectionUtils.isEmpty(articleFilterEnumList)){
            articleFilters = articleFilterEnumList.stream().map(x->
                ArticleFilterFactory.createFilter(x)
            ).collect(Collectors.toList());
        }
        return articleFilters;
    }
    public static IArticleFilter createFilter(ArticleFilterEnum articleFilterEnum){
        IArticleFilter iArticleFilter = null;

        switch (articleFilterEnum){
            case WORD_COUNT:
                iArticleFilter = new WordCountArticleFilter();
                break;
            default:
                break;
        }
        return iArticleFilter;
    }
}

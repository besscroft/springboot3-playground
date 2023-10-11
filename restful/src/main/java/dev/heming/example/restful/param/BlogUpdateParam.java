package dev.heming.example.restful.param;

import lombok.Data;

/**
 * @Description 博客更新请求参数
 * @Author Bess Croft
 * @Date 2023/10/11 16:46
 */
@Data
public class BlogUpdateParam {

    /** 博客 id */
    private Integer id;

    /** 博客标题 */
    private String title;

    /** 博客内容 */
    private String content;

    /** 博客作者 */
    private String author;

    /** 博客封面 */
    private String cover;

    /** 博客标签 */
    private String tags;

    /** 博客分类 */
    private String category;

    /** 博客排序 */
    private Integer sort;

    /** 博客状态：0->未发布状态；1->已发布状态 */
    private Integer status;

}

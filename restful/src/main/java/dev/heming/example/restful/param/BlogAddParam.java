package dev.heming.example.restful.param;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @Description 博客新增请求参数
 * @Author Bess Croft
 * @Date 2023/10/11 16:42
 */
@Data
public class BlogAddParam {

    /** 博客标题 */
    @NotBlank
    @Size(min = 1, max = 50 , message = "博客标题不能为空，且博客标题长度在 1 到 50 字")
    private String title;

    /** 博客内容 */
    @NotBlank
    @Size(max = 50000 , message = "博客内容不能为空，且博客内容最大支持 5w 字")
    private String content;

    /** 博客作者 */
    @NotBlank(message = "博客作者不能为空")
    private String author;

    /** 博客封面 */
    private String cover;

    /** 博客标签 */
    private String tags;

    /** 博客分类 */
    private String category;

    /** 博客排序 */
    @NotNull(message = "博客排序不能为空")
    private Integer sort;

}

package dev.heming.example.restful.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description 博客列表封装对象
 * @Author Bess Croft
 * @Date 2023/10/11 16:18
 */
@Data
public class BlogListDto {

    /** 博客 id */
    private Integer id;

    /** 博客标题 */
    private String title;

    /** 博客作者 */
    private String author;

    /** 博客创建时间 */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /** 博客封面 */
    private String cover;

    /** 博客标签 */
    private String tags;

    /** 博客分类 */
    private String category;

    /** 博客排序 */
    private Integer sort;

}

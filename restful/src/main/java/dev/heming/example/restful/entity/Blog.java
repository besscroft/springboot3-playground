package dev.heming.example.restful.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description 博客实体类
 * @Author Bess Croft
 * @Date 2023/10/11 13:23
 */
@Data
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 博客 id */
    private Integer id;

    /** 博客标题 */
    private String title;

    /** 博客内容 */
    private String content;

    /** 博客作者 */
    private String author;

    /** 博客创建时间 */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    /** 博客更新时间 */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;

    /** 博客状态：0->未发布状态；1->已发布状态 */
    private Integer status;

    /** 博客封面 */
    private String cover;

    /** 博客标签 */
    private String tags;

    /** 博客分类 */
    private String category;

    /** 博客排序 */
    private Integer sort;

    /** 逻辑删除：0->删除状态；1->可用状态 */
    private Integer del;

}

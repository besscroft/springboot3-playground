package dev.heming.example.restful.controller;

import dev.heming.example.restful.dto.BlogListDto;
import dev.heming.example.restful.entity.Blog;
import dev.heming.example.restful.param.BlogAddParam;
import dev.heming.example.restful.param.BlogUpdateParam;
import dev.heming.example.restful.result.CommonResult;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description 博客交互接口
 * @Author Bess Croft
 * @Date 2023/10/11 13:19
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    /**
     * 获取所有博客列表
     * @return 博客列表
     */
    @GetMapping("/")
    public CommonResult<List<BlogListDto>> blogList() {
        return CommonResult.OK(getBlogList(""));
    }

    /**
     * 根据 ID 获取博客内容
     * @param id 博客 ID
     * @return 博客
     */
    @GetMapping("/{id:[\\d]+}")
    public CommonResult<Blog> blogById(@PathVariable(name = "id") Integer id) {
        return CommonResult.OK(getBlog(id));
    }

    /**
     * 根据博客文章分类获取博客列表
     * @param category 博客分类
     * @return 博客列表
     */
    @GetMapping("/category/{key}")
    public CommonResult<List<BlogListDto>> blogListByCategory(@PathVariable(name = "key") String category) {
        return CommonResult.OK(getBlogList(category));
    }

    /**
     * 创建新博客
     * @param param 博客新增请求参数
     */
    @PostMapping("/")
    public CommonResult<Void> blogAdd(@RequestBody @Valid BlogAddParam param) {
        // 假设这里调用了新增业务方法，然后返回
        return CommonResult.OK();
    }

    /**
     * 根据 ID 更新博客
     * @param id 博客 ID
     * @param param 博客更新请求参数
     */
    @PutMapping("/{id:[\\d]+}")
    public CommonResult<Void> blogUpdate(@PathVariable(name = "id") Integer id, @RequestBody BlogUpdateParam param) {
        // 假设这里调用了更新业务方法，然后返回
        return CommonResult.OK();
    }

    /**
     * 根据 ID 删除博客
     * @param id 博客 ID
     */
    @DeleteMapping("/{id:[\\d]+}")
    public CommonResult<Void> blogDelete(@PathVariable(name = "id") Integer id) {
        // 假设这里调用了删除业务方法，然后返回
        return CommonResult.OK();
    }

    /**
     * 演示用，写的假数据，实际开发中应在业务层中访问数据层进行获取。
     * @return 博客列表数据
     */
    private List<BlogListDto> getBlogList(String category) {
        BlogListDto dto1 = new BlogListDto();
        dto1.setId(1);
        dto1.setTitle("演示标题1");
        dto1.setAuthor("云淑");
        dto1.setCreateTime(LocalDateTime.now());
        dto1.setCover("https://example.com/example.jpg");
        dto1.setTags("演示标签1");
        dto1.setCategory("演示分类1");
        dto1.setSort(1);
        BlogListDto dto2 = new BlogListDto();
        dto2.setId(2);
        dto2.setTitle("演示标题2");
        dto2.setAuthor("云淑");
        dto2.setCreateTime(LocalDateTime.now());
        dto2.setCover("https://example.com/example.jpg");
        dto2.setTags("演示标签2");
        dto2.setCategory("演示分类2");
        dto2.setSort(2);
        return switch (category) {
            case "演示分类1" -> List.of(dto1);
            case "演示分类2" -> List.of(dto2);
            default -> List.of(dto1, dto2);
        };
    }

    /**
     * 演示用，写的假数据，实际开发中应在业务层中访问数据层进行获取。
     * @return 博客数据
     */
    private Blog getBlog(Integer id) {
        Blog blog = new Blog();
        return switch (id) {
            case 1 -> {
                blog.setId(1);
                blog.setTitle("演示标题1");
                blog.setContent("演示内容1演示内容1演示内容1演示内容1演示内容1");
                blog.setAuthor("云淑");
                blog.setCreateTime(LocalDateTime.now());
                blog.setStatus(1);
                blog.setTags("演示标签1");
                blog.setCategory("演示分类1");
                blog.setSort(1);
                blog.setDel(1);
                yield blog;
            }
            case 2 -> {
                blog.setId(1);
                blog.setTitle("演示标题2");
                blog.setContent("演示内容2演示内容2演示内容2演示内容2演示内容2");
                blog.setAuthor("云淑");
                blog.setCreateTime(LocalDateTime.now());
                blog.setStatus(1);
                blog.setTags("演示标签2");
                blog.setCategory("演示分类2");
                blog.setSort(2);
                blog.setDel(1);
                yield blog;
            }
            default -> blog;
        };
    }

}

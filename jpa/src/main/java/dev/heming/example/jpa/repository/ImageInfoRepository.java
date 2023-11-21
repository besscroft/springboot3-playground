package dev.heming.example.jpa.repository;

import dev.heming.example.jpa.entity.ImageInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description 图片信息 Repository
 * @Author Bess Croft
 * @Date 2023/11/20 18:31
 */
@Repository
public interface ImageInfoRepository extends CrudRepository<ImageInfo, Long> {

    // 接口的内容默认是空的，在业务开发中，我们往往会根据需求来编写自定义的方法。

    ImageInfo findTopByUpdateTimeNotNull();

}

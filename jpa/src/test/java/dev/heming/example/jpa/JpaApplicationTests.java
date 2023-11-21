package dev.heming.example.jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.heming.example.jpa.entity.ImageInfo;
import dev.heming.example.jpa.repository.ImageInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Slf4j
@SpringBootTest
class JpaApplicationTests {

    @Autowired
    private ImageInfoRepository imageInfoRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void contextLoads() throws JsonProcessingException {
        // 查询所有数据
        Iterable<ImageInfo> imageInfos = imageInfoRepository.findAll();
        log.info("所有数据:{}", objectMapper.writeValueAsString(imageInfos));
        // 根据 id 查询数据
        Optional<ImageInfo> imageInfo = imageInfoRepository.findById(1L);
        log.info("id=1的数据:{}", objectMapper.writeValueAsString(imageInfo.orElse(null)));
        // 根据 id 删除数据
        imageInfoRepository.deleteById(1L);
        // 新增数据
        ImageInfo imageInfo1 = new ImageInfo();
        imageInfo1.setRating(4);
        imageInfo1.setUrl("https://www.baidu.com/example.jpg");
        imageInfo1.setDetail("测试");
        imageInfo1.setDel(0);
        ImageInfo saved = imageInfoRepository.save(imageInfo1);
        log.info("插入数据id:{}", saved.getId());
        ImageInfo info = imageInfoRepository.findTopByUpdateTimeNotNull();
        log.info("预定义模式查询的数据:{}", info);
    }

}

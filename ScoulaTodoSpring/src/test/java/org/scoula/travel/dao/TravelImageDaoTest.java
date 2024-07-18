package org.scoula.travel.dao;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.ProjectConfig;
import org.scoula.travel.domain.TravelImageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
@ExtendWith(SpringExtension.class)
@Component
public class TravelImageDaoTest {
    @Autowired
    TravelDao dao;

    @Test
    @Disabled
    void createTravelImages() throws IOException, SQLException {
        String dir = "C:\\travel-image";
        List<TravelImageVO> files = Files.list(Paths.get(dir))
                .map(Path::toFile)
                .map(TravelImageVO::of)
                .toList();
        for(TravelImageVO file: files) {
            System.out.println(file);
            dao.createImage(file);
        }
    }
}

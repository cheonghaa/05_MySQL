package org.scoula.travel.dao;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.scoula.travel.domain.TravelImageVO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.*;

public class TravelDaoTest {
    @Test
    @Disabled
    void createTravelImages() throws IOException {
        String dir = "C:\\travel-image";
        List<TravelImageVO> files = Files.list(Paths.get(dir))
                .map(Path::toFile)
                .map(TravelImageVO::of)
                .toList();
        for(TravelImageVO file: files) {
            System.out.println(file);
        }
    }


}

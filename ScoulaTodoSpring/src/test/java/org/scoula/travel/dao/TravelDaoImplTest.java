package org.scoula.travel.dao;


import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.scoula.travel.domain.TravelVO;
import org.scoula.config.ProjectConfig;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class})

@ExtendWith(SpringExtension.class)
@Component
class TravelDaoImplTest {
    @Autowired
    TravelDao dao;
    @Test
    @Disabled
    void create() throws IOException, SQLException {
        List<TravelVO> members = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv", StandardCharsets.UTF_8))
                .withType(TravelVO.class)
                .build()
                .parse();
        for(TravelVO travel : members) {
            System.out.println(travel);
//            dao.create(travel);
        }
    }

}
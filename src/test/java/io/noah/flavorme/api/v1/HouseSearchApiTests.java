package io.noah.flavorme.api.v1;

import io.noah.flavorme.api.config.AppContextConfig;
import io.noah.flavorme.api.config.MongoDBContextConfig;
import io.noah.flavorme.api.config.WebContextConfig;
import io.noah.flavorme.api.v1.model.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by chanwook on 2014. 9. 11..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebContextConfig.class, AppContextConfig.class, MongoDBContextConfig.class})
@Transactional
public class HouseSearchApiTests {

    private MockMvc mockMvc;

    @Autowired
    private MongoTemplate mt;

    @Autowired
    protected WebApplicationContext wac;

    private List<House> testHouses;
    private HouseSearchApi api;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();

        api = this.wac.getBean(HouseSearchApi.class);

        //TODO DB 스크립트로 변경
        createData();
    }


    private void createData() {
        this.testHouses = new ArrayList<>();

        ArrayList<HouseImage> images = new ArrayList<>();
        images.add(new HouseImage(0, "http://cdn.com/image1.png", "이미지1"));
        images.add(new HouseImage(1, "http://cdn.com/image2.png", "이미지2"));
        images.add(new HouseImage(2, "http://cdn.com/image3.png", "이미지3"));
        House h = new House("양남한우", "영등포구 문래동 양남시장 100번지", HouseCategory.BEAF, "사장님이 구워주는 일품 소고기!!!", HouseGrade.S, images);
        mt.insert(h);
        this.testHouses.add(h);
    }

    @After
    public void cleanup() {
        for (House h : this.testHouses) {
            mt.remove(h);
        }
    }

    @Test
    public void basicSearch() throws Exception {

        HouseSearchCriteria c = new HouseSearchCriteria();
        c.setCategory(HouseCategory.BEAF);
        c.setGrade(HouseGrade.X);
        c.setQuery("양남");
        c.setItemSizePerPage(10);
        c.setPageCount(0);

        HouseList result = api.search(c);

        Assert.assertNotNull(result);
        Assert.assertTrue(result.getHouseList().size() == 1);

    }
}
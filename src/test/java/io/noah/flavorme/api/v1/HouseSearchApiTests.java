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
import java.util.Date;
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
    private HouseTalk testTalk;

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

        Date date = new Date();
        ArrayList<HouseTalkReply> replies = new ArrayList<>();
        replies.add(new HouseTalkReply(System.currentTimeMillis(), "댓글1", new Date()));
        replies.add(new HouseTalkReply(System.currentTimeMillis(), "댓글2", new Date()));
        replies.add(new HouseTalkReply(System.currentTimeMillis(), "댓글3", new Date()));

        HouseTalk talk = new HouseTalk(h.getHouseId(), date, date, "최고에욧!!", images, replies);
        mt.insert(talk);
        this.testTalk = talk;
    }

    @After
    public void cleanup() {
        for (House h : this.testHouses) {
            mt.remove(h);
        }

        mt.remove(testTalk);
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

        Assert.assertEquals(this.testHouses.get(0).getHouseName(), result.getHouseList().get(0).getHouseName());
        Assert.assertEquals(this.testHouses.get(0).getCategory(), result.getHouseList().get(0).getCategory());
        Assert.assertEquals(this.testHouses.get(0).getDescription(), result.getHouseList().get(0).getDescription());
        Assert.assertEquals(this.testHouses.get(0).getGrade(), result.getHouseList().get(0).getGrade());
        Assert.assertEquals(this.testHouses.get(0).getHouseAddress(), result.getHouseList().get(0).getHouseAddress());
        Assert.assertEquals(this.testHouses.get(0).getImages().size(), result.getHouseList().get(0).getImages().size());
        Assert.assertEquals(this.testHouses.get(0).getImages().get(0).getIndex(), result.getHouseList().get(0).getImages().get(0).getIndex());
        Assert.assertEquals(this.testHouses.get(0).getImages().get(0).getUrl(), result.getHouseList().get(0).getImages().get(0).getUrl());
        Assert.assertEquals(this.testHouses.get(0).getImages().get(0).getAlt(), result.getHouseList().get(0).getImages().get(0).getAlt());

    }
    //TODO 케이스 별 검색 조건 추가

    @Test
    public void testTalk() throws Exception {
        int page = 1;
        int itemCount = 10;

        HouseTalkList list = api.getTalkList(testHouses.get(0).getHouseId(), itemCount, page);

        Assert.assertNotNull(list);
        Assert.assertTrue("size: " + list.getTalkList().size(), list.getTalkList().size() == 1);

        Assert.assertEquals(this.testTalk.getTalkId(), list.getTalkList().get(0).getTalkId());
        Assert.assertEquals(this.testTalk.getText(), list.getTalkList().get(0).getText());
        Assert.assertEquals(this.testTalk.getCreated(), list.getTalkList().get(0).getCreated());
        Assert.assertEquals(this.testTalk.getHouseId(), list.getTalkList().get(0).getHouseId());
        Assert.assertEquals(this.testTalk.getImages().size(), list.getTalkList().get(0).getImages().size());
        Assert.assertEquals(this.testTalk.getReplies().size(), list.getTalkList().get(0).getReplies().size());
        Assert.assertEquals(this.testTalk.getReplies().get(0).getReplyId(), list.getTalkList().get(0).getReplies().get(0).getReplyId());
        Assert.assertEquals(this.testTalk.getReplies().get(0).getText(), list.getTalkList().get(0).getReplies().get(0).getText());
        Assert.assertEquals(this.testTalk.getReplies().get(0).getUpdated(), list.getTalkList().get(0).getReplies().get(0).getUpdated());

    }
}

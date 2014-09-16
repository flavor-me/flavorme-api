package io.noah.flavorme.api.v1.db;

import io.noah.flavorme.api.MongoRepository;
import io.noah.flavorme.api.v1.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by chanwook on 2014. 9. 5..
 */
@MongoRepository
public class HouseSearchMongoRepository implements HouseSearchRepository {

    @Autowired
    private MongoTemplate mt;

    @Override
    public HouseList search(HouseSearchCriteria c) {
        Criteria mongoCriteria =
                where("houseName").regex(c.getQuery())
                        .where("grade").is(c.getGrade())
                        .where("category").is(c.getCategory());
        Query q = query(mongoCriteria).skip(c.getStartItem()).limit(c.getItemSize());

        List<House> houses = mt.find(q, House.class);
        HouseList list = new HouseList(c, houses);
        return list;
    }

    @Override
    public HouseTalkList getTalkList(long houseId, PageSupports pageParam) {
        Criteria c = where("houseId").is(houseId);
        Query q = query(c).skip(pageParam.getStartItem()).limit(pageParam.getItemSize());

        List<HouseTalk> talkList = mt.find(q, HouseTalk.class);
        return new HouseTalkList(houseId, talkList);
    }
}

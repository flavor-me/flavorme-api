package io.noah.flavorme.api.v1.db;

import io.noah.flavorme.api.v1.model.HouseList;
import io.noah.flavorme.api.v1.model.HouseSearchCriteria;
import io.noah.flavorme.api.v1.model.HouseTalkList;
import io.noah.flavorme.api.v1.model.PageSupports;

/**
 * Created by chanwook on 2014. 9. 5..
 */
public interface HouseSearchRepository {

    HouseList search(HouseSearchCriteria c);

    HouseTalkList getTalkList(long houseId, PageSupports pageParam);
}

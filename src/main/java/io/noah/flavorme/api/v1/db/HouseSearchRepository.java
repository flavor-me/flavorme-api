package io.noah.flavorme.api.v1.db;

import io.noah.flavorme.api.v1.model.HouseList;
import io.noah.flavorme.api.v1.model.HouseSearchCriteria;

/**
 * Created by chanwook on 2014. 9. 5..
 */
public interface HouseSearchRepository {

    HouseList search(HouseSearchCriteria c);
}

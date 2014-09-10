package io.noah.flavorme.api.v1;

import io.noah.flavorme.api.v1.db.HouseSearchRepository;
import io.noah.flavorme.api.v1.model.HouseList;
import io.noah.flavorme.api.v1.model.HouseSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chanwook on 2014. 9. 3..
 */
@Controller
@RequestMapping(value = "/v1")
public class HouseSearchApi {

    @Autowired
    private HouseSearchRepository searchRepository;

    @RequestMapping(value = "/houses", method = RequestMethod.GET)
    public String list() {
        return "v1/houselist/houselist";
    }

    @RequestMapping(value = "/house/search", method = RequestMethod.GET)
    @ResponseBody
    public HouseList search(HouseSearchCriteria c) {

        HouseList list = searchRepository.search(c);

        return list;
    }
}

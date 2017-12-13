package web.config.servlet;

import AJAX.AJAXRespondPod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONController {


    @ResponseBody
    @RequestMapping(value = "/search/api/getSearchResult")
    public AJAXRespondPod getSearchResultViaAjax(@RequestBody SearchCriteria search) {

        AJAXRespondPod result = new AJAXRespondPod();
        //logic
        return result;

    }

}

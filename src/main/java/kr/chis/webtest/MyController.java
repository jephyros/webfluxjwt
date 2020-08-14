package kr.chis.webtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author InSeok
 * Date : 2020-08-14
 * Remark :
 */
@RestController
public class MyController {
    @GetMapping("/")
    public String index(){
        return "WebTest - Restcontroller";
    }
}

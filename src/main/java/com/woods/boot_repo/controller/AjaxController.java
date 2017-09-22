package com.woods.boot_repo.controller;

import com.woods.boot_repo.combo.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Controller
public class AjaxController {
    @RequestMapping(value = "/ajxindex", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("msg", "SpringBoot Ajax 示例");

        return "ajx";
    }
    @RequestMapping(value = "/ajxdata", method = RequestMethod.POST)
    @ResponseBody
    public List<TestVO> data() {
        List<TestVO> list = new ArrayList<TestVO>();

        for (int i = 0; i < 10; i++) {
            TestVO user = new TestVO();
            user.setId(i + 1);
            user.setName("springboot" + i);
            user.setCode("male");

            list.add(user);
        }

        return list;
    }

}

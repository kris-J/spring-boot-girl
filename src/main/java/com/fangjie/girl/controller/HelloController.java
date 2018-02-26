package com.fangjie.girl.controller;

import com.fangjie.girl.bean.Gril;
import com.fangjie.girl.service.HelloService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
//1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
//例如：本来应该到success.jsp页面的，则其显示success.
//2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
//3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。

//@Controller
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    //value注解获取application.properties中的属性值
//    @Value("${globalSize}")
//    private String globalSize;

    @Autowired
    private Gril gril;

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String hello() {
        helloService.getTestData();
        return gril.getName() + "," + gril.getAge();
    }


    @RequestMapping(value = "index1/{id}", method = RequestMethod.GET)
    public String hello1(@PathVariable("id") Integer id) {
        return "ID:" + id;
    }

    @RequestMapping(value = "index2", method = RequestMethod.GET)
    public String hello2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "ID:" + id;
    }
}

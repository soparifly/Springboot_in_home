package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    /**
     * 웹개발방법
     * 1.   파일을 웹브라우저로 (정적컨텐츠)
     * 2. MVC 템플릿 엔진
     * html을 동적으로 변경해서
     * 3. API
     */
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!!!!!!!!!!!!");

        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model
                .addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
//header body 에서 body 포함될내용을 직접
    }
// 웹브라우저 -> 톰캣 -> 컨트롤러 -> @ResponseBody 객체(JSON) 기본정책으로 반환
//   HttpMessageConverter-> JsonConvert/StringConverter

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    /**
     * java 빈 규약
     * private 변수에 접근하기위한 방법
     * 프로퍼티 접근방식
     *
     */
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

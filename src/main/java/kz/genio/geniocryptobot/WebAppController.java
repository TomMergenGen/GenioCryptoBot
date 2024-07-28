package kz.genio.geniocryptobot;

import org.springframework.web.bind.annotation.GetMapping;

public class WebAppController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}

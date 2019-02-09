package agungdh.embohopoiki.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RootController {
	@RequestMapping("/")
    public String index() {
        return "Hello, World!";
    }
}

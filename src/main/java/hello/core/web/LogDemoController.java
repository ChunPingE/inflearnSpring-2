package hello.core.web;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import hello.core.common.*;
import jakarta.servlet.http.*;
import lombok.*;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
	private final LogDemoService logDemoService;
	private final MyLogger myLogger;

	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) {
		String requestURL = request.getRequestURL().toString();
		myLogger.setRequestURL(requestURL);
		myLogger.log("controller test");
		logDemoService.logic("testId");
		return "OK";
	}
}
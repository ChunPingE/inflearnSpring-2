package hello.core.web;

import org.springframework.stereotype.*;

import hello.core.common.*;
import lombok.*;

@Service
@RequiredArgsConstructor
public class LogDemoService {
	private final MyLogger myLogger;

	public void logic(String id) {
		myLogger.log("service id = " + id);
	}
}
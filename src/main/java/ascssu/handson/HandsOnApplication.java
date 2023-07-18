package ascssu.handson;

import ascssu.handson.Lambda.AdultJudgeResponse;
import ascssu.handson.Lambda.HandsOn;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class HandsOnApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandsOnApplication.class, args);
	}

	@Bean
	public Function<APIGatewayProxyRequestEvent, AdultJudgeResponse> lambdaApiGatewayFunctionBean() {
		return new HandsOn();
	}

}

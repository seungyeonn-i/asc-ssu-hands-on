package ascssu.handson.Lambda;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.function.Function;

@Component
@Slf4j
public class HandsOn implements Function<APIGatewayProxyRequestEvent, AdultJudgeResponse> {
    @Override
    public AdultJudgeResponse apply(APIGatewayProxyRequestEvent request) {

        UserRequest userRequest = new UserRequest();

        if (StringUtils.hasText(request.getBody())) {
            try {
                userRequest = new ObjectMapper().readValue(request.getBody(), UserRequest.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

            if (userRequest.getAge() > 20) {
                return new AdultJudgeResponse(userRequest.getName() + "은(는) 성인입니다.");
            }

                return new AdultJudgeResponse(userRequest.getName()  + "은(는) 성인이 아닙니다.");
            }
}
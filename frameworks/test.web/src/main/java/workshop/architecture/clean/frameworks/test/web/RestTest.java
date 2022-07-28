package workshop.architecture.clean.frameworks.test.web;

import com.google.common.collect.ImmutableMap;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Map;

public class RestTest {

    protected JsonResponse lastResponse;
    private @Resource TestRestTemplate testRestTemplate;

    protected JsonResponse post(String urlTemplate, Object body, Object... vars) {
        return exchange(getRequest(urlTemplate, body, vars, HttpMethod.POST));
    }

    protected JsonResponse put(String urlTemplate, Object body, Object... vars) {
        return exchange(getRequest(urlTemplate, body, vars, HttpMethod.PUT));
    }

    protected JsonResponse delete(String urlTemplate, Object... vars) {
        return exchange(getRequest(urlTemplate, null, vars, HttpMethod.DELETE));
    }

    protected JsonResponse get(String urlTemplate, Object... vars) {
        return get(urlTemplate, ImmutableMap.of(), vars);
    }

    protected JsonResponse get(String urlTemplate, Map<String, Object> params, Object... vars) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlTemplate);
        params.forEach(builder::queryParam);
        URI uri = builder.buildAndExpand(vars).encode().toUri();
        RequestEntity<?> request = new RequestEntity<>(new HttpHeaders(), HttpMethod.GET, uri);
        return exchange(request);
    }

    private RequestEntity<?> getRequest(String urlTemplate, Object body, Object[] vars, HttpMethod put) {
        URI uri = UriComponentsBuilder.fromUriString(urlTemplate).buildAndExpand(vars).encode().toUri();
        return new RequestEntity<>(body, new HttpHeaders(), put, uri);
    }

    private JsonResponse exchange(RequestEntity<?> request) {
        ResponseEntity<String> response = testRestTemplate.exchange(request, String.class);
        JsonResponse result = new JsonResponse(response);
        lastResponse = result;
        return result;
    }

}

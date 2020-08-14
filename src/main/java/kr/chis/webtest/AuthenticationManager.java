package kr.chis.webtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author InSeok
 * Date : 2020-08-14
 * Remark :
 */
@Component
@Slf4j
public class AuthenticationManager  implements ReactiveAuthenticationManager {
    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        log.info("===== : {}" ,authentication.getPrincipal().toString());
        // JwtAuthenticationToken is my custom token.
        //if (authentication instanceof JwtAuthenticationToken) {
            authentication.setAuthenticated(true);
        //}
        return Mono.just(authentication);
    }
}

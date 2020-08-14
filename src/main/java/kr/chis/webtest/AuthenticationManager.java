package kr.chis.webtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author InSeok
 * Date : 2020-08-14
 * Remark :
 */
@Component
@Slf4j
public class AuthenticationManager  implements ReactiveAuthenticationManager {
    @Override
    @SuppressWarnings("unchecked")
    public Mono<Authentication> authenticate(Authentication authentication) {
        String authToken = authentication.getCredentials().toString();

        //jwt 토근 검증 ?

        log.info("=======token : {}",authToken);
        log.info("=======principal : {}",authentication.getPrincipal().toString());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return Mono.just(new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),null,authorities));

        /*
        try {
			if (!jwtUtil.validateToken(authToken)) {
				return Mono.empty();
			}
			Claims claims = jwtUtil.getAllClaimsFromToken(authToken);
			List<String> rolesMap = claims.get("role", List.class);
			List<GrantedAuthority> authorities = new ArrayList<>();
			for (String rolemap : rolesMap) {
				authorities.add(new SimpleGrantedAuthority(rolemap));
			}
			return Mono.just(new UsernamePasswordAuthenticationToken(claims.getSubject(), null, authorities));
		} catch (Exception e) {
			return Mono.empty();
		}
         */
    }
}

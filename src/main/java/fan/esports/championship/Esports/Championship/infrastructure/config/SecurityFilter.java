package fan.esports.championship.Esports.Championship.infrastructure.config;

import fan.esports.championship.Esports.Championship.infrastructure.token.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    public SecurityFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if (Strings.isNotEmpty(authorization) && authorization.startsWith("Bearer ")) {
            
            String token = authorization.substring("Bearer ".length());
            
            Optional<JWTUserData> optionalJwtUserData = tokenService.verifyToken(token);

            if (optionalJwtUserData.isPresent()) {
                JWTUserData jwtUserData = optionalJwtUserData.get();
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(jwtUserData, null, null);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            
            filterChain.doFilter(request, response);
            
        }else{
            filterChain.doFilter(request, response);
        }
    }
}

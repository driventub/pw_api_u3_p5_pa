package uce.edu.pw_api_u3_p5_pa.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtils {

    @Value("${app.jwtSemilla}")
    private String jwtSemilla;


    public boolean validateJwtToken(String authToken){
        try {
            Jwts.parser().setSigningKey(this.jwtSemilla).parseClaimsJws(authToken);    
            return true;
        } catch (Exception e) {
            log.error("Error" , e);
        }
        
        return false;
    }

    public String getUsernameFromJwtToken(String token){
        return  Jwts.parser().setSigningKey(this.jwtSemilla).parseClaimsJws(token).getBody().getSubject();
    }
}

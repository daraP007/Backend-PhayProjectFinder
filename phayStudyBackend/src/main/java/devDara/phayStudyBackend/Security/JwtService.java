// package devDara.phayStudyBackend.Security;

// import java.sql.Date;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.function.Function;

// import javax.crypto.SecretKey;


// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Service;

// import io.jsonwebtoken.Claims;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.io.Decoders;
// import io.jsonwebtoken.security.Keys;


// @Service
// public class JwtService {

//     //KEY IN HEX VALUE
//     private static final String SECRET_KEY = "fa412692b0ef35e95a4437957333df62008fbffb147841ebaf5a4dbcb2323e2b";



//     public String grabUsername(String token){
//         return extractClaims(token, Claims::getSubject);
//     }
//     //grabs all the claims in the incoming data
//     public <T> T extractClaims(String token, Function<Claims,T> claimsResolver){
//         final Claims claims = extractAllClaims(token);
//         return claimsResolver.apply(claims);
//     }


//     //generate token:
//     public String generateToken( Map<String, Object> extractClaims, UserDetails userDetails){

//         return Jwts.builder()
//         .setClaims(extractClaims)
//         .setSubject(userDetails.getUsername()) //grabs the deatils
//         .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) //set how long the key last before expired
//         .signWith(getSigningKey(), SignatureAlgorithm.HS256) // uses the JWT algorithm with the our secret key
//         .compact(); //compacts the detail into the string
//     }

//     public String generateToken(UserDetails userDetails){
//         return generateToken(new HashMap<>(), userDetails);
//     }

//     private Claims extractAllClaims(String token){
//         return Jwts.parserBuilder()
//         .setSigningKey(getSigningKey())
//         .build()
//         .parseClaimsJws(token)
//         .getBody();
//         }

//     private SecretKey getSigningKey(){
//         byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
//         return Keys.hmacShaKeyFor(keyBytes); 
//     }


//     public boolean isTokenValid (UserDetails userDetails, String token){
//         String userName = grabUsername(token);

//         if (userName.equalsIgnoreCase(userDetails.getUsername()) && !isTokenExpire(token)){
//             return true;
//         }
//         return false;
//     }


//     private boolean isTokenExpire(String token) {
//         return extractExpiration(token).before(new Date(0));
//     }
    
//     private Date extractExpiration(String token) {
//         return (Date) extractClaims(token, Claims::getExpiration);
//     }


// }

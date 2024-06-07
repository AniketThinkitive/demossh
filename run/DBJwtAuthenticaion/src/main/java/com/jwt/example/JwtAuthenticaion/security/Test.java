package com.jwt.example.JwtAuthenticaion.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;


public class Test {

//    int expiry_time = 60 * 60 * 60;
    String secretKey = "jdjeudiksmdnfjrufjdkeisoelfkvjfnvhdmdjchdurhfjgmvnfkdoljcmvhgnjkjkfjdkfjkdjlkfjlkdsjlkfsdjlkfdjlkfjsdlkfjlkjdlkfsdjlkfjsdlkjfskdjf";

    public String GenerateToken() {
        return Jwts.builder()
                .setId("00")
                .setSubject("subject")
                .setIssuer("m")
                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + expiry_time * 1000))
                .setExpiration(new Date(System.currentTimeMillis()+10000))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    //
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}











//}
//    Test t = new Test();
//    String token = t.GenerateToken();
//
//
//		System.out.println(token);
//    Claims c=t.getClaims(token);
//		System.out.println(c.getId());
//		System.out.println(c.getSubject());
//		System.out.println(c.getExpiration());

//        public String getId(String key,String token){
//            return getClaims(key,token)
//                    .getId();
//        }
//
//        public String getSubject(String key,String token){
//            return getClaims(key,token)
//                    .getSubject();
//        }
//
//        public boolean isValid(String key,String token){
//            return getClaims(key,token)
//                    .getExpiration().after(new Date(System.currentTimeMillis()));
//        }


    //        UserDetails userDetails = userDetailsService.loadUserByUsername("Sambhaji");


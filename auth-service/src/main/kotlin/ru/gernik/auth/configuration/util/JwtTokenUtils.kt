package ru.gernik.auth.configuration.util

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

const val BEARER = "Bearer "
private const val JWT_TOKEN_VALIDITY = 5 * 60 * 60

@Component
class JwtTokenUtils {

    private val secret = "secret"

    fun getUserIdFromToken(token: String): String {
        return getAllClaimsFromToken(token).subject
    }

    fun getTokenFromHeader(requestTokenHeader: String): String {
        return requestTokenHeader.substring(BEARER.length)
    }

    fun isTokenExpired(token: String) = getAllClaimsFromToken(token).expiration.before(Date())

    private fun getAllClaimsFromToken(token: String): Claims {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body
    }

    fun generateToken(userDetails: UserDetails): String {
        val claims = HashMap<String, Any>()
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.username)
                .setIssuedAt(Date(System.currentTimeMillis()))
                .setExpiration(Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact()
    }
}
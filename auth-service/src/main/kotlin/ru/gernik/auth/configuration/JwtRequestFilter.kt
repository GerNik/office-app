package ru.gernik.auth.configuration

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import ru.gernik.auth.configuration.util.BEARER
import ru.gernik.auth.configuration.util.JwtTokenUtils
import ru.gernik.auth.service.JwtUserDetailsService
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtRequestFilter(val jwtTokenUtils: JwtTokenUtils,
                       val jwtUserDetailsService: JwtUserDetailsService) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val requestTokenHeader = request.getHeader("Authorization")
        if (requestTokenHeader != null && requestTokenHeader.startsWith(BEARER)) {

            val jwtToken = jwtTokenUtils.getTokenFromHeader(request.getHeader("Authorization"))
            val userLogin = jwtTokenUtils.getUserIdFromToken(jwtToken)
            if (!jwtTokenUtils.isTokenExpired(jwtToken) && SecurityContextHolder.getContext().authentication == null) {
                val userDetails = jwtUserDetailsService.loadUserByUsername(userLogin)

                val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.authorities)
                usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
            }
        } else {
            logger.warn("JWT Token does not begin with Bearer String")
        }
        filterChain.doFilter(request, response)
    }
}
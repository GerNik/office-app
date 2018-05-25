package ru.gernik.auth.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(user: User) : UserDetails {
    private var username: String
    private var password: String
    private var authorities: Collection<GrantedAuthority>

    override fun isEnabled(): Boolean = true

    override fun getUsername(): String = this.username

    override fun isCredentialsNonExpired(): Boolean = true

    override fun getPassword(): String = this.password

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun getAuthorities(): Collection<GrantedAuthority> = this.authorities

    init {
        this.username = user.login
        this.password = user.password

        val auth : ArrayList<GrantedAuthority> = ArrayList()
        for (role in user.roles)
            auth.add(SimpleGrantedAuthority(role.name))
        this.authorities = auth
    }
}
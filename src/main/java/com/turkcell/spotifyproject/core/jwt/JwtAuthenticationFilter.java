package com.turkcell.spotifyproject.core.jwt;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
//Gelen her isteği filtreleyen yapı OncePerRequestFilter
//OncePerRequestFilter,her istek için yalnızca bir kez çalıştırılmasını sağlar, bu da performans açısından önemlidir.
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
        //FilterChain bütün filtreleri alıyor
            throws ServletException, IOException {

        //JWT'ye ulaşmak => requestin header'ı
        final String authHeader = request.getHeader("Authorization");
        //Jwt yi aktif etmek için postman üzerinden (Bearer ) yazarız.
        // kullanıcı auth header göndermedi ya da geçersiz bir header gönderdi
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            //bu isteği doğrudan sonraki filtrelere iletmek için filterChain.doFilter(request, response) çağrısı yapar.
            filterChain.doFilter(request, response);
            return;
        }

        //(Bearer ) Bearer ve boşluk(Bearer 6 hane + 1 boşluk = 7 hane) toplamda 7 karakter olduğu için 7 yazdık.
        //Jwt'yi çıkarmak için substring kullandık. Çünkü Bearer 112kokjıj21311 gibi buraya bir token geliyor Bearer dan sonra.
        final String jwt = authHeader.substring(7);
        //JWT token çıkartıldıktan sonra, bu token ile ilişkilendirilmiş olan kullanıcı adını alır. Bu adım, jwtService.extractUsername(jwt) metodunu kullanarak yapılır.
        final String username = jwtService.extractUsername(jwt);
        //Eğer kullanıcı adı geçerliyse ve kullanıcı daha önce kimlik doğrulama işleminden geçmemişse
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            //Kullanıcı adına göre kullanıcı bilgilerini veritabanından alır. Bu, kullanıcının kimliğini doğrulamak için gereklidir.
            UserDetails user = userDetailsService.loadUserByUsername(username);
            //JWT token'ın geçerli olup olmadığını kontrol eder. Token süresi geçmemişse ve token kullanıcı ile ilişkilendirilmişse, bu token geçerlidir.
            if (jwtService.isTokenValid(jwt, user)) {
                // Giriş işlemleri
                //Bu, kimlik doğrulama işlemi için kullanılır ve kullanıcının kimliğini ve yetkilerini temsil eder.
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                //Bu, kimlik doğrulama işlemine ek bilgileri ekler, bu da kullanıcı oturumunun IP adresini ve diğer ayrıntıları içerebilir.
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // Bu, kullanıcıyı güvenlik bağlamına ekler, böylece kullanıcının yetkilendirilmiş istekler yapabilmesine olanak tanır.
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        //Filtrenin işlemi tamamlanmış ve filtrenin geri kalanını içeren filtrelere devam edilmesini sağlayan filterChain.doFilter(request, response) çağrısı yapılır.
        filterChain.doFilter(request, response);
    }
}

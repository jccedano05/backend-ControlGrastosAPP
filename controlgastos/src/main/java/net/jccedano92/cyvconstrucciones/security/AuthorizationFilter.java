package net.jccedano92.cyvconstrucciones.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;


public class AuthorizationFilter extends BasicAuthenticationFilter{
	
public AuthorizationFilter( AuthenticationManager authenticationManager) {
		
		super(authenticationManager);
	}
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		String header = request.getHeader(SecurityConstants.HEADER_STRING);  //traemos del request el header de header_string

		if( header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) { //si viene vacio o si no empieza con el prefijo que pusimos "Bearer" entra
			chain.doFilter(request, response); //pasamos al siguiente filtro toda la request y response
			return;
		}
		
		
		//ya teniendo el token creamos un usua
		
		UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(request); //extraemos el token con este metodo
		
		SecurityContextHolder.getContext().setAuthentication(authenticationToken); //le decimos al contexto de nuestra aplicacion que le setearemos el token 
		
		
		chain.doFilter(request, response);
		
	}
	
	
	
	
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token =  request.getHeader(SecurityConstants.HEADER_STRING);

		if( token != null) {
			token = token.replace(SecurityConstants.TOKEN_PREFIX, ""); //quitamos el prefijo bearer para que quede el token puro
			//en la variable usuario asignamos el key secreto de nuestro token y tambien le pasamos el token al correo que tenemos en el subjet
			String user = Jwts.parser().setSigningKey(SecurityConstants.TOKEN_SECRET).parseClaimsJws(token).getBody().getSubject();
			
			if(user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>()); 
			}
			
			return null;
		}
		
		return null;
	}
	

}

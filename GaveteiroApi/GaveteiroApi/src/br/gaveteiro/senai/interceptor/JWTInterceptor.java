package br.gaveteiro.senai.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.auth0.jwt.JWTVerifier;

import br.gaveteiro.senai.controller.UsuarioRestController;
import br.gaveteiro.senai.dao.PermissaoDao;
import br.gaveteiro.senai.dao.UsuarioDao;


public class JwtInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private PermissaoDao permissaoDao;

	@CrossOrigin
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(handler.getClass().getSimpleName());
		// TODO Auto-generated method stub
		HandlerMethod method;
		if(handler instanceof HandlerMethod)
		{
			method = (HandlerMethod) handler;	

			System.out.println("M�todo: " + method.getMethod().getName() + "\nController: "
								      + method.getBean().getClass().getSimpleName());
			if (request.getRequestURI().contains("login") || request.getRequestURI().contains("senha/recuperar"))
			{
				return true;
			} else {
				String token = request.getHeader("Authorization");
				try {
					JWTVerifier verifier = new JWTVerifier(UsuarioRestController.SECRET);
					Map<String, Object> claims = verifier.verify(token);
					System.out.println(claims);
					String controller = method.getBean().getClass().getTypeName();
					String action = method.getMethod().getName();
				    Long idUsuario = Long.parseLong(claims.get("id_usuario").toString());
				    request.setAttribute("id", idUsuario);	
					if (permissaoDao.validar(controller, action, usuarioDao.listar(idUsuario).getTipoUsuario()))
						return true;
					else
						response.sendError(HttpStatus.UNAUTHORIZED.value());
						return false;
						//return true;
				} catch (Exception e) {
					e.printStackTrace();
					if (token != null)
						response.sendError(HttpStatus.UNAUTHORIZED.value());
					else
						response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			
	}
}

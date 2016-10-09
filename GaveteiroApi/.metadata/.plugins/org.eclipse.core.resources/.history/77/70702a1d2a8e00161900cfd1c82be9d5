package br.gaveteiro.senai.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWTSigner;

import br.gaveteiro.senai.dao.EmpresaDao;
import br.gaveteiro.senai.dao.TipoUsuarioDao;
import br.gaveteiro.senai.dao.UsuarioDao;
import br.gaveteiro.senai.modelo.Empresa;
import br.gaveteiro.senai.modelo.TipoUsuario;
import br.gaveteiro.senai.modelo.Usuario;

@RestController
public class UsuarioRestController {
	public static final String SECRET = "gaveteirosenai";
	public static final String ISSUER = "http//www.gaveteiro.com.br";
	
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private EmpresaDao empresaDao;
	@Autowired
	private  TipoUsuarioDao tipoUsuarioDao;
	
	@Transactional
	@RequestMapping(value = "/usuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Usuario>  inserir(@RequestBody String strUsuario)
	{
		try 
	 {
			JSONObject job = new JSONObject(strUsuario);
			Usuario usuario = new Usuario();
			usuario.setNome(job.getString("nome"));
			usuario.setEmail(job.getString("email"));
			usuario.setCpf(job.getString("cpf"));
			usuario.setRg(job.getString("rg"));
			usuario.setLogin(job.getString("login"));
			usuario.setSenha(job.getString("senha"));
			usuario.setSexo(job.getString("sexo").charAt(0));
			usuario.setTelefone(job.getString("telefone"));
			Empresa empresa = empresaDao.listar(job.optLong("idEmpresa"));
			usuario.setEmpresa(empresa);
			TipoUsuario tipo = tipoUsuarioDao.listar(job.getLong("idTipoUsuario"));
			usuario.setTipoUsuario(tipo);
			usuarioDao.inserir(usuario);
			URI location = new URI("/usuario/"+usuario.getIdUsuario());
			return ResponseEntity.created(location).body(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public List<Usuario> listar()
	{
		return usuarioDao.listar();
	}
	
	
	@RequestMapping(value = "/usuario/{idUsuario}", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Usuario> listar(@PathVariable Long idUsuario){
		try {
			Usuario usuario = usuarioDao.listar(idUsuario);
			return ResponseEntity.ok(usuario);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/empresa/{idEmpresa}/usuario", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Usuario> listarPorEmpresa(@PathVariable Long idEmpresa){
		System.out.println(idEmpresa);
		return usuarioDao.listarPorEmpresa(idEmpresa);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> logar(@RequestBody Usuario usuario)
	{
		try {
			usuario = usuarioDao.logar(usuario);
			if(usuario != null){
				//Data de emissão do token (issued at)
				long iat = System.currentTimeMillis()/100;
				//data de expiração do token
				long exp = iat + 3600;
				//Objeto que irá gerar o token
				JWTSigner signer = new JWTSigner(SECRET);
				HashMap<String, Object> claims = new HashMap<>();
				claims.put("iat", iat);
				claims.put("exp", exp);
				claims.put("iss", ISSUER);
				claims.put("id_usuario", usuario.getIdUsuario());
				//gerar o token
				String jwt = signer.sign(claims);
				JSONObject token = new JSONObject();
				token.put("token", jwt);
				return ResponseEntity.ok(token.toString());
			}else{
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

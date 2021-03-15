package accesodatos;

import java.util.TreeMap;

import modelos.Usuario;

public class UsuarioDaoTreeMap implements Dao<Usuario> {

	private static TreeMap<Long, Usuario> usuarios = new TreeMap<>();

	static {
		usuarios.put(1L, new Usuario(1L, "veronica@gmail.com", "pass"));
		usuarios.put(2L, new Usuario(2L, "ana@gmail.com", "pass"));

	}

	// SINGLETON
	private UsuarioDaoTreeMap() {
	}

	private static UsuarioDaoTreeMap INSTANCIA = new UsuarioDaoTreeMap();

	public static UsuarioDaoTreeMap getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON

	@Override
	public Iterable<Usuario> obtenerTodos() {
		return usuarios.values();
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		return usuarios.get(id);
	}

	@Override
	public void creat(Usuario usuario) {
		Long id = usuarios.size() == 0 ? 1L : usuarios.lastKey() + 1L;
		usuario.setId(id);
		usuarios.put(id, usuario);

	}

	@Override
	public void modificar(Usuario usuario) {
		usuarios.put(usuario.getId(), usuario);
	}

	@Override
	public void eliminar(Long id) {
		usuarios.remove(id);

	}
	// Método específico de este DAO

	public Usuario obtenerPorEmail(String email) {
		for (Usuario usuario : usuarios.values()) {
			if (usuario.getEmail().equals(email)) {
				return usuario;
			}
		}

		return null;
	}

//		public Usuario obtenerPorEmail(String email) {
//			Usuario resultado = null;
//			
//			for(Usuario usuario: usuarios.values()) {
//				if(usuario.getEmail().equals(email)) {
//					resultado = usuario;
//					break;
//				}
//			}
//			
//			return resultado;
//		}
}

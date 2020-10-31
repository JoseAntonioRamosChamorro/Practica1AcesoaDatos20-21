import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;



public class ListaDeLaCompra implements Serializable{

	private static final long serialVersionUID = 1L;

	String NombreLista;
	ArrayList<ArticuloAComprar>ListaCompra = new ArrayList<ArticuloAComprar>();

	public ListaDeLaCompra() {
		NombreLista ="";

	}
	public ListaDeLaCompra(String nombreLista) {
		NombreLista = nombreLista;
	}
	public String getNombreLista() {
		return NombreLista;

	}
	public void setNombreLista(String nombreLista) {
		NombreLista = nombreLista;
	}
	/*
	 */
	public void agregarProductoAComprar(ArticuloAComprar articulo) {
		ListaCompra.add(articulo);

	}
	/*
	 */
	public void eliminarArticulo (String descripcionArticulo){
		for (int i = 0; i < ListaCompra.size(); i++) {
			eliminarIgual(descripcionArticulo,ListaCompra.get(i));
		}
	}

	private void eliminarIgual(String descripcionArticulo, ArticuloAComprar articuloAComprar) {
		if (articuloAComprar.getDescripcion().equals(descripcionArticulo)) {
			ListaCompra.remove(articuloAComprar);
		}

	}


	public ArrayList<ArticuloAComprar> getArticulos(){
		return ListaCompra;
	}
	public void almacenarListaCompra() {
		try {
			File archivoAlmacenar = new File(".\\"+NombreLista+".txt");
			FileOutputStream fos = new FileOutputStream(archivoAlmacenar);
			ObjectOutputStream salida = new ObjectOutputStream(fos);	

			salida.writeObject(this);
			salida.close();
			fos.close();


		}catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			System.out.println("Error de escritura");
		}

	}

	public static ListaDeLaCompra recuperarListaCompra(String archivo) {
		ListaDeLaCompra listaRecuperada = new ListaDeLaCompra(archivo);
		try {
			File archivoRecuperar = new File(".\\"+archivo+".txt");
			FileInputStream fis = new FileInputStream(archivoRecuperar);
			ObjectInputStream entrada = new ObjectInputStream(fis);	

			listaRecuperada = (ListaDeLaCompra) entrada.readObject();
			System.out.println("Recuperado "+archivo);
			entrada.close();
			fis.close();
		}catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			System.out.println("Error de recuperación");
		}
		return listaRecuperada;
	}

}

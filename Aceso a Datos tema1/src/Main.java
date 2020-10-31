
public class Main {
	public static void main(String[] args) {
		
		/*-- crear articulos--*/
		ArticuloAComprar artPlatano = new ArticuloAComprar("Platano",3,"Unidad");
		ArticuloAComprar artHuevoL = new ArticuloAComprar("Huevo L",1,"L");
		ArticuloAComprar artPechuga = new ArticuloAComprar("Pollo",1,"KG");
		ArticuloAComprar artHelado = new ArticuloAComprar("Helado",1,"Paquete");
		
		/*--Lista--*/
		ListaDeLaCompra lista1 = new ListaDeLaCompra("Mercadona");
		ListaDeLaCompra lista2 = new ListaDeLaCompra("Lidl");
		
		
		/*--Agregar a Lista--*/
		lista1.agregarProductoAComprar(artPlatano);
		lista1.agregarProductoAComprar(artHuevoL);
		lista1.agregarProductoAComprar(artPechuga);
		
		lista2.agregarProductoAComprar(artHelado);
		
		
		/*Articulos de las listas */

		System.out.println("Los articulos de la lista "+ lista1.getNombreLista()+" son:");
		for (ArticuloAComprar articulo : lista1.getArticulos()) {

			System.out.println(articulo.getDescripcion()+" - "+articulo.getCantidad()+" - "+articulo.getUnidad());
		
		}
		System.out.println("Los articulos de la lista "+ lista2.getNombreLista()+" son:");
		
		for (ArticuloAComprar articulo : lista2.getArticulos()) {

			System.out.println(articulo.getDescripcion()+" - "+articulo.getCantidad()+" - "+articulo.getUnidad());
		
		}
		System.out.println();
		lista1.almacenarListaCompra();
		

		lista2.almacenarListaCompra();
		ListaDeLaCompra.recuperarListaCompra("Mercadona");
		ListaDeLaCompra.recuperarListaCompra("Lidl");
	}
}

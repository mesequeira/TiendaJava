package menues;

import java.util.Scanner;

import leerEscribir.Archivo;
import programa.Usuarios;
import programa.AddArticulos;
import programa.Usuario;
import leerEscribir.Archivo;

public class MenuOpciones {

	
	public void cargarUsuario(Usuarios usuarios, String rutaUsuarios) {
		Archivo archi = new Archivo();
		Scanner sc = new Scanner(System.in);

			System.out.println("Ingrese el nombre del usuario a ingresar (0 para salir)");
			String username = sc.next();
			
			if(username.equals("0")) {
				return;
			}
			
			System.out.println("Ingrese la contrase�a del usuario a ingresar");
			String password = sc.next();
			
			System.out.println("Ingrese el nick del usuario a ingresar");
			String nick = sc.next();
			
			
			if(   usuarios.addUsuario(username, password, nick)     ) {
				System.out.println("El usuario se cre� perfectamente");
				archi.save(usuarios, rutaUsuarios);
			}else {
				System.out.println("Ya existe un usuario con ese nombre");
			}
	}
	
	public void cargarArticulo(AddArticulos articulo, String rutaArticulos) {
		Archivo archi = new Archivo();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese el c�digo del articulo: ");
		int codigo = sc.nextInt();
		
		if (codigo <0) {
			do {
				System.out.println("El codigo no puede ser menor a 0: ");
				codigo = sc.nextInt();
			}while(codigo < 0);
		}
		

		System.out.println("Ingrese el nombre del art�culo (Apret� 0 para terminar): ");
		String nombre = sc.next();
			
			if(nombre.equals("0")) {
				return;
			}
			
			
			System.out.println("Ingrese el precio del art�culo: ");
			double precio = sc.nextDouble();
			
			if (precio < 0) {
				do {
					System.out.println("El precio no puede ser menor a 0: ");
					precio = sc.nextDouble();
				}while(precio < 0);
			}
			
			System.out.println("Ingrese la cantidad del art�culo: ");
			int cantidad = sc.nextInt();
			
			if(cantidad < 0) {
				do {
					System.out.println("La cantidad no puede ser menor a 0: ");
					cantidad = sc.nextInt();
				}while(cantidad < 0);
			}
			
			if(articulo.addArticulos(codigo, nombre, precio, cantidad)) {
				System.out.println("El art�culo con el nombre "+nombre+" se cre� correctamente");
				archi.save(articulo, rutaArticulos);
			}else {
				System.out.println("El art�culo con el nombre "+nombre+" ya existe. Intente con otro.");
			}
	}
	
	
	
	
	public Usuario ingresar(Usuarios usuarios) {
		Scanner sc = new Scanner(System.in);
		
		String username;
		do  {
		System.out.println("Ingrese el nombre de usuario");
		username = sc.next();
		
		
		
		if(!usuarios.existeUsuario(username)) {
			System.out.println("No existe el usuario\n");
			
		}
		
		} while(!usuarios.existeUsuario(username)); 
		
		Usuario usu = usuarios.getUsuario(username);
		
		

		
		System.out.println("Ingrese la clave de usuario");
		String password = sc.next();
		
		
		
		if(usu.isClave(password)) {
			return usu;
		}
		return null;
		
		
		
		
	}
	
	
	
	
	
	
}

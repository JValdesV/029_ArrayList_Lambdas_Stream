package cl.empresa.principal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		List<String> elementos = new ArrayList<String>();
		
		elementos.add("Juan");
        elementos.add("María");
        elementos.add("Carlos");
        elementos.add("Ana");
        elementos.add("Luis");
        elementos.add("Laura");
        elementos.add("Pedro");
        elementos.add("SofíA");
        elementos.add("Miguel");
        elementos.add("Elena");
        elementos.add("Javier");
        elementos.add("Isabel");
        elementos.add("Andrés");
        elementos.add("Patricia");
        elementos.add("Alejandro");
        elementos.add("Carmen");
        elementos.add("Ricardo");
        elementos.add("Lorena");
        elementos.add("Diego");
        elementos.add("Natalia");
        
        
        
        
        
		
		/*
		for(String elemento: elementos) {
			System.out.println(elemento);
		}
		*/
		
		//Tenemos que crear una clase anonima para poder utilizar el foreach
		Consumer<String> imprime = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);				
			}
			
		};
		
		//Lambda
		//(parametros)->expresion
		
		//elementos.forEach((t)->{System.out.println(t);});
		//elementos.forEach(elemento->System.out.println(elemento));
		//elementos.forEach((elemento)->System.out.println(elemento));
		//elementos.forEach((elemento)->{System.out.println(elemento);});
		
		//Streams
		
		List<Trabajador> trabajadores = new ArrayList<>();
		trabajadores.add(new Trabajador(1,"Juan", 45000.0));
        trabajadores.add(new Trabajador(2,"María", 52000.0));
        trabajadores.add(new Trabajador(3,"Carlos", 48000.0));
        trabajadores.add(new Trabajador(4,"Ana", 51000.0));
        trabajadores.add(new Trabajador(5,"Luis", 49000.0));
		
		Stream<Trabajador> stTrabajador = trabajadores
										  .stream()
										  .limit(3); 
		
		stTrabajador.forEach(System.out::println);
		
		separadorDeSeccion(20);
		
		List<Trabajador> limitTrabajadores = trabajadores.stream().limit(3).collect(Collectors.toList());
		limitTrabajadores.forEach(trabajador->System.out.println(trabajador));
 		
		separadorDeSeccion(20);
		
		//Filtrar por letra de inicio del campo nombre
		List<Trabajador> filtrarPorLetraNombre = trabajadores
											     .stream()
											     .filter(trabajador->trabajador.getNombre().toLowerCase().startsWith("a"))
											     .collect(Collectors.toList());
		
		filtrarPorLetraNombre.forEach(System.out::println);
		
		separadorDeSeccion(20);
		
		//Filtrar por rango de sueldo
		List<Trabajador> filtraPorRangoDeSueldo = trabajadores
												  .stream()
												  .filter(trabajador->trabajador.getSueldo()>=45000 && trabajador.getSueldo()<=49000)
												  .collect(Collectors.toList());
		filtraPorRangoDeSueldo.forEach(System.out::println);
		
		separadorDeSeccion(20);
		//Contar la cantidad de trabajadores que cumplen con criterio de filtro en el sueldo
		long cantidad = trabajadores
						.stream()
						.filter(t->t.getSueldo()>=45000)
						.filter(t->t.getSueldo()<=49000)
						.count();
		
		System.out.println(cantidad);
		
		separadorDeSeccion(20);
		
		//Determinar el salario minimo y maximo de una lista de trabajadores
		Optional<Trabajador> minSueldoTrabajador = trabajadores
												   .stream()
												   .min((t1,t2)->Double.compare(t1.getSueldo(), t2.getSueldo()));
		if(minSueldoTrabajador.isPresent()) {
			System.out.println(minSueldoTrabajador);
		}
		
		separadorDeSeccion(20);
		
		Optional<Trabajador> maxSueldoTrabajador = trabajadores
												  .stream()
												  .max((t1,t2)->Double.compare(t1.getSueldo(), t2.getSueldo()));
		if(maxSueldoTrabajador.isPresent()) {
			System.out.println(maxSueldoTrabajador);
		}
		
		separadorDeSeccion(20);
		
		//Determinar el salario minimo y maximo de una lista de trabajadores con Comparator
		Trabajador minTrabajador = trabajadores
								   .stream()
								   .min(Comparator.comparingDouble(t->t.getSueldo()))
								   .get();
		
		System.out.println(minTrabajador);
		
		assertEquals(trabajadores.get(0),  minTrabajador);
		
		separadorDeSeccion(20);
		
		Trabajador maxTrabajador = trabajadores
				   .stream()
				   .max(Comparator.comparingDouble(t->t.getSueldo()))
				   .get();
		
		System.out.println(maxTrabajador);
		
		assertEquals(trabajadores.get(1),  maxTrabajador);

	}
	
	
	public static void separadorDeSeccion(int cantidad) {
		for(int i=0; i<cantidad; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}
	

}

	








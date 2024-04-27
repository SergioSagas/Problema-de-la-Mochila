package com.mycompany.main_mochila;
import java.util.ArrayList;
import java.util.Scanner;

class Objeto {
    String nombre;
    String forma;
    double peso;
    double precio;

    public Objeto(String nombre, String forma, double peso, double precio) {
        this.nombre = nombre;
        this.forma = forma;
        this.peso = peso;
        this.precio = precio;
    }
}

public class Main_mochila {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Objeto> objetos = generarObjetos();
        System.out.print("Ingrese el peso maximo de la mochila en kg: ");
        double capacidad = scanner.nextDouble();
        ArrayList<Objeto> seleccionados = seleccionarObjetos(objetos, capacidad);
        mostrarResultados(seleccionados);
    }
    public static ArrayList<Objeto> generarObjetos() {
        //Crear objetos
        ArrayList<Objeto> objetos = new ArrayList<>();
        //Agregando objetos
        objetos.add(new Objeto("Toalla", "Rectangular", 3, 40));
        objetos.add(new Objeto("Pelota de mascota", "Circular", 1, 20));
        objetos.add(new Objeto("Laptop", "Rectangular", 2, 2000));
        objetos.add(new Objeto("Cargador", "Rectangular", 1, 80));
        objetos.add(new Objeto("Snacks", "Cuadrado", 1, 10));
        objetos.add(new Objeto("Casaca", "Circular", 1, 150));
        objetos.add(new Objeto("Botella de agua grande", "Circular", 2, 10));
        objetos.add(new Objeto("Cuaderno", "Rectangular", 1, 7));
        objetos.add(new Objeto("Cartuchera", "Rectangular", 2, 20));
        objetos.add(new Objeto("Protector solar", "Circular", 1, 40));
        objetos.add(new Objeto("Lentes", "Circular", 1, 80));
        objetos.add(new Objeto("Llaves", "Circular", 1, 8));
        objetos.add(new Objeto("Galletas", "Rectangular", 1, 5));
        objetos.add(new Objeto("Folder", "Rectangular", 1, 10));
        objetos.add(new Objeto("Tablet", "Rectangular", 1, 800));
        objetos.add(new Objeto("Altavoz inalambrico", "Circular", 3, 50));
        return objetos;
    }

    public static ArrayList<Objeto> seleccionarObjetos(ArrayList<Objeto> objetos, double capacidad) {
        // Ordenar objetos por valor por unidad de peso (precio / peso)
        objetos.sort((o1, o2) -> Double.compare(o2.precio / o2.peso, o1.precio / o1.peso));
        ArrayList<Objeto> seleccionados = new ArrayList<>();
        double pesoActual = 0;
        double valorTotal = 0;
        for (Objeto obj : objetos) {
            if (pesoActual + obj.peso <= capacidad) {
                seleccionados.add(obj);
                pesoActual += obj.peso;
                valorTotal += obj.precio;
            }
        }
        if (seleccionados.size() < 1) {
            System.out.println("No es posible seleccionar un mínimo de 15 objetos con la capacidad dada.");
            return new ArrayList<>();
        }
        
        return seleccionados;
    }
    public static void mostrarResultados(ArrayList<Objeto> seleccionados) {
        double precioTotal = 0;
        double pesoTotal = 0;
        System.out.println("Objetos seleccionados en la mochila:");
        for (Objeto obj : seleccionados) {
            System.out.println(obj.nombre + " - Peso: " + obj.peso + ", Precio: " + obj.precio);
            precioTotal += obj.precio;
            pesoTotal += obj.peso;
            
        }
        System.out.println("Precio total de los objetos dentro de la mochila: " + precioTotal + " soles");
        System.out.println("Peso total de los objetos dentro de la mochila: " + pesoTotal + " kg");
    }
}

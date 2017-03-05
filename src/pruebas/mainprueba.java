/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import modelo.Articulo;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author Joaquin
 */
public class mainprueba {

    public static void main(String[] args) {
        ODB odb = ODBFactory.open("C:\\Users\\Joaquin\\Documents\\NetBeansProjects\\ODB\\src\\neodatis.test");

//        Articulo a1 = new Articulo(1, "nombre", "descripcion", 2.75,1);
//        Articulo a2 = new Articulo(2, "nombre2", "descripcion2", 2.75,1);
//        Articulo a3 = new Articulo(3, "nombre3", "descripcion3", 2.75,1);
//        Articulo a4 = new Articulo(4, "nombre4", "descripcion4", 2.75,1);
//        Articulo a5 = new Articulo(5, "nombre5", "descripcion5", 2.75,1);
//        Articulo a6 = new Articulo(6, "nombre6", "descripcion6", 2.75,1);
//
//        odb.store(a1);
//        odb.store(a2);
//        odb.store(a3);
//        odb.store(a4);
//        odb.store(a5);
//        odb.store(a6);

        Objects<Articulo> objects = odb.getObjects(Articulo.class);
        Articulo art = new Articulo();
        int i = 1;
        while (objects.hasNext()) {
            art = objects.next();
            System.out.println("ID: " + art.getId() + " Nombre: " + art.getNombre() + " descripcion: " + art.getDescripcion() + " Precion: " + art.getPrecio());
        }
        art = null;

        System.out.println("Borrado de articulo 4");
        IQuery query = new CriteriaQuery(Articulo.class, Where.equal("id", 4));
        Objects<Articulo> objects2 = odb.getObjects(query);
        art = objects2.getFirst();
        odb.delete(art);
        art = null;
        objects = odb.getObjects(Articulo.class);
        while (objects.hasNext()) {
            art = objects.next();
            System.out.println("ID: " + art.getId() + " Nombre: " + art.getNombre() + " descripcion: " + art.getDescripcion() + " Precion: " + art.getPrecio());
        }
        System.out.println("Modificacion de Articulo 6");
        IQuery queryUpdate = new CriteriaQuery(Articulo.class, Where.equal("id", 6));
        Objects<Articulo> objects3 = odb.getObjects(queryUpdate);
        Articulo art2 = (Articulo) odb.getObjects(queryUpdate).getFirst();
        art2.setNombre("To modificao");
        odb.store(art2);

        art = null;
        objects = odb.getObjects(Articulo.class);
        while (objects.hasNext()) {
            art = objects.next();
            System.out.println("ID: " + art.getId() + " Nombre: " + art.getNombre() + " descripcion: " + art.getDescripcion() + " Precion: " + art.getPrecio());
        }
        odb.close();
    }

}

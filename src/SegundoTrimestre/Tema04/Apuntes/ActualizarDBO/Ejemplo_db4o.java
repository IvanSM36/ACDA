package SegundoTrimestre.Tema04.Apuntes.ActualizarDBO;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Ejemplo_db4o {

    public static void main(String[] args) {
        
        // Creamos la conexión
        ObjectContainer db = Db4oEmbedded.openFile("personas.db4o");

        // Obtenemos el objeto deseado
        Persona p = new Persona("Fernando", 0, 0, 0);
        ObjectSet<Persona> result = db.queryByExample(p);

        // Si existe el objeto
        if (result.hasNext()) {
            // Obtengo el objeto persona
            Persona pAct = result.next();

            // Actualizo el objeto
            pAct.setEdad(35);
            
            // Guardamos el objeto de nuevo, actualizandolo
            db.store(pAct);
        }
        
        //Obtenemos y mostramos todos los objetos
        p = new Persona();
        result = db.queryByExample(p);

        while (result.hasNext()) {
            System.out.println(result.next());
        }

        // Cerramos la clase
        db.close();
        
    }

}
